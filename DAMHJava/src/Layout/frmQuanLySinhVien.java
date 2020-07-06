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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tnam1
 */
public class frmQuanLySinhVien extends javax.swing.JPanel {

    /**
     * Creates new form frmSinhVien
     */
    Database db;
    public frmQuanLySinhVien() {
        initComponents();
        db =new Database();
        NapBangLopVaoComboBox();
        NapDuLieuTrinhDoVaoCbTrinhDo();
        NapDuLieutblSinhVienVaoTable();
        SetButtonDefault();
        SetInputDefault();
        SetCleanInput();
    }
      private void SetButtonDefault()
    {
        btnThem.setEnabled(true);
        btnReset.setEnabled(true);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(false);
        btnSua.setEnabled(false);
    }
    private void SetButtonThucThiSuaXoa()
    {
        btnThem.setEnabled(false);
        btnReset.setEnabled(true);
        btnXoa.setEnabled(true);
        btnLuu.setEnabled(false);
        btnSua.setEnabled(true);
    }
    private void SetButtonThem()
    {
        btnThem.setEnabled(false);
        btnReset.setEnabled(true);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(true);
        btnSua.setEnabled(false);
    }
    private void SetCleanInput()
    {
        txtTenSV.setText("");
        txtDiachi.setText("");
        txtEmail.setText("");
        txtMaSV.setText("");
        txtNgSinh.setDate(null);
        txtTimkiem.setText("");
        txtMatkhau.setText("");
        txtSdt.setText("");
        txtTaikhoan.setText("");
        cbTrinhDo.setSelectedIndex(0);
        cbLop.setSelectedIndex(0);
    }
     private void SetCleanInputAdd()
    {
        txtTenSV.setText("");
        txtDiachi.setText("");
        txtEmail.setText("");
        txtMaSV.setText("");
        txtNgSinh.setDate(null);
        txtTimkiem.setText("");
        txtMatkhau.setText("");
        txtSdt.setText("");
        txtTaikhoan.setText("SV");
        cbTrinhDo.setSelectedIndex(0);
        cbLop.setSelectedIndex(0);
    }
    private void SetInputDefault()
    {
        txtMaSV.setEditable(false);
        txtTenSV.setEditable(false);
        txtDiachi.setEditable(false);
        txtEmail.setEditable(false);
        txtNgSinh.setEnabled(false);
        txtMatkhau.setEditable(false);
        txtSdt.setEditable(false);
        txtTaikhoan.setEditable(false);
    }
    private void SetInputAdd()
    {
        txtMaSV.setEditable(false);
        txtTenSV.setEditable(true);
        txtDiachi.setEditable(true);
        txtEmail.setEditable(true);
        txtNgSinh.setEnabled(true);
        txtMatkhau.setEditable(true);
        txtMatkhau.setVisible(true);
        txtSdt.setEditable(true);
         lblMatkhau.setVisible(true);
         txtTaikhoan.setEditable(true);
    }
    private void SetInputSuaXoa()
    {
        txtMaSV.setEditable(false);
        txtTenSV.setEditable(true);
        txtDiachi.setEditable(true);
        txtEmail.setEditable(true);
        txtNgSinh.setEnabled(true);
        txtMatkhau.setEditable(false);
        txtMatkhau.setVisible(false);
        lblMatkhau.setVisible(false);
        txtSdt.setEditable(true);
        txtTaikhoan.setEditable(true);
    }
     private void NapBangLopVaoComboBox()
    {
        try {
            String sSQL = "SELECT TenLop FROM Lop  ";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
            cbLop.addItem("Chọn Lớp:");
            while(rs.next())
            {
                cbLop.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        }
        
    }
      private void NapDuLieuTrinhDoVaoCbTrinhDo()
    {
         try {
            String sSQL = "SELECT TenTrinhDo FROM TrinhDo WHERE IdTrinhDo in (1,2,3)";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không thể truy cập CSDL");
                return;
            }
            cbTrinhDo.addItem("Chọn Trình độ:");
            while(rs.next())
            {
                cbTrinhDo.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Truy DBConect Thất bại");
        }
    }
         private void NapDuLieutblSinhVienVaoTable()
    {
        try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "	SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' , TenLop as N'Lớp' FROM tblNguoiDung, TrinhDo , Lop WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdLop=Lop.IdLop and tblNguoiDung.IdQuyen = 3";
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
            tblSinhVien.setModel(modelTable);
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Truy cập DBConnect Thất bại");
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
        txtMaSV = new javax.swing.JTextField();
        txtTenSV = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNgSinh = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiachi = new javax.swing.JTextArea();
        cbTrinhDo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTaikhoan = new javax.swing.JTextField();
        txtMatkhau = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        lblMatkhau = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbLop = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        txtTimkiem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1055, 578));
        setPreferredSize(new java.awt.Dimension(1055, 578));

