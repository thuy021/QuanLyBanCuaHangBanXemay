/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Form;


/**
 *
 * @author phanb
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        
    	initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThongTin = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblTenCH = new javax.swing.JLabel();
        lblNhom = new javax.swing.JLabel();
        lbltv1 = new javax.swing.JLabel();
        lbltv2 = new javax.swing.JLabel();
        lbltv3 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlLoad = new javax.swing.JPanel();
        prbLoad = new javax.swing.JProgressBar();
        lblTai = new javax.swing.JLabel();
        lblTienDo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
      
        pnlThongTin.setBackground(new java.awt.Color(102, 255, 255));

        lblTitle.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitle.setText("PHẦM MỀM QUẢN LÝ BÁN XE MÁY");

        lblTenCH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTenCH.setText("CỬA HÀNG XE MÁY BTT");

        lblNhom.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblNhom.setText("Nhóm 06");

        lbltv1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbltv1.setText("Phan Xuân Bách");

        lbltv2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbltv2.setText("Nguyễn Đình Thông");

        lbltv3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbltv3.setText("Mai Thị Thanh Thúy");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_big/Logo.PNG"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("17039931");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("17042171");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("17044401");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Phiên bản 1.0");

        javax.swing.GroupLayout pnlThongTinLayout = new javax.swing.GroupLayout(pnlThongTin);
        pnlThongTin.setLayout(pnlThongTinLayout);
        pnlThongTinLayout.setHorizontalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblTitle))
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblTenCH))
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNhom)
                            .addGroup(pnlThongTinLayout.createSequentialGroup()
                                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltv2)
                                    .addComponent(lbltv1)
                                    .addComponent(lbltv3))
                                .addGap(31, 31, 31)
                                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(593, Short.MAX_VALUE))
        );
        pnlThongTinLayout.setVerticalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenCH)
                .addGap(18, 18, 18)
                .addComponent(lblNhom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltv1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltv2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltv3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(pnlThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 210));

        pnlLoad.setBackground(new java.awt.Color(102, 153, 255));
        pnlLoad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlLoad.add(prbLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 57, 530, 22));

        lblTai.setText("Đang tải...");
        pnlLoad.add(lblTai, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        lblTienDo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTienDo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlLoad.add(lblTienDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 136, -1));

        getContentPane().add(pnlLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 580, 90));

        setSize(new java.awt.Dimension(570, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNhom;
    private javax.swing.JLabel lblTai;
    private javax.swing.JLabel lblTenCH;
    public javax.swing.JLabel lblTienDo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lbltv1;
    private javax.swing.JLabel lbltv2;
    private javax.swing.JLabel lbltv3;
    private javax.swing.JPanel pnlLoad;
    private javax.swing.JPanel pnlThongTin;
    public javax.swing.JProgressBar prbLoad;
    // End of variables declaration//GEN-END:variables
}