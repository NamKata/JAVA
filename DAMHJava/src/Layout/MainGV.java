/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

/**
 *
 * @author Tnam1
 */
public class MainGV extends javax.swing.JFrame {

    /**
     * Creates new form MainGV
     */
    public MainGV() {
        initComponents();
        TrangChu frm= new TrangChu();
        jTContent.removeAll();
        jTContent.add("Trang Chủ", frm);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLTime = new javax.swing.JLabel();
        jTContent = new javax.swing.JTabbedPane();
        jPContainer = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMTaiKhoanGV = new javax.swing.JMenu();
        jMThongTinTK = new javax.swing.JMenuItem();
        jMDoiMatKhau = new javax.swing.JMenuItem();
        jMDangXuat = new javax.swing.JMenuItem();
        jMDangKyLichHoc = new javax.swing.JMenu();
        jMXemLichHoc = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Xin chào:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Giáo Viên");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ngày:");

        jLDate.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLDate.setForeground(new java.awt.Color(255, 255, 255));
        jLDate.setText("20/06/2020");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Giờ:");

        jLTime.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLTime.setForeground(new java.awt.Color(255, 255, 255));
        jLTime.setText("20:00 PM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLDate)
                .addGap(42, 42, 42)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLTime, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLDate)
                    .addComponent(jLabel5)
                    .addComponent(jLTime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTContent.setMinimumSize(new java.awt.Dimension(1055, 578));
        jTContent.setPreferredSize(new java.awt.Dimension(1055, 578));

        javax.swing.GroupLayout jPContainerLayout = new javax.swing.GroupLayout(jPContainer);
        jPContainer.setLayout(jPContainerLayout);
        jPContainerLayout.setHorizontalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1075, Short.MAX_VALUE)
        );
        jPContainerLayout.setVerticalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );

        jTContent.addTab("Giao diện", jPContainer);

        jMTaiKhoanGV.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tnam1\\OneDrive\\Desktop\\JAVA\\DAMHJava\\src\\Image\\GV\\icons8_user_account_32px_1.png")); // NOI18N
        jMTaiKhoanGV.setText("Tài Khoản");

        jMThongTinTK.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_MASK));
        jMThongTinTK.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tnam1\\OneDrive\\Desktop\\JAVA\\DAMHJava\\src\\Image\\GV\\icons8_settings_32px.png")); // NOI18N
        jMThongTinTK.setText("Thông Tin Cá Nhân");
        jMThongTinTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMThongTinTKActionPerformed(evt);
            }
        });
        jMTaiKhoanGV.add(jMThongTinTK);

        jMDoiMatKhau.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_MASK));
        jMDoiMatKhau.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tnam1\\OneDrive\\Desktop\\JAVA\\DAMHJava\\src\\Image\\GV\\icons8_edit_32px_2.png")); // NOI18N
        jMDoiMatKhau.setText("Đổi Mật Khẩu");
        jMDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMDoiMatKhauActionPerformed(evt);
            }
        });
        jMTaiKhoanGV.add(jMDoiMatKhau);

        jMDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.SHIFT_MASK));
        jMDangXuat.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tnam1\\OneDrive\\Desktop\\JAVA\\DAMHJava\\src\\Image\\GV\\icons8_shutdown_32px_2.png")); // NOI18N
        jMDangXuat.setText("Đăng Xuất");
        jMDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMDangXuatActionPerformed(evt);
            }
        });
        jMTaiKhoanGV.add(jMDangXuat);

        jMenuBar1.add(jMTaiKhoanGV);

        jMDangKyLichHoc.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tnam1\\OneDrive\\Desktop\\IconJava\\GV\\icons8_compose_32px.png")); // NOI18N
        jMDangKyLichHoc.setText("Đăng Ký Lịch Học");
        jMDangKyLichHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMDangKyLichHocMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMDangKyLichHoc);

        jMXemLichHoc.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tnam1\\OneDrive\\Desktop\\IconJava\\GV\\icons8_schedule_32px.png")); // NOI18N
        jMXemLichHoc.setText("Xem Lịch Dạy");
        jMXemLichHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMXemLichHocMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMXemLichHoc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jTContent, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMDangXuatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMDangXuatActionPerformed

    private void jMThongTinTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMThongTinTKActionPerformed
        // TODO add your handling code here:
        frmGVthongtincanhan frm = new frmGVthongtincanhan();
        jTContent.removeAll();
        jTContent.add("Thông tin cá nhân", frm);
    }//GEN-LAST:event_jMThongTinTKActionPerformed

    private void jMDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMDoiMatKhauActionPerformed
        // TODO add your handling code here:
        frmGVdoimatkhau frm = new frmGVdoimatkhau();
        jTContent.removeAll();
        jTContent.add("Thay đổi mật khẩu", frm);
    }//GEN-LAST:event_jMDoiMatKhauActionPerformed

    private void jMDangKyLichHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMDangKyLichHocMouseClicked
        // TODO add your handling code here:
         frmGVDangKyLop frm = new frmGVDangKyLop();
        jTContent.removeAll();
        jTContent.add("Đăng Ký Dạy", frm);
    }//GEN-LAST:event_jMDangKyLichHocMouseClicked

    private void jMXemLichHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMXemLichHocMouseClicked
        // TODO add your handling code here:
        frmGVLichDay frm = new frmGVLichDay();
        jTContent.removeAll();
        jTContent.add("Lịch dạy", frm);
    }//GEN-LAST:event_jMXemLichHocMouseClicked
    public void Doimatkhau()
    {
        frmGVdoimatkhau frm = new frmGVdoimatkhau();
        jTContent.removeAll();
        jTContent.add("Thay đổi mật khẩu", frm);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLDate;
    private javax.swing.JLabel jLTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMDangKyLichHoc;
    private javax.swing.JMenuItem jMDangXuat;
    private javax.swing.JMenuItem jMDoiMatKhau;
    private javax.swing.JMenu jMTaiKhoanGV;
    private javax.swing.JMenuItem jMThongTinTK;
    private javax.swing.JMenu jMXemLichHoc;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTContent;
    // End of variables declaration//GEN-END:variables
}
