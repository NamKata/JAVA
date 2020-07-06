/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tnam1
 */
public class Database {
    private final String s_ClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    private final String s_URL = "jdbc:sqlserver://localhost:1433;databaseName=DangKyHocPhan";   
    private String username = "sa";
    private String password = "981211";
    private Connection con;
    public Database()
    {
        try {
            Class.forName(s_ClassName);
            con = DriverManager.getConnection(s_URL,username,password);           
//            JOptionPane.showMessageDialog(null,"Ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ket noi khong thanh cong!");
        }  
    }
    public boolean KetNoi()
    {   
        try {
            Class.forName(s_ClassName);
            con = DriverManager.getConnection(s_URL,username,password);           
//            JOptionPane.showMessageDialog(null,"Ket noi thanh cong");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ket noi khong thanh cong");
            return false;
        }  
    }
    
    public ResultSet TruyVan(String sqlCommand)
    {
        Statement st = null;
        ResultSet rs = null;
        try {       
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Thuc thi truy van khong thanh cong:\n" + sqlCommand);
        } 
        return rs;
    }
    
    public int ThemXoaSua(String sqlCommand)
    {
        Statement st = null;
        int d = 0;
        try {       
            st = con.createStatement();
            d = st.executeUpdate(sqlCommand);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Thuc thi them xoa sua khong thanh cong:\n" + sqlCommand);
        }
        if(d==0)
            JOptionPane.showMessageDialog(null,"Thuc thi them xoa sua khong thanh cong:\n" + sqlCommand);
        return d;
    }
     public int LayID(String sqlCommand)
    {
        Statement st = null;
        int d = 0; int id =0;
        try {       
            st = con.createStatement();
            d = st.executeUpdate(sqlCommand, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()){
                id= Integer.parseInt(rs.getString(1)) ;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Thuc thi them xoa sua khong thanh cong:\n" + sqlCommand);
        }
        if(id==0)
            JOptionPane.showMessageDialog(null,"Thuc thi them xoa sua khong thanh cong:\n" + sqlCommand);
        return id;
    }
    
    public boolean ThucThi(String sSQL)
    {
        Statement st = null;
        boolean isSuccessed = false;
        try {
            isSuccessed = st.execute(sSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccessed;
    }
}
