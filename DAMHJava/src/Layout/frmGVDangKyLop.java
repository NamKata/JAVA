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
public class frmGVDangKyLop extends javax.swing.JPanel {

    /**
     * Creates new form frmQuanLyXetDuyetMoLop
     */
    Database db;
    public frmGVDangKyLop() {
        initComponents();
        db =new Database();
        NapDuLieuXetMonDangKyVaoTable();
        NapBangBuoivaoCbBuoi();
        NapBangHocKivaoCbHocKi();
        NapBangPhongvaoCbPhong();
        NapBangThuvaoCbThu();
        NapBangMonvaoCbMon();
        SetButtonDefault();SetInput();
    }
     private  void SetButtonDefault()
    {
        btnThem.setEnabled(true);
        btnReset.setEnabled(true);
        btnLuu.setEnabled(false);
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
    }
    private void SetButtonSuaXoa()
    {
        btnThem.setEnabled(false);
        btnReset.setEnabled(true);
        btnLuu.setEnabled(false);
        btnXoa.setEnabled(true);
        btnSua.setEnabled(true);
    }
    private void SetButtonThem()
    {
        btnThem.setEnabled(false);
        btnReset.setEnabled(true);
        btnLuu.setEnabled(true);
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
    }
    private void SetInput()
    {
        txtMaDangKy.setEditable(false);
        txtSiSo.setEditable(false);
        txtMaDangKy.setText("");
        txtSiSo.setText("");
    }
    private void SetThucThi()
    {
        txtMaDangKy.setEditable(false);
        txtSiSo.setEditable(true);
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
        cbPhong = new javax.swing.JComboBox<>();
        cbBuoi = new javax.swing.JComboBox<>();
        cbHocKi = new javax.swing.JComboBox<>();
        cbThu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbMon = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtSiSo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1055, 578));
        setPreferredSize(new java.awt.Dimension(1055, 578));

        jPanel1.setBackground(new java.awt.Color(51, 0, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG KÝ DẠY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập Liệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 13))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel2.setText("Mã Đăng Ký");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel3.setText("Thứ");

        jLabel6.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel6.setText("Buổi");

        jLabel8.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel8.setText("Phòng");

        jLabel9.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel9.setText("Học Kì");

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaDangKy)
                    .addComponent(cbThu, 0, 220, Short.MAX_VALUE)
                    .addComponent(cbHocKi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSiSo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbBuoi, 0, 216, Short.MAX_VALUE)
                    .addComponent(cbMon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbBuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaDangKy, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbThu, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(cbMon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSiSo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(cbPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbHocKi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 0, 255));
        btnThem.setText("Thêm");
        btnThem.setToolTipText("");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 153, 153));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 0, 0));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 204, 204));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addGap(62, 62, 62))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblXetduyetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblXetduyetMouseClicked
        // TODO add your handling code here:
        NapItemDuocchon();
        SetButtonSuaXoa();
        SetThucThi();
    }//GEN-LAST:event_tblXetduyetMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        SetThucThi();
        SetButtonThem();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        SetButtonDefault();
        SetInput();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String SiSo = txtSiSo.getText().toString();
        if( SiSo.equals("0") && cbBuoi.getSelectedIndex() == 0 && cbHocKi.getSelectedIndex() ==0 && cbMon.getSelectedIndex() == 0 && cbPhong.getSelectedIndex() == 0 && cbThu.getSelectedIndex() == 0)
        {
             JOptionPane.showMessageDialog(this,"Vui lòng chọn đủ thông tin");
        }
        else
        {
            int mon=0;
            try {
                String sSQL = "SELECT IdMonHoc FROM MonHoc WHERE TenMonHoc = N'"+cbMon.getSelectedItem().toString()+"'";
                ResultSet rs = db.TruyVan(sSQL);
                if(rs == null) 
                {
                    JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                    return;
                }
                 while(rs.next())
                {
                    mon = rs.getInt(1);
                }

            
            int thu = cbThu.getSelectedIndex();
            int buoi = cbThu.getSelectedIndex();
            int phong = cbThu.getSelectedIndex();
            int hocki = cbThu.getSelectedIndex();
            String ktra ="";
            String check = "SELECT Count(*) as N'Số Lượng' FROM DangKy WHERE IdMonHoc ='"+mon+"' and IdThu ='"+thu+"' and IdThoiGian = '"+buoi+"' and IdPhong ='"+phong+"' and IdHocKi ='"+hocki+"'";
            ResultSet rs1 = db.TruyVan(check);
                if(rs1 == null) 
                {
                    JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                    return;
                }
                 while(rs.next())
                {
                    ktra = rs1.getString(1);
                }
             if(!ktra.equals("0"))
             {
                 String add ="INSERT INTO DangKy(IdMonHoc,IdThu,IdThoiGian,IdHocKi,IdPhong,IdGV, Status,SiSo) VALUES("+mon+","+thu+","+buoi+","+hocki+","+phong+","+DangNhap.IdTk+",0,'"+SiSo+"')";
                 int i = db.ThemXoaSua(add);
                 if(i > 0)
                 {
                      JOptionPane.showMessageDialog(this,"Thêm Thành Công");
                      NapDuLieuXetMonDangKyVaoTable();
                      SetInput();
                      SetButtonDefault();
                 }
                 else
                 {
                      JOptionPane.showMessageDialog(this,"Thêm Thất Bại");
                      NapDuLieuXetMonDangKyVaoTable();
                      SetInput();
                      SetButtonDefault();
                 }
             }
             else
             {
                 JOptionPane.showMessageDialog(this,"Đã tồn tại");
             }
            } catch (SQLException ex) {
                //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
         if (tblXetduyet.getSelectedRow() < 0) {
            return;
        }
        int row = tblXetduyet.getSelectedRow();
        int maPhong = (int)tblXetduyet.getValueAt(row, 0);
        String SiSo = txtSiSo.getText().toString();
        if(SiSo.equals("0") && cbBuoi.getSelectedIndex() == 0 && cbHocKi.getSelectedIndex() ==0 && cbMon.getSelectedIndex() == 0 && cbPhong.getSelectedIndex() == 0 && cbThu.getSelectedIndex() == 0)
        {
             JOptionPane.showMessageDialog(this,"Vui lòng chọn đủ thông tin");
        }
        else
        {
            int mon=0;
            try {
                String sSQL = "SELECT IdMonHoc FROM MonHoc WHERE TenMonHoc =N'"+cbMon.getSelectedItem().toString()+"'";
                ResultSet rs = db.TruyVan(sSQL);
                if(rs == null) 
                {
                    JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                    return;
                }
                 while(rs.next())
                {
                    mon = rs.getInt(1);
                }

            
            int thu = cbThu.getSelectedIndex();
            int buoi = cbThu.getSelectedIndex();
            int phong = cbThu.getSelectedIndex();
            int hocki = cbThu.getSelectedIndex();
            String ktra ="";
            String check = "SELECT Count(*) as N'Số Lượng' FROM DangKy WHERE IdMonHoc ='"+mon+"' and IdThu ='"+thu+"' and IdThoiGian = '"+buoi+"' and IdPhong ='"+phong+"' and IdHocKi ='"+hocki+"'";
            ResultSet rs1 = db.TruyVan(check);
                if(rs1 == null) 
                {
                    JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                    return;
                }
                 while(rs.next())
                {
                    ktra = rs1.getString(1);
                }
             if(!ktra.equals("0"))
             {
                 String add ="UPDATE DangKy SET IdMonHoc = "+mon+",IdThu = "+thu+",IdThoiGian = "+buoi+",IdHocKi = "+hocki+",IdPhong = "+phong+",SiSo ="+SiSo+"  WHERE IdGV ="+DangNhap.IdTk+" and IdDangKy ="+maPhong+"";
                 int i = db.ThemXoaSua(add);
                 if(i > 0)
                 {
                      JOptionPane.showMessageDialog(this,"Sửa Thành Công");
                      NapDuLieuXetMonDangKyVaoTable();
                      SetInput();
                      SetButtonDefault();
                 }
                 else
                 {
                      JOptionPane.showMessageDialog(this,"Sửa Thất Bại");
                      NapDuLieuXetMonDangKyVaoTable();
                      SetInput();
                      SetButtonDefault();
                 }
             }
             else
             {
                 JOptionPane.showMessageDialog(this,"Đã tồn tại");
             }
            } catch (SQLException ex) {
                //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
         if (tblXetduyet.getSelectedRow() < 0) {
            return;
        }
        int row = tblXetduyet.getSelectedRow();
        int maPhong = (int)tblXetduyet.getValueAt(row, 0);
         String add ="DELETE FROM DangKy WHERE IdDangKy ="+maPhong+"";
                 int i = db.ThemXoaSua(add);
                 if(i > 0)
                 {
                      JOptionPane.showMessageDialog(this,"Xóa Thành Công");
                      NapDuLieuXetMonDangKyVaoTable();
                      SetInput();
                      SetButtonDefault();
                 }
                 else
                 {
                      JOptionPane.showMessageDialog(this,"Xóa Thất Bại");
                      NapDuLieuXetMonDangKyVaoTable();
                      SetInput();
                      SetButtonDefault();
                 }
    }//GEN-LAST:event_btnXoaActionPerformed
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
        for(int i=0;i<cbHocKi.getItemCount();i++)
            if(cbHocKi.getItemAt(i).equals((String)tblXetduyet.getValueAt(row, 8)))
                cbHocKi.setSelectedIndex(i);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbBuoi;
    private javax.swing.JComboBox<String> cbHocKi;
    private javax.swing.JComboBox<String> cbMon;
    private javax.swing.JComboBox<String> cbPhong;
    private javax.swing.JComboBox<String> cbThu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblXetduyet;
    private javax.swing.JTextField txtMaDangKy;
    private javax.swing.JTextField txtSiSo;
    // End of variables declaration//GEN-END:variables
}
