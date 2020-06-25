/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

import DBConnect.Database;
import java.awt.event.KeyAdapter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tnam1
 */
public class frmQuanLyMonHoc extends javax.swing.JPanel {

    /**
     * Creates new form frmQuanLyMonHoc
     */
    Database db;
    public frmQuanLyMonHoc() {
        initComponents();
        db =new Database();
        NapDuLieuKhoaVaoCbKhoa();
        NapDuLieutblMonHocVaoTable();
        SetButtonDefault();
        SetCleanInput();
        SetEditInput();
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
        txtMa.setText("");
        txtMon.setText("");
        txtTien.setText("");
        txtTiet.setText("");
        txtTinChi.setText("");
        txtTim.setText("");
        cbKhoa.setSelectedIndex(0);
    }
    private  void SetEditInput()
    {
        txtMa.setEditable(false);
        txtMon.setEditable(false);
        txtTien.setEditable(false);
        txtTiet.setEditable(false);
        txtTinChi.setEditable(false);
    }
    private  void SetEditInputThucThi()
     {
        txtMa.setEditable(false);
        txtMon.setEditable(true);
        txtTien.setEditable(true);
        txtTiet.setEditable(true);
        txtTinChi.setEditable(true);
    }
    private void NapDuLieuKhoaVaoCbKhoa()
    {
         try {
            String sSQL = "SELECT TenKhoa FROM Khoa";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không thể truy cập CSDL");
                return;
            }
            cbKhoa.addItem("Chọn khoa:");
            while(rs.next())
            {
                cbKhoa.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Truy DBConect Thất bại");
        }
    }
     private void NapDuLieutblMonHocVaoTable()
    {
        try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "SELECT IdMonHoc as N'Mã Môn Học',TenMonHoc as N'Tên Môn Học',SoTinChi as N'Số Tín Chỉ',SoTiet as N'Số Tiết',SoTien as N'Tiền/Tín Chỉ',TenKhoa as N'Khoa' FROM MonHoc, Khoa WHERE MonHoc.IdKhoa=Khoa.IdKhoa";
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
            jTMonHoc.setModel(modelTable);
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Truy cập DBConnect Thất bại");
        }
    }
     private void NapItemDuocChon()
    { 
        if (jTMonHoc.getSelectedRow() < 0) {            
            return;
        }
        int row = jTMonHoc.getSelectedRow();
        txtMa.setText(jTMonHoc.getValueAt(row, 0).toString());
        txtMon.setText((String)jTMonHoc.getValueAt(row, 1));
        txtTinChi.setText(jTMonHoc.getValueAt(row, 2).toString());
        txtTiet.setText(jTMonHoc.getValueAt(row, 3).toString());
        txtTien.setText(jTMonHoc.getValueAt(row, 4).toString());
        for(int i=0;i<cbKhoa.getItemCount();i++)
            if(cbKhoa.getItemAt(i).equals((String)jTMonHoc.getValueAt(row, 5)))
                cbKhoa.setSelectedIndex(i);
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
        cbKhoa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtMon = new javax.swing.JTextField();
        txtTinChi = new javax.swing.JTextField();
        txtTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTiet = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMonHoc = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản Lý Môn Học");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(471, 471, 471)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập liệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel2.setText("Khoa");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel3.setText("Mã Môn Học");

        txtTinChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTinChiKeyTyped(evt);
            }
        });

        txtTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTienKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel4.setText("Tên Môn Học");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel5.setText("Số Tín Chỉ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel6.setText("Tiền/Tín Chỉ");

        txtTiet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTietKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel7.setText("Số Tiết");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(txtMa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTinChi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbKhoa, javax.swing.GroupLayout.Alignment.TRAILING, 0, 265, Short.MAX_VALUE)
                        .addComponent(txtTien, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(51, 0, 255))); // NOI18N

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

        btnXoa.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 0, 0));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
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

        btnReset.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 204, 204));
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
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jTMonHoc.setModel(new javax.swing.table.DefaultTableModel(
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
        jTMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMonHocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTMonHoc);

        btnTim.setForeground(new java.awt.Color(255, 51, 51));
        btnTim.setText("Tìm");
        btnTim.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel8.setText("Tên Môn Học");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(50, 50, 50)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        SetCleanInput();
        SetEditInputThucThi();
        SetButtonThem();
    }//GEN-LAST:event_btnThemActionPerformed

    private void jTMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMonHocMouseClicked
        // TODO add your handling code here:
        NapItemDuocChon();
        SetEditInputThucThi();
        SetButtonThucThiSuaXoa();
    }//GEN-LAST:event_jTMonHocMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        SetButtonDefault();
        SetCleanInput();
        SetEditInput();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String timkiem = txtTim.getText().toString();
        if(timkiem.equals(""))
        {
             JOptionPane.showMessageDialog(this,"Vùi lòng nhập thông tin môn học cần tìm");
               NapDuLieutblMonHocVaoTable();
                    SetEditInput();
                    SetCleanInput();
                    SetButtonDefault();
        }
        else
        {
            try {
            DefaultTableModel modelTable = new DefaultTableModel();
            String sSelect = "	SELECT IdMonHoc as N'Mã Môn',TenMonHoc as N'Tên Môn Học', SoTinChi as N'Số Tín Chỉ', SoTiet as N'Số Tiết', SoTien as N'Tiền/Tín Chỉ', TenKhoa FROM MonHoc, Khoa  WHERE MonHoc.IdKhoa=Khoa.IdKhoa and TenMonHoc like N'%"+timkiem+"%'";
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
                jTMonHoc.setModel(modelTable);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Không tìm thấy");
                NapDuLieutblMonHocVaoTable();
                SetButtonDefault();
                SetCleanInput();
                SetEditInput();
                txtTim.setText("");
            }
            } catch (SQLException ex) {
                //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,"Truy cập DBConnect Thất bại");
            }
        }
          
    }//GEN-LAST:event_btnTimActionPerformed

    private void txtTinChiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTinChiKeyTyped
        // TODO add your handling code here:
        txtTinChi.addKeyListener(new KeyAdapter() {});
        char char_input = evt.getKeyChar();
        if (((char_input < '0') || (char_input > '9')) && (char_input != '\b'))
        {
            JOptionPane.showMessageDialog(this, "Nhập Số !","Lỗi",JOptionPane.ERROR_MESSAGE);
            txtTinChi.setText("");
        }
    }//GEN-LAST:event_txtTinChiKeyTyped

    private void txtTienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKeyTyped
        // TODO add your handling code here:
         txtTien.addKeyListener(new KeyAdapter() {});
        char char_input = evt.getKeyChar();
        if (((char_input < '0') || (char_input > '9')) && (char_input != '\b'))
        {
            JOptionPane.showMessageDialog(this, "Nhập Số !","Lỗi",JOptionPane.ERROR_MESSAGE);
            txtTien.setText("");
        }
    }//GEN-LAST:event_txtTienKeyTyped

    private void txtTietKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTietKeyTyped
        // TODO add your handling code here:
        txtTiet.addKeyListener(new KeyAdapter() {});
        char char_input = evt.getKeyChar();
        if (((char_input < '0') || (char_input > '9')) && (char_input != '\b'))
        {
            JOptionPane.showMessageDialog(this, "Nhập Số !","Lỗi",JOptionPane.ERROR_MESSAGE);
            txtTiet.setText("");
        }
    }//GEN-LAST:event_txtTietKeyTyped

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String tenmon = txtMon.getText().toString();
        String tinchimon = txtTinChi.getText().toString();
        String tietmon = txtTiet.getText().toString();
        String tien =txtTien.getText().toString();
        if(tenmon.equals("") && tinchimon.equals("") && tietmon.equals("") && tien.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Vùi lòng nhập dữ liệu $_$");
        }
        else
        {
            int Tinchi = Integer.parseInt(tinchimon);
//            System.out.println(""+Tinchi);
            int Tiet  = Integer.parseInt(tietmon);
//            System.out.println(""+Tiet);
            float Tien = Float.parseFloat(tien);
//            System.out.println(""+Tien);
            int Check =0;
            int khoa=0;
            try {
                String sSQL = "SELECT IdKhoa FROM Khoa WHERE TenKhoa = N'"+cbKhoa.getSelectedItem().toString()+"'";
                ResultSet rs = db.TruyVan(sSQL);
                if(rs == null) 
                {
                    JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                    return;
                }
                 while(rs.next())
                {
                    khoa = rs.getInt(1);
                }

            } catch (SQLException ex) {
                //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
            }
            if(Tinchi <= Check && Tinchi > 5)
            {
                JOptionPane.showMessageDialog(this,"Tín chỉ không được  <=0 và > 5");
                txtTinChi.setText("");
            }
            else if(Tiet <= Check && Tiet > 50)
            {
                JOptionPane.showMessageDialog(this,"Tiết không được  <=0 và > 50");
                txtTiet.setText("");
            }
            else if(khoa == 0)
            {
                  JOptionPane.showMessageDialog(this,"Vùi lòng chọn khoa");
            }
            else if(Tien < 0)
            {
                JOptionPane.showMessageDialog(this,"Tiền không được  <0 ");
                txtTien.setText("");
            }
            else
            {
                String Sql = "INSERT INTO MonHoc(TenMonHoc,SoTinChi, SoTiet,SoTien,IdKhoa) VALUES(N'"+tenmon+"',"+Tinchi+" ,"+Tiet+","+Tien+","+khoa+")";
                int i = db.ThemXoaSua(Sql);
                 if(i > 0)
                    {
                        JOptionPane.showMessageDialog(this,"Thêm mới thành công");
                        NapDuLieutblMonHocVaoTable();
                        SetEditInput();
                        SetCleanInput();
                        SetButtonDefault();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Thêm mới thất bại");
                        NapDuLieutblMonHocVaoTable();
                        SetEditInput();
                        SetCleanInput();
                        SetButtonDefault();
                    }
            }
        }
       
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
         if (jTMonHoc.getSelectedRow() < 0) { 
            JOptionPane.showMessageDialog(this,"Phải chọn một dòng để sửa hoặc xóa!");
            return;
        }
        int row = jTMonHoc.getSelectedRow();
        int maMon = (int)jTMonHoc.getValueAt(row, 0);
        String tenmon = txtMon.getText().toString();
        int Tinchi = Integer.parseInt(txtTinChi.getText().toString());
        int Tiet  = Integer.parseInt(txtTiet.getText().toString());
        float Tien = Float.parseFloat(txtTien.getText().toString());
        int khoa=0;
        try {
            String sSQL = "SELECT IdKhoa FROM Khoa WHERE TenKhoa = N'"+cbKhoa.getSelectedItem().toString()+"'";
            ResultSet rs = db.TruyVan(sSQL);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
             while(rs.next())
            {
                khoa = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Lỗi truy vấn");
        }
        if(Tinchi < 0 && Tinchi > 5)
        {
            JOptionPane.showMessageDialog(this,"Tín chỉ không được  <0 và > 5");
            txtTinChi.setText("");
        }
        else if(Tiet < 0 && Tiet > 50)
        {
            JOptionPane.showMessageDialog(this,"Tiết không được  <0 và > 50");
            txtTiet.setText("");
        }
        else if(khoa == 0)
        {
              JOptionPane.showMessageDialog(this,"Vùi lòng chọn khoa");
        }
        else if(Tien < 0)
        {
            JOptionPane.showMessageDialog(this,"Tiền không được  <0 ");
            txtTien.setText("");
        }
        else if(tenmon.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập môn");
        }
        else
        {
            String Sql = "UPDATE MonHoc SET TenMonHoc = N'"+tenmon+"', SoTinChi='"+Tinchi+"', SoTien='"+Tien+"', SoTiet= '"+Tiet+"', IdKhoa='"+khoa+"' WHERE IdMonHoc = "+maMon+"";
            int i = db.ThemXoaSua(Sql);
             if(i > 0)
                {
                    JOptionPane.showMessageDialog(this,"Cập nhập thành công");
                    NapDuLieutblMonHocVaoTable();
                    SetEditInput();
                    SetCleanInput();
                    SetButtonDefault();
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Cập nhập thất bại");
                    NapDuLieutblMonHocVaoTable();
                    SetEditInput();
                    SetCleanInput();
                    SetButtonDefault();
                }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
         if (jTMonHoc.getSelectedRow() < 0) { 
            JOptionPane.showMessageDialog(this,"Phải chọn một dòng để  sửa hoặc xóa!");
            return;
        }
        String dem = "";
        int row = jTMonHoc.getSelectedRow();
        int maMon = (int)jTMonHoc.getValueAt(row, 0);
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn muốn xóa  này thật chứ!","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
          // Saving code here
            try {
            String checkXoa = "	SELECT COUNT(*) as N'Đếm' FROM MonHoc, DangKy where MonHoc.IdKhoa = DangKy.IdMonHoc and DangKy.Status in (1,2,3) and MonHoc.IdKhoa="+maMon+"";
            ResultSet rs = db.TruyVan(checkXoa);
            if(rs == null) 
            {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
                return;
            }
             while(rs.next())
            {
                dem = rs.getString(1);
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Không truy vấn được trong CSDL");
            }
            System.err.println(""+dem);
            if(!dem.equals("0"))
            {
                JOptionPane.showMessageDialog(this,"Không được phép XÓA");
                NapDuLieutblMonHocVaoTable();
                    SetEditInput();
                    SetCleanInput();
                    SetButtonDefault();
            }
            else
            {
//                JOptionPane.showMessageDialog(this," được phép XÓA");
                String Xoa = "DELETE FROM MonHoc WHERE IdMonHoc = "+maMon+"";
                int i = db.ThemXoaSua(Xoa);
                if(i > 0)
                {
                    JOptionPane.showMessageDialog(this,"Xóa thành công");
                    NapDuLieutblMonHocVaoTable();
                    SetEditInput();
                    SetCleanInput();
                    SetButtonDefault();
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Xóa thất bại");
                    NapDuLieutblMonHocVaoTable();
                    SetEditInput();
                    SetCleanInput();
                    SetButtonDefault();
                }
               
            }
        }
        else
        {
            NapDuLieutblMonHocVaoTable();
                    SetEditInput();
                    SetCleanInput();
                    SetButtonDefault();
        }
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMonHoc;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMon;
    private javax.swing.JTextField txtTien;
    private javax.swing.JTextField txtTiet;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTinChi;
    // End of variables declaration//GEN-END:variables
}
