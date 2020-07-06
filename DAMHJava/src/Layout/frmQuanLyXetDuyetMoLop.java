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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tnam1
 */
public class frmQuanLyXetDuyetMoLop extends javax.swing.JPanel {

    /**
     * Creates new form frmQuanLyXetDuyetMoLop
     */
    Database db;
    public frmQuanLyXetDuyetMoLop() {
        initComponents();
        db =new Database();
        NapDuLieuXetMonDangKyVaoTable();
        NapBangBuoivaoCbBuoi();
        NapBangHocKivaoCbHocKi();
        NapBangPhongvaoCbPhong();
        NapBangThuvaoCbThu();
        NapBangMonvaoCbMon();
        NapBangGiangVienvaoCbGiangVien();
    }
     private void NapBangHocKivaoCbHocKi()
    {
        try {
            String sSQL = "SELECT TenHocKi  FROM HocKi ";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
            cbHocKi.addItem("Chọn Học Kì:");
            while(rs.next())
            {
                cbHocKi.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        } 
    }
    private void NapBangGiangVienvaoCbGiangVien()
    {
        try {
            String sSQL = "SELECT HoTen FROM tblNguoiDung WHERE IdQuyen=2";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
            cbGiangVien.addItem("Chọn Giáo Viên:");
            while(rs.next())
            {
                cbGiangVien.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        } 
    }
    private void NapBangThuvaoCbThu()
    {
        try {
            String sSQL = "SELECT TenThu FROM Thu";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
            cbThu.addItem("Chọn Thứ:");
            while(rs.next())
            {
                cbThu.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        } 
    }
     private void NapBangPhongvaoCbPhong()
    {
        try {
            String sSQL = "SELECT TenPhong FROM PhongHoc";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
            cbPhong.addItem("Chọn Phòng:");
            while(rs.next())
            {
                cbPhong.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        } 
    }
      private void NapBangBuoivaoCbBuoi()
    {
        try {
            String sSQL = "SELECT (Buoi+' | '+TietBD) as N'Buổi' FROM ThoiGianHoc";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
            cbBuoi.addItem("Chọn Buổi:");
            while(rs.next())
            {
                cbBuoi.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        } 
    }
         private void NapBangMonvaoCbMon()
    {
        try {
            String sSQL = "SELECT TenMonHoc FROM MonHoc";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
            cbMon.addItem("Chọn Môn:");
            while(rs.next())
            {
                cbMon.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        } 
    }
    private void NapDuLieuXetMonDangKyVaoTable()
    {
        try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "	SELECT IdDangKy as N'Mã Đăng Ký', TenMonHoc as N'Môn Học',TenThu as N'Thứ', Buoi as N'Buổi', TietBD as N'Tiết', TenPhong as N'Phòng', SiSo as N'Sỉ Số', HoTen as N'Giảng Viên', TenHocKi as N'Học Kì' " +
            "	FRom DangKy, PhongHoc,Thu,ThoiGianHoc,MonHoc,tblNguoiDung, HocKi" +
            "	where DangKy.IdGV=tblNguoiDung.IdNguoiDung " +
            "		  and DangKy.IdHocKi = HocKi.IdHocKi " +
            "		  and DangKy.IdMonHoc=MonHoc.IdMonHoc " +
            "		  and DangKy.IdThoiGian=ThoiGianHoc.IdThoiGian" +
            "		  and DangKy.IdPhong = PhongHoc.IdPhong" +
            "		  and DangKy.IdThu = Thu.IdThu and Status = 0";
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
            tblXetduyet.setModel(modelTable);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblXetduyet = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtMaDangKy = new javax.swing.JTextField();
        cbGiangVien = new javax.swing.JComboBox<>();
        cbPhong = new javax.swing.JComboBox<>();
        cbBuoi = new javax.swing.JComboBox<>();
        cbHocKi = new javax.swing.JComboBox<>();
        cbThu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnKichHoat = new javax.swing.JButton();
        txtDateOpen = new com.toedter.calendar.JDateChooser();
        txtDateClose = new com.toedter.calendar.JDateChooser();
        btnXoa = new javax.swing.JButton();
        cbMon = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtSiSo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1055, 578));
        setPreferredSize(new java.awt.Dimension(1055, 578));

        jPanel1.setBackground(new java.awt.Color(51, 0, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Xét Duyệt Mở Lớp");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 13))); // NOI18N

        tblXetduyet.setModel(new javax.swing.table.DefaultTableModel(
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
        tblXetduyet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblXetduyetMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblXetduyet);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form xét duyệt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 13))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel2.setText("Mã Đăng Ký");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel3.setText("Thứ");

        jLabel4.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel4.setText("Thời Gian Mở");

        jLabel5.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel5.setText("Giảng viên");

        jLabel6.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel6.setText("Buổi");

        jLabel7.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel7.setText("Thời Gian Đóng");

        jLabel8.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel8.setText("Phòng");

        jLabel9.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel9.setText("Học Kì");

        btnKichHoat.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        btnKichHoat.setText("Kích Hoạt");
        btnKichHoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichHoatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel10.setText("Môn");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel11.setText("Sỉ số");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSiSo)
                    .addComponent(txtMaDangKy)
                    .addComponent(cbThu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDateOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbGiangVien, 0, 216, Short.MAX_VALUE)
                                    .addComponent(cbBuoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(txtDateClose, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbPhong, 0, 132, Short.MAX_VALUE)
                            .addComponent(cbHocKi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnKichHoat)
                        .addGap(27, 27, 27)
                        .addComponent(btnXoa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPhong))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbThu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(txtDateOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(txtDateClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbMon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSiSo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnKichHoat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblXetduyetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblXetduyetMouseClicked
        // TODO add your handling code here:
        NapItemDuocchon();
    }//GEN-LAST:event_tblXetduyetMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (tblXetduyet.getSelectedRow() < 0) { 
            JOptionPane.showMessageDialog(this,"Phải chọn một dòng để sửa hoặc xóa!");
            return;
        }
        int row = tblXetduyet.getSelectedRow();
        int maDK = (int)tblXetduyet.getValueAt(row, 0);
        String SQL = "DELETE FROM DangKy WHERE IdDangKy ="+maDK;
        int i = db.ThemXoaSua(SQL);
        if(i > 0)
        {
            JOptionPane.showMessageDialog(this,"Xóa thành công!");
            NapDuLieuXetMonDangKyVaoTable();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Xóa thất bại!");
            NapDuLieuXetMonDangKyVaoTable();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnKichHoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichHoatActionPerformed
        // TODO add your handling code here:
        if (tblXetduyet.getSelectedRow() < 0) { 
            JOptionPane.showMessageDialog(this,"Phải chọn một dòng để sửa hoặc xóa!");
            return;
        }
        int row = tblXetduyet.getSelectedRow();
        int maDK = (int)tblXetduyet.getValueAt(row, 0);
       
        Date ns = txtDateOpen.getDate();
        String pattern = "yyyy-MM-dd"; //01/24/1980
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateopen = simpleDateFormat.format(ns);
        Date ns1 = txtDateClose.getDate();
        String pattern1 = "yyyy-MM-dd"; //01/24/1980
        SimpleDateFormat simpleDateForma1t = new SimpleDateFormat(pattern1);
        String dateclose = simpleDateFormat.format(ns1);
        String SQL = "UPDATE DangKy SET Status ='1',ThoiGianMo='"+dateopen+"', ThoiGianDong = '"+dateclose+"' WHERE IdDangKy = "+maDK;
        int i = db.ThemXoaSua(SQL);
        if(i > 0)
        {
            JOptionPane.showMessageDialog(this,"Mở lớp thành công");
            NapDuLieuXetMonDangKyVaoTable();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Mở lớp thất bại!");
            NapDuLieuXetMonDangKyVaoTable();
        }
    }//GEN-LAST:event_btnKichHoatActionPerformed
    private void NapItemDuocchon()
    {
        if (tblXetduyet.getSelectedRow() < 0) {
            return;
        }
        int row = tblXetduyet.getSelectedRow();
        txtMaDangKy.setText(tblXetduyet.getValueAt(row, 0).toString());
        for(int i=0;i<cbMon.getItemCount();i++)
            if(cbMon.getItemAt(i).equals((String)tblXetduyet.getValueAt(row, 1)))
                cbMon.setSelectedIndex(i);
        for(int i=0;i<cbThu.getItemCount();i++)
            if(cbThu.getItemAt(i).equals((String)tblXetduyet.getValueAt(row, 2)))
                cbThu.setSelectedIndex(i);
        for(int i=0;i<cbBuoi.getItemCount();i++)
            if(cbBuoi.getItemAt(i).equals((String)tblXetduyet.getValueAt(row, 3)+ " | "+(String)tblXetduyet.getValueAt(row, 4)))
                cbBuoi.setSelectedIndex(i);
        for(int i=0;i<cbPhong.getItemCount();i++)
            if(cbPhong.getItemAt(i).equals((String)tblXetduyet.getValueAt(row, 5)))
                cbPhong.setSelectedIndex(i);
        txtSiSo.setText(tblXetduyet.getValueAt(row, 6).toString());
        for(int i=0;i<cbGiangVien.getItemCount();i++)
            if(cbGiangVien.getItemAt(i).equals((String)tblXetduyet.getValueAt(row, 7)))
                cbGiangVien.setSelectedIndex(i);
        for(int i=0;i<cbHocKi.getItemCount();i++)
            if(cbHocKi.getItemAt(i).equals((String)tblXetduyet.getValueAt(row, 8)))
                cbHocKi.setSelectedIndex(i);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKichHoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbBuoi;
    private javax.swing.JComboBox<String> cbGiangVien;
    private javax.swing.JComboBox<String> cbHocKi;
    private javax.swing.JComboBox<String> cbMon;
    private javax.swing.JComboBox<String> cbPhong;
    private javax.swing.JComboBox<String> cbThu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblXetduyet;
    private com.toedter.calendar.JDateChooser txtDateClose;
    private com.toedter.calendar.JDateChooser txtDateOpen;
    private javax.swing.JTextField txtMaDangKy;
    private javax.swing.JTextField txtSiSo;
    // End of variables declaration//GEN-END:variables
}
