/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

import DBConnect.Database;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tnam1
 */
public class frmDongHocPhi extends javax.swing.JPanel {

    /**
     * Creates new form frmDongHocPhi
     */
    Database db;
    public frmDongHocPhi() {
        initComponents();
        db =new Database();
        NapThongTinSinhVien();
        NapHocPhi();
        NapDuLieutblLichGiangVaoTable();
    }
    private void NapThongTinSinhVien()
    {
            String sSQL = "SELECT MaNguoiDung as N'Mã Sinh Vien', HoTen as N'Họ Tên', (SELECT TenKhoa FROM Khoa,Lop,tblNguoiDung WHERE Khoa.IdKhoa=Lop.IdLop and Lop.IdLop = tblNguoiDung.IdLop and tblNguoiDung.IdNguoiDung = a.IdNguoiDung) as N'Khoa', TenTrinhDo as N'Hệ Đào Tạo', TenLop as N'Lớp' From tblNguoiDung as a, Lop,  TrinhDo WHERE a.IdTrinhDo = TrinhDo.IdTrinhDo and a.IdLop = Lop.IdLop and a.IdNguoiDung = '"+DangNhap.IdTk+"'";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không thể truy cập CSDL");
                return;
            }
        try {
            while(rs.next())
            {
                lblMSSV.setText(rs.getString(1));
                lblHoTen.setText(rs.getString(2));
                lblTen.setText(rs.getString(3));
                lblDaiHoc.setText(rs.getString(4));
                lblLop.setText(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmDongHocPhi.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
      private void NapDuLieutblLichGiangVaoTable()
    {
        try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "	SELECT TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',  (SELECT Distinct HoTen From tblNguoiDung as a, DangKy b WHERE b.IdGV = a.IdNguoiDung and b.IdGV = DangKy.IdGV) as N'Giảng Viên', TenHocKi as N'Học Kì' ,  SoTiet as N'Số Tiết', NgayBatDau as N'Ngày Bắt Đầu', NgayKetThuc as N'Ngày Kết Thúc'\n" +
"	From DangKy,DangKyHocPhan,ThoiKhoaBieu, PhongHoc,Thu,ThoiGianHoc,MonHoc, HocKi \n" +
"	where DangKy.IdDangKy=ThoiKhoaBieu.IdDangKy and \n" +
"		DangKyHocPhan.IdDangKyHP = ThoiKhoaBieu.IdDangKyHP \n" +
"		  and DangKy.IdHocKi = HocKi.IdHocKi \n" +
"		  and DangKy.IdMonHoc=MonHoc.IdMonHoc \n" +
"		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian\n" +
"		  and DangKy.IdPhong = PhongHoc.IdPhong\n" +
"		  and DangKy.IdThu = Thu.IdThu \n" +
"		  and DangKyHocPhan.IdSV ="+DangNhap.IdTk+"";
            ResultSet rs = db.TruyVan(sSelect);
            if(rs == null)
            {
                JOptionPane.showMessageDialog(this,"Không thể truy cập CSDL");
                return;
            }
            ResultSetMetaData md = rs.getMetaData();
            int numCols = md.getColumnCount();
            Object []arr = new Object[numCols];
            for(int i=0;i<numCols;i++)
            {
                arr[i]=md.getColumnName(i+1);  
            }
            modelTable.setColumnIdentifiers(arr);
            
            while(rs.next())
            {
                for(int i=0;i<numCols;i++)
                    arr[i]=rs.getObject(i+1);
                modelTable.addRow(arr);
            }
            tblHocPhi.setModel(modelTable);
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Truy cập DBConnect Thất bại 33");
        }
    }
       private void NapHocPhi()
    {
         try {
            String sSQL = "SELECT HocPhi, Status FROM DangKyHocPhan WHERE IdSV = '"+DangNhap.IdTk+"'";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không thể truy cập CSDL");
                lblHocPhi.setText("0 vnđ");
                lblTinhTrang.setText("Cập Nhập");
                return;
            }
            while(rs.next())
            {
                if(rs.getString(2).equals("0"))
                {
                    lblTinhTrang.setText("Chưa Đóng Học");
                }
                else
                {
                    lblTinhTrang.setText("Đã Đóng Học");
                }
                
                lblHocPhi.setText(rs.getString(1)+" vnđ");
//                lblTinhTrang.setText(rs.getString(2));
           }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Truy DBConect Thất bại 1");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblMSSV = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblDaiHoc = new javax.swing.JLabel();
        lblLop = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocPhi = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        lblHocPhi = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTinhTrang = new javax.swing.JLabel();
        btnInHocPhi = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐÓNG HỌC PHÍ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 2, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel2.setText("Mã Sinh Viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel3.setText("Tên Sinh Viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel4.setText("Khoa");

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel5.setText("Hệ Đào Tạo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel6.setText("Lớp");

        lblMSSV.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblMSSV.setForeground(new java.awt.Color(255, 0, 0));
        lblMSSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMSSV.setText("SV001");

        lblHoTen.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(255, 0, 0));
        lblHoTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoTen.setText("Trần Tiến Nam");

        lblTen.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        lblTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTen.setText("Công Nghệ Thông Tin ");

        lblDaiHoc.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        lblDaiHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDaiHoc.setText("Đại học");

        lblLop.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        lblLop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLop.setText("16DTHA3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMSSV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDaiHoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblMSSV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblHoTen))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTen))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblDaiHoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblLop))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(306, 306, 306))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblHocPhi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblHocPhi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHocPhi);

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Tổng Tiền ");

        lblHocPhi.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        lblHocPhi.setForeground(new java.awt.Color(255, 0, 0));
        lblHocPhi.setText("5,000,000 vnđ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 0, 255));
        jLabel14.setText("Tình Trạng");

        lblTinhTrang.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        lblTinhTrang.setForeground(new java.awt.Color(255, 0, 0));
        lblTinhTrang.setText("Chưa đóng học phí");

        btnInHocPhi.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        btnInHocPhi.setText("In Học Phí");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(lblHocPhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(267, 267, 267)
                .addComponent(btnInHocPhi)
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblTinhTrang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHocPhi)
                    .addComponent(jLabel12)
                    .addComponent(btnInHocPhi))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHocPhi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDaiHoc;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblHocPhi;
    private javax.swing.JLabel lblLop;
    private javax.swing.JLabel lblMSSV;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTinhTrang;
    private javax.swing.JTable tblHocPhi;
    // End of variables declaration//GEN-END:variables
}
