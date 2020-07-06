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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Tnam1
 */
public class frmSVDangKyHocPhan extends javax.swing.JPanel {

    /**
     * Creates new form frmSVDangKyHocPhan
     */
    Database db;
    public  String ktra ="";
    public frmSVDangKyHocPhan() {
        initComponents();
        db =new Database();
//        KiemTraXemDaDangKyChua();
        NapDuLieuHocPhanVaoTable();
        NapDuLieuKhoaVaoCbTrinhDo();
    }
     private void NapDuLieuKhoaVaoCbTrinhDo()
    {
         try {
            String sSQL = "SELECT TenKhoa FROM Khoa";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không thể truy cập CSDL");
                return;
            }
            cbKhoa.addItem("Chọn Khoa:");
            while(rs.next())
            {
                cbKhoa.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Truy DBConect Thất bại");
        }
    }
       private void NapDuLieuHocPhanVaoTable()
    {
        try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',   TenHocKi as N'Học Kì', SoTinChi as N'Tín Chỉ' , (SoTien * SoTinChi) as N'Học Phí', SiSoHienTai as N'Số lượng Sinh Viên', SoTiet as N'Số Tiết',  tblNguoiDung.HoTen as N'Giảng viên', NgayBatDau as N' Ngày Bắt Đầu', NgayKetThuc as N'Ngày Kết Thúc'\n" +
"	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi \n" +
"	where DangKy.IdGV=tblNguoiDung.IdNguoiDung \n" +
"		  and DangKy.IdHocKi = HocKi.IdHocKi \n" +
"		  and DangKy.IdMonHoc=MonHoc.IdMonHoc \n" +
"		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian\n" +
"		  and DangKy.IdPhong = PhongHoc.IdPhong\n" +
"		  and DangKy.IdThu = Thu.IdThu and Status = 1";
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
            tblHocPhan.setModel(modelTable);
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Truy cập DBConnect Thất bại");
        }
    }
     private void KiemTraXemDaDangKyChua()
    {

        try {
            String checkDaDangKy = "SELECT Count(*) as N'SL' FROM DangKyHocPhan WHERE IdSV = 2";
            ResultSet check = db.TruyVan(checkDaDangKy);
            if(check == null)
            {
                JOptionPane.showMessageDialog(this,"Không thể truy cập CSDL");
                 return;
            }
            while(check.next())
            {
                ktra = check.getString(1);
            }
            if(!ktra.equals("0"))
            {
                DefaultTableModel modelTable = new DefaultTableModel();
                String sSelect = "SELECT DangKy.IdDangKy , MonHoc.TenMonHoc, MonHoc.SoTinChi, (MonHoc.SoTien * MonHoc.SoTinChi), 'Đã Lưu', 1  FROM DangKy,MonHoc,DangKyHocPhan, ThoiKhoaBieu WHERE DangKy.IdDangKy =ThoiKhoaBieu.IdDangKy and DangKyHocPhan.IdDangKyHP=ThoiKhoaBieu.IdDangKyHP and DangKy.IdMonHoc =MonHoc.IdMonHoc and DangKyHocPhan.IdSV ="+DangNhap.IdTk+"";
                ResultSet rs = db.TruyVan(sSelect);
                if(rs == null)
                {
                    JOptionPane.showMessageDialog(this,"Không thể truy cập CSDL");
                    return;
                }
                ResultSetMetaData md = rs.getMetaData();
                int numCols = md.getColumnCount();
                Object []arr = new Object[numCols];
                
//                for(int i=0;i<numCols;i++)
//                {
//                    arr[i]=md.getColumnName(i+1);  
//                }
//                modelTable.setColumnIdentifiers(arr);

                while(rs.next())
                {
                    for(int i=0;i<numCols;i++)
                         arr[i]=rs.getObject(i+1);
                    modelTable.addRow(arr);
                }
                tblDangKyHP.setModel(modelTable);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(frmSVDangKyHocPhan.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        txtMonHoc = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbKhoa = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocPhan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDangKyHP = new javax.swing.JTable();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblHocPhi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTinChi = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG KÝ HỌC PHẦN");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel2.setText("Lọc Theo Môn Học");

        btnTim.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        btnTim.setText("Lọc >>");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel3.setText("Lọc Theo Khoa");

        cbKhoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKhoaItemStateChanged(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblHocPhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHocPhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHocPhanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHocPhan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblDangKyHP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HP", "Tên Môn Học", "STC", "Học Phí", "Trạng Thái", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDangKyHP.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tblDangKyHP);
        tblDangKyHP.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnLuu.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        btnLuu.setText("Lưu Đăng Ký");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel5.setText("Tổng Học Phí :");

        lblHocPhi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblHocPhi.setForeground(new java.awt.Color(51, 0, 255));
        lblHocPhi.setText("10,0000,000 đ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel7.setText("Số Tín Chỉ:");

        lblTinChi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTinChi.setText("13");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 404, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnLuu)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTinChi)
                                .addGap(217, 217, 217)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lblHocPhi)
                                .addGap(184, 184, 184))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblHocPhi)
                    .addComponent(jLabel7)
                    .addComponent(lblTinChi))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel4.setText("Danh sách môn đã chọn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMonHoc)
                            .addComponent(cbKhoa, 0, 228, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addComponent(btnTim)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void tblHocPhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHocPhanMouseClicked
        // TODO add your handling code here:
        NapItemDuocChon();
    }//GEN-LAST:event_tblHocPhanMouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String timkiem = txtMonHoc.getText();
        if(timkiem.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm");
            NapDuLieuHocPhanVaoTable();
        }
        else
        {
            try {
                DefaultTableModel modelTable = new DefaultTableModel();
                String sSelect = "SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',   TenHocKi as N'Học Kì', SoTinChi as N'Tín Chỉ' , (SoTien * SoTinChi) as N'Học Phí', SiSoHienTai as N'Số lượng Sinh Viên', SoTiet as N'Số Tiết',  tblNguoiDung.HoTen as N'Giảng viên', NgayBatDau as N' Ngày Bắt Đầu', NgayKetThuc as N'Ngày Kết Thúc'\n" +
    "	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi \n" +
    "	where DangKy.IdGV=tblNguoiDung.IdNguoiDung \n" +
    "		  and DangKy.IdHocKi = HocKi.IdHocKi \n" +
    "		  and DangKy.IdMonHoc=MonHoc.IdMonHoc \n" +
    "		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian\n" +
    "		  and DangKy.IdPhong = PhongHoc.IdPhong\n" +
    "		  and DangKy.IdThu = Thu.IdThu and Status = 1 and TenMonHoc like N'%"+timkiem+"%'";
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
                if(modelTable.getRowCount() > 0 )
                {
                    tblHocPhan.setModel(modelTable);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Truy vấn ko tìm thấy");
                    NapDuLieuHocPhanVaoTable();
                    txtMonHoc.setText("");
                }
            } catch (SQLException ex) {
                //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,"Truy cập DBConnect Thất bại");
            }
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void cbKhoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKhoaItemStateChanged
        // TODO add your handling code here:
        if(cbKhoa.getSelectedIndex() == 0)
        {
//            JOptionPane.showMessageDialog(this,"Vùi lòng chọn khoa");
            NapDuLieuHocPhanVaoTable();
        }
        else
        {
             try {
                DefaultTableModel modelTable = new DefaultTableModel();
                String sSelect = "SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng',   TenHocKi as N'Học Kì', SoTinChi as N'Tín Chỉ' , (SoTien * SoTinChi) as N'Học Phí', SiSoHienTai as N'Số lượng Sinh Viên', SoTiet as N'Số Tiết',  tblNguoiDung.HoTen as N'Giảng viên', NgayBatDau as N' Ngày Bắt Đầu', NgayKetThuc as N'Ngày Kết Thúc'\n" +
"	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi , Khoa\n" +
"	where DangKy.IdGV=tblNguoiDung.IdNguoiDung \n" +
"		  and DangKy.IdHocKi = HocKi.IdHocKi \n" +
"		  and DangKy.IdMonHoc=MonHoc.IdMonHoc \n" +
"		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian\n" +
"		  and DangKy.IdPhong = PhongHoc.IdPhong\n" +
"		  and Khoa.IdKhoa = MonHoc.IdKhoa\n" +
"		  and DangKy.IdThu = Thu.IdThu and Status = 1 and TenKhoa like N'%"+cbKhoa.getSelectedItem().toString()+"%'";
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
                if(modelTable.getRowCount() > 0 )
                {
                    tblHocPhan.setModel(modelTable);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Truy vấn ko tìm thấy");
//                    NapDuLieuHocPhanVaoTable();
//                    cbKhoa.setSelectedIndex(0);
                }
            } catch (SQLException ex) {
                //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,"Truy cập DBConnect Thất bại");
            }
        }
    }//GEN-LAST:event_cbKhoaItemStateChanged

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if(tblDangKyHP.getSelectedRow() < 0)
        {
            return;
        }
        TableModel model2 =  tblDangKyHP.getModel();
        DefaultTableModel model1 = (DefaultTableModel)tblDangKyHP.getModel();
        int Rows = tblDangKyHP.getRowCount();
        for(int i=0;i< Rows; i++)
        {
            if((boolean)model1.getValueAt(i, 5) == true)
            {
                model1.removeRow(i);
            }
          
        }    
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        try {
            // TODO add your handling code here:
            if(tblDangKyHP.getSelectedRow() < 0)
            {
                return;
            }
            String checkDaDangKy = "SELECT Count(*) as N'SL' FROM DangKyHocPhan WHERE IdSV = 2";
            ResultSet check = db.TruyVan(checkDaDangKy);
            if(check == null)
            {
                JOptionPane.showMessageDialog(this,"Không thể truy cập CSDL");
                return;
            }
            while(check.next())
            {
                ktra = check.getString(1);
            }
            if(!ktra.equals("0"))
            {
                TableModel model2 =  tblDangKyHP.getModel();
                DefaultTableModel model1 = (DefaultTableModel)tblDangKyHP.getModel();
                int Rows = tblDangKyHP.getRowCount();
                int tinchi=0; float tongtien=0;
                List<String> list = new ArrayList<String>();
                for(int i=0;i< Rows; i++)
                {
                    if((boolean)model1.getValueAt(i, 5) == true)
                    {
                        
                        list.add(model1.getValueAt(i, 0).toString());
                        tinchi = tinchi+ Integer.parseInt(model1.getValueAt(i, 2).toString()) ;
                        tongtien = tongtien+ Float.parseFloat(model1.getValueAt(i, 3).toString()) ;
                    }
                    
                }
                
                String SQL = "INSERT INTO DangKyHocPhan(IdSV,Status,HocPhi) VALUES('"+DangNhap.IdTk+"','0','"+tongtien+"')";
                int i2 = db.LayID(SQL);
                int them =0;
                for(String idHP : list)
                {
                    String SQL1 = "INSERT INTO ThoiKhoaBieu(IdDangKy,IdDangKyHP)VALUES('"+idHP+"','"+i2+"')";
                    them = db.ThemXoaSua(SQL1);
                }
                if(them > 0)
                {
                    JOptionPane.showMessageDialog(this, "Thêm Thành Công");
                    new MainSV().DongHocPhi();
                }
                
                
            }else{
                JOptionPane.showMessageDialog(this, "Bạn đã đăng ký học phần rồi!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmSVDangKyHocPhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLuuActionPerformed
     private void NapItemDuocChon()
    { 
        if (tblHocPhan.getSelectedRow() < 0) {
            return;
        }
        TableModel model1 = tblHocPhan.getModel();
        int indexs[] = tblHocPhan.getSelectedRows();
        Object[] row =new Object[6];
        int tinchi=0; float tongtien=0;
        DefaultTableModel model2 = (DefaultTableModel)tblDangKyHP.getModel();
        for(int i=0;i< indexs.length; i++)
        {
                row[0]= model1.getValueAt(indexs[i], 0);
                row[1]= model1.getValueAt(indexs[i], 1);
                row[2] = model1.getValueAt(indexs[i], 7);
                row[3] = model1.getValueAt(indexs[i], 8);
                row[4] = "Chưa lưu vào CSDL";
                row[5]= false;
                int  arr = tblDangKyHP.getModel().getRowCount();
                for(int j =0;j< arr; j++)
                {
                    if(model2.getValueAt(j, 0).toString().equals(row[0].toString()))
                    {
                        JOptionPane.showMessageDialog(this, "Đã Tồn Tại");
                        model2.removeRow(j);
                    }
                }
                model2.addRow(row);
                
        }  
        TableModel model12 = tblDangKyHP.getModel();
        int indexs12 = tblDangKyHP.getRowCount();
        for(int j=0;j< indexs12; j++)
        {
            tinchi = tinchi+ Integer.parseInt(model12.getValueAt(j, 2).toString()) ; 
            tongtien = tongtien+ Float.parseFloat(model12.getValueAt(j, 3).toString()) ; 
        }
        lblHocPhi.setText(""+tongtien);
        lblTinChi.setText(""+tinchi);       
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHocPhi;
    private javax.swing.JLabel lblTinChi;
    private javax.swing.JTable tblDangKyHP;
    private javax.swing.JTable tblHocPhan;
    private javax.swing.JTextField txtMonHoc;
    // End of variables declaration//GEN-END:variables
}
