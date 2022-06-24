/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMS;

/**
 *
 * @author Lenovo
 */
public class ManagingStaff extends javax.swing.JFrame {

    /**
     * Creates new form ManagingStaff
     */
    
    
    public ManagingStaff() {
        initComponents();
    }
    
    public ManagingStaff(String i) {
        this.jTextFieldID.setText(i);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonRegEmp = new javax.swing.JButton();
        jButtonUpdateStaffs = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonAddOrder = new javax.swing.JButton();
        jButtonOrderMngt = new javax.swing.JButton();
        jButtonFeedBack = new javax.swing.JButton();
        jButtonTrackCourier = new javax.swing.JButton();
        jButtonReport = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelBackground1.setBackground(new java.awt.Color(204, 255, 255));
        jPanelBackground1.setForeground(new java.awt.Color(46, 51, 116));
        jPanelBackground1.setPreferredSize(new java.awt.Dimension(897, 483));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jButtonRegEmp.setBackground(new java.awt.Color(183, 241, 255));
        jButtonRegEmp.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jButtonRegEmp.setForeground(new java.awt.Color(43, 22, 130));
        jButtonRegEmp.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Pictures\\FIgma Designs\\add.png")); // NOI18N
        jButtonRegEmp.setText("Register Staff");
        jButtonRegEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegEmpActionPerformed(evt);
            }
        });

        jButtonUpdateStaffs.setBackground(new java.awt.Color(183, 241, 255));
        jButtonUpdateStaffs.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jButtonUpdateStaffs.setForeground(new java.awt.Color(43, 22, 130));
        jButtonUpdateStaffs.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Pictures\\FIgma Designs\\updateAccounts.png")); // NOI18N
        jButtonUpdateStaffs.setText("Update Staffs");
        jButtonUpdateStaffs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateStaffsActionPerformed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(153, 204, 255));
        jLabelTitle.setText("Managing Staff Menu");

        jTextFieldID.setEditable(false);
        jTextFieldID.setBackground(new java.awt.Color(0, 51, 102));
        jTextFieldID.setBorder(null);
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jButtonAddOrder.setBackground(new java.awt.Color(183, 241, 255));
        jButtonAddOrder.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jButtonAddOrder.setForeground(new java.awt.Color(43, 22, 130));
        jButtonAddOrder.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Pictures\\FIgma Designs\\addOrder.png")); // NOI18N
        jButtonAddOrder.setText("Add Order");
        jButtonAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOrderActionPerformed(evt);
            }
        });

        jButtonOrderMngt.setBackground(new java.awt.Color(183, 241, 255));
        jButtonOrderMngt.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jButtonOrderMngt.setForeground(new java.awt.Color(43, 22, 130));
        jButtonOrderMngt.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Pictures\\FIgma Designs\\editOrder.png")); // NOI18N
        jButtonOrderMngt.setText("Order Management");
        jButtonOrderMngt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderMngtActionPerformed(evt);
            }
        });

        jButtonFeedBack.setBackground(new java.awt.Color(183, 241, 255));
        jButtonFeedBack.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jButtonFeedBack.setForeground(new java.awt.Color(43, 22, 130));
        jButtonFeedBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Pictures\\FIgma Designs\\feedback.png")); // NOI18N
        jButtonFeedBack.setText("FeedBack");
        jButtonFeedBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFeedBackActionPerformed(evt);
            }
        });

        jButtonTrackCourier.setBackground(new java.awt.Color(183, 241, 255));
        jButtonTrackCourier.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jButtonTrackCourier.setForeground(new java.awt.Color(43, 22, 130));
        jButtonTrackCourier.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\Courier Managemnt System\\src\\main\\java\\CMS\\trackCourier.png")); // NOI18N
        jButtonTrackCourier.setText("Track Courier");
        jButtonTrackCourier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrackCourierActionPerformed(evt);
            }
        });

        jButtonReport.setBackground(new java.awt.Color(183, 241, 255));
        jButtonReport.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jButtonReport.setForeground(new java.awt.Color(43, 22, 130));
        jButtonReport.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Pictures\\FIgma Designs\\report.png")); // NOI18N
        jButtonReport.setText("Report Generation");
        jButtonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportActionPerformed(evt);
            }
        });

        jButtonBack.setBackground(new java.awt.Color(51, 204, 255));
        jButtonBack.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(0, 51, 102));
        jButtonBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Pictures\\FIgma Designs\\backBtn.png")); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonReport, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTitle)
                                .addGap(184, 184, 184))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonRegEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonOrderMngt, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonTrackCourier, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonUpdateStaffs, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonFeedBack, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jButtonBack))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegEmp)
                    .addComponent(jButtonUpdateStaffs, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFeedBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonOrderMngt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTrackCourier, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButtonReport, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanelBackground1Layout = new javax.swing.GroupLayout(jPanelBackground1);
        jPanelBackground1.setLayout(jPanelBackground1Layout);
        jPanelBackground1Layout.setHorizontalGroup(
            jPanelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackground1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelBackground1Layout.setVerticalGroup(
            jPanelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackground1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUpdateStaffsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateStaffsActionPerformed
        // TODO add your handling code here:
        ViewStaff staffList = new ViewStaff();
        staffList.setVisible(true);
    }//GEN-LAST:event_jButtonUpdateStaffsActionPerformed

    private void jButtonRegEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegEmpActionPerformed
        // TODO add your handling code here:
        RegisterStaff regStaff = new RegisterStaff();
        regStaff.setVisible(true);
    }//GEN-LAST:event_jButtonRegEmpActionPerformed

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jButtonAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOrderActionPerformed
        // TODO add your handling code here:
        AddOrder addOrder = new AddOrder();
        addOrder.setVisible(true);
        
    }//GEN-LAST:event_jButtonAddOrderActionPerformed

    private void jButtonOrderMngtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderMngtActionPerformed
        // TODO add your handling code here:
        ManageOrder manOrder = new ManageOrder();
        manOrder.setVisible(true);
    }//GEN-LAST:event_jButtonOrderMngtActionPerformed

    private void jButtonFeedBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFeedBackActionPerformed
        // TODO add your handling code here:
        Feedback feedback = new Feedback();
        feedback.setVisible(true);
    }//GEN-LAST:event_jButtonFeedBackActionPerformed

    private void jButtonTrackCourierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrackCourierActionPerformed
        // TODO add your handling code here:
        TrackCourier tc = new TrackCourier();
        tc.setVisible(true);
    }//GEN-LAST:event_jButtonTrackCourierActionPerformed

    private void jButtonReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportActionPerformed
        // TODO add your handling code here:
        Report report = new Report();
        report.setVisible(true);
    }//GEN-LAST:event_jButtonReportActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        LoginFrame login = new LoginFrame();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(ManagingStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagingStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagingStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagingStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagingStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddOrder;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonFeedBack;
    private javax.swing.JButton jButtonOrderMngt;
    private javax.swing.JButton jButtonRegEmp;
    private javax.swing.JButton jButtonReport;
    private javax.swing.JButton jButtonTrackCourier;
    private javax.swing.JButton jButtonUpdateStaffs;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBackground1;
    public static javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}