        jPanel1.setBackground(new java.awt.Color(51, 0, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Sinh Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập dữ liệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 14))); // NOI18N

        txtDiachi.setColumns(20);
        txtDiachi.setRows(5);
        jScrollPane1.setViewportView(txtDiachi);

        jLabel2.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel2.setText("Mã Sinh Viên");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel3.setText("Tên Sinh Viên");

        jLabel4.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel5.setText("Ngày Sinh");

        jLabel6.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel6.setText("Địa chỉ");

        jLabel8.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel8.setText("Trình Độ");

        jLabel9.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel9.setText("Lớp");

        jLabel7.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel7.setText("Tài Khoản");

        lblMatkhau.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        lblMatkhau.setText("Mật khẩu");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel12.setText("Sdt");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSdt)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtTenSV)
                    .addComponent(txtEmail))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTaikhoan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatkhau)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatkhau)
                    .addComponent(cbTrinhDo, 0, 111, Short.MAX_VALUE)
                    .addComponent(cbLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cbTrinhDo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNgSinh, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(txtMaSV)))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 14))); // NOI18N

        btnThem.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        btnSua.setText("Sửa ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 14))); // NOI18N

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSinhVien);

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel11.setText("Tên Sinh viên");

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(59, 59, 59))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        getAccessibleContext().setAccessibleDescription("");
        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        SetButtonDefault();
        SetCleanInput();
        SetInputDefault();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        SetButtonThem();
        SetCleanInputAdd();
        SetInputAdd();
    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          String timkiem = txtTimkiem.getText().toString();
        if(timkiem.equals(""))
        {
             JOptionPane.showMessageDialog(this,"Vùi lòng nhập thông tin môn học cần tìm");
               NapDuLieutblSinhVienVaoTable();
                    SetInputDefault();
                    SetCleanInput();
                    SetButtonDefault();
        }
        else
        {
            try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "SELECT IdNguoiDung as N'Mã Người Dùng',MaNguoiDung as N'Tài khoản', HoTen as N'Họ và Tên', NgaySinh as N'Ngày Sinh', DiaChi as N'Địa Chỉ', Sdt as N'Số điện thoại',Email, TenTrinhDo as N'Trình Độ' FROM tblNguoiDung, TrinhDo  WHERE tblNguoiDung.IdTrinhDo=TrinhDo.IdTrinhDo and tblNguoiDung.IdQuyen = 3 and HoTen like N'%"+timkiem+"%'";
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
            if(modelTable.getRowCount() > 0)
            {
                tblSinhVien.setModel(modelTable);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Không tìm thấy");
                NapDuLieutblSinhVienVaoTable();
                SetButtonDefault();
                SetCleanInput();
                SetInputDefault();
                txtTimkiem.setText("");
            }
            } catch (SQLException ex) {
                //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,"Truy cập DBConnect Thất bại");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
      private void NapItemDuocChon()
    { 
        try {
            if (tblSinhVien.getSelectedRow() < 0) {
                return;
            }
            int row = tblSinhVien.getSelectedRow();
            txtMaSV.setText(tblSinhVien.getValueAt(row, 0).toString());
            txtTaikhoan.setText((String)tblSinhVien.getValueAt(row, 1));
            txtTenSV.setText(tblSinhVien.getValueAt(row, 2).toString()); 
            txtNgSinh.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblSinhVien.getValueAt(row, 3).toString()));
            txtDiachi.setText(tblSinhVien.getValueAt(row, 4).toString());
            txtSdt.setText(tblSinhVien.getValueAt(row, 5).toString());
            txtEmail.setText(tblSinhVien.getValueAt(row, 6).toString());
            for(int i=0;i<cbTrinhDo.getItemCount();i++)
                if(cbTrinhDo.getItemAt(i).equals((String)tblSinhVien.getValueAt(row, 7)))
                    cbTrinhDo.setSelectedIndex(i);
            for(int i=0;i<cbTrinhDo.getItemCount();i++)
                if(cbLop.getItemAt(i).equals((String)tblSinhVien.getValueAt(row, 8)))
                    cbLop.setSelectedIndex(i);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,"Lỗi lấy dữ liệu");
        }
    }
    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
        NapItemDuocChon();
        SetButtonThucThiSuaXoa();
        SetInputSuaXoa();
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String tengiao = txtTenSV.getText().toString();
        String  diachi = txtDiachi.getText().toString();
        String sdt = txtSdt.getText().toString();
        String email = txtEmail.getText().toString();
        String date = "";
        Date ns = txtNgSinh.getDate();
        String pattern = "yyyy-MM-dd"; //01/24/1980
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        date = simpleDateFormat.format(ns);
        int bc = cbTrinhDo.getSelectedIndex();
        String taikhoan = txtTaikhoan.getText().toString();
        String matkhau = txtMatkhau.getText().toString();
        int lop=0;
        try {
            String sSQL = "SELECT IdLop FROM Lop WHERE TenLop =N'"+cbLop.getSelectedItem().toString()+"'";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
             while(rs.next())
            {
                lop = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        }
        if(taikhoan.equals("") && matkhau.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Vùi lòng nhập tài khoản người dùng và mật khẩu");
            txtTaikhoan.setText("SV");
        }
        else if(bc == 0)
        {
            JOptionPane.showMessageDialog(this,"Vui lòng chọn trình độ");
        }
         else if(lop == 0)
        {
            JOptionPane.showMessageDialog(this,"Vui lòng chọn lop");
        }
        else if(tengiao.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Vùi lòng nhập tên giáo viên");
        }
        else
        {
            String SQL ="INSERT INTO tblNguoiDung(MaNguoiDung,MatKhau,HoTen,NgaySinh,DiaChi,Sdt,Email,IdTrinhDo,IdLop,IdQuyen) VALUES(N'"+taikhoan+"','"+matkhau+"',N'"+tengiao+"','"+date+"', N'"+diachi+"','"+sdt+"','"+email+"',"+bc+","+lop+",3)";
            int i = db.ThemXoaSua(SQL);
            if(i > 0)
                    {
                        JOptionPane.showMessageDialog(this,"Thêm mới thành công");
                        NapDuLieutblSinhVienVaoTable();
                        SetInputDefault();
                        SetCleanInput();
                        SetButtonDefault();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Thêm mới thất bại");
                        NapDuLieutblSinhVienVaoTable();
                        SetInputDefault();
                        SetCleanInput();
                        SetButtonDefault();
                    }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (tblSinhVien.getSelectedRow() < 0) { 
            JOptionPane.showMessageDialog(this,"Phải chọn một dòng để sửa hoặc xóa!");
            return;
        }
        int row = tblSinhVien.getSelectedRow();
        int maSV = (int)tblSinhVien.getValueAt(row, 0);
         String tengiao = txtTenSV.getText().toString();
        String  diachi = txtDiachi.getText().toString();
        String sdt = txtSdt.getText().toString();
        String email = txtEmail.getText().toString();
        String date = "";
        Date ns = txtNgSinh.getDate();
        String pattern = "yyyy-MM-dd"; //01/24/1980
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        date = simpleDateFormat.format(ns);
        int bc = cbTrinhDo.getSelectedIndex();
        String taikhoan = txtTaikhoan.getText().toString();
        String matkhau = txtMatkhau.getText().toString();
        int lop=0;
        try {
            String sSQL = "SELECT IdLop FROM Lop WHERE TenLop =N'"+cbLop.getSelectedItem().toString()+"'";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
             while(rs.next())
            {
                lop = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        }
        if(taikhoan.equals("") && matkhau.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Vùi lòng nhập tài khoản người dùng và mật khẩu");
            txtTaikhoan.setText("SV");
        }
        else if(bc == 0)
        {
            JOptionPane.showMessageDialog(this,"Vui lòng chọn trình độ");
        }
         else if(lop == 0)
        {
            JOptionPane.showMessageDialog(this,"Vui lòng chọn lop");
        }
        else if(tengiao.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Vùi lòng nhập tên giáo viên");
        }
        else
        {
            String SQL ="UPDATE tblNguoiDung SET HoTen = N'"+tengiao+"', NgaySinh='"+date+"', DiaChi=N'"+diachi+"', Sdt='"+sdt+"' , Email='"+email+"',IdLop='"+lop+"', IdTrinhDo='"+bc+"',MaNguoiDung='"+taikhoan+"' WHERE IdNguoiDung = "+maSV+"";
            int i = db.ThemXoaSua(SQL);
            if(i > 0)
                    {
                        JOptionPane.showMessageDialog(this,"Cập nhập thành công");
                        NapDuLieutblSinhVienVaoTable();
                        SetInputDefault();
                        SetCleanInput();
                        SetButtonDefault();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Cập nhập thất bại");
                        NapDuLieutblSinhVienVaoTable();
                        SetInputDefault();
                        SetCleanInput();
                        SetButtonDefault();
                    }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
         if (tblSinhVien.getSelectedRow() < 0) { 
            JOptionPane.showMessageDialog(this,"Phải chọn một dòng để sửa hoặc xóa!");
            return;
        }
        int row = tblSinhVien.getSelectedRow();
        int maSV = (int)tblSinhVien.getValueAt(row, 0);
        String SQL ="	DELETE FROM tblNguoiDung WHERE IdNguoiDung = "+maSV+"";
            int i = db.ThemXoaSua(SQL);
            if(i > 0)
                    {
                        JOptionPane.showMessageDialog(this,"Xóa thành công");
                        NapDuLieutblSinhVienVaoTable();
                        SetInputDefault();
                        SetCleanInput();
                        SetButtonDefault();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Xóa thất bại");
                        NapDuLieutblSinhVienVaoTable();
                        SetInputDefault();
                        SetCleanInput();
                        SetButtonDefault();
                    }
        
    }//GEN-LAST:event_btnXoaActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLop;
    private javax.swing.JComboBox<String> cbTrinhDo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMatkhau;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextArea txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JPasswordField txtMatkhau;
    private com.toedter.calendar.JDateChooser txtNgSinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTaikhoan;
    private javax.swing.JTextField txtTenSV;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
