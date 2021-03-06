/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMS;

import static CMS.AddFeedback.jTextFieldDelvID;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Feedback extends javax.swing.JFrame {

    /**
     * Creates new form Feedback
     */
    public Feedback() {
        initComponents();
        addRow();
    }
    
    class manFeedback {
        String orID;
        String delvID;
        String itemName;
        String fromName;
        String fromAddress;
        String toName;
        String toAddress;
        String feedback;
        
        //1,2,Medicine,Medicine,Tej,Chitwan,989,Pradip,Pokhara,9876565,01-08-2021,5.5,Pending

        public manFeedback(String orID, String delvID, String itemName,String fromName, String fromAddress, String toName, String toAddress, String feedback) {
            this.orID = orID;
            this.delvID = delvID;
            this.itemName = itemName;
            this.fromName = fromName;
            this.fromAddress = fromAddress;
            this.toName = toName;
            this.toAddress = toAddress;
            this.feedback = feedback;
        }
    }
    
    public void addRow() {
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableFeedback.getModel();
        ArrayList<manFeedback> aoList = ReportList();
        Object rowData[] = new Object[8];
        for (int i=0;i<aoList.size();i++) {
            
            //2,2,Document,John,City1,CIty2,Delivered on time!
            rowData[0] = aoList.get(i).orID;
            rowData[1] = aoList.get(i).delvID;
            rowData[2] = aoList.get(i).itemName;
            rowData[3] = aoList.get(i).fromName;
            rowData[4] = aoList.get(i).fromAddress;
            rowData[5] = aoList.get(i).toName;
            rowData[6] = aoList.get(i).toAddress;
            rowData[7] = aoList.get(i).feedback;
            tableModel.addRow(rowData);
        }
    }

    public ArrayList<manFeedback> ReportList() {
        String fileLine;
        ArrayList<manFeedback> aoList = new ArrayList<>();
        File fedFile = new File("feedback.txt");
        if(fedFile.exists()) {
            try {
                FileReader fr = new FileReader(fedFile);
                BufferedReader br = new BufferedReader(fr);
                while ((fileLine=br.readLine())!=null) {
                    StringTokenizer st = new StringTokenizer(fileLine, ",");
                    manFeedback report = new manFeedback(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                    aoList.add(report);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);
            }
            return aoList;
        } else {
            return null;
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
        Feedback = new javax.swing.JLabel();
        jScrollPane_aoTable = new javax.swing.JScrollPane();
        jTableFeedback = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldFeedback = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldToName = new javax.swing.JTextField();
        jTextFieldOrderID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldItemName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDelvID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        Feedback.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        Feedback.setForeground(new java.awt.Color(0, 0, 255));
        Feedback.setText("FeedBack");

        jTableFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Delivery Staff ID", "Item", "Sender Name", "Sender Address", "Receiver Name", "Receiver Address", "FeedBack"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFeedbackMouseClicked(evt);
            }
        });
        jScrollPane_aoTable.setViewportView(jTableFeedback);
        if (jTableFeedback.getColumnModel().getColumnCount() > 0) {
            jTableFeedback.getColumnModel().getColumn(7).setMinWidth(350);
        }

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldFeedback)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Feedback Message");

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Sent By:");

        jTextFieldToName.setEditable(false);
        jTextFieldToName.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldToName.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldToName.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldToName.setBorder(null);
        jTextFieldToName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldToName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldToNameActionPerformed(evt);
            }
        });

        jTextFieldOrderID.setEditable(false);
        jTextFieldOrderID.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldOrderID.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldOrderID.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldOrderID.setBorder(null);
        jTextFieldOrderID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOrderIDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Order ID:");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Item Name:");

        jTextFieldItemName.setEditable(false);
        jTextFieldItemName.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldItemName.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldItemName.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldItemName.setBorder(null);
        jTextFieldItemName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldItemNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 204));
        jLabel9.setText("Delivery Staff ID:");

        jTextFieldDelvID.setEditable(false);
        jTextFieldDelvID.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldDelvID.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldDelvID.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldDelvID.setBorder(null);
        jTextFieldDelvID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldDelvID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDelvIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDelvID, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldToName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldToName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDelvID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Feedback Info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Feedback)
                        .addComponent(jScrollPane_aoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_aoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFeedbackMouseClicked
        DefaultTableModel tabModel = (DefaultTableModel) this.jTableFeedback.getModel();
        String toName = tabModel.getValueAt(jTableFeedback.getSelectedRow(),3).toString();
        String ordID = tabModel.getValueAt(jTableFeedback.getSelectedRow(),0).toString();
        String itemName = tabModel.getValueAt(jTableFeedback.getSelectedRow(),2).toString();
        String delvID = tabModel.getValueAt(jTableFeedback.getSelectedRow(),1).toString();
        String feedback = tabModel.getValueAt(jTableFeedback.getSelectedRow(),7).toString();

        this.jTextFieldOrderID.setText(ordID);
        this.jTextFieldDelvID.setText(delvID);
        this.jTextFieldItemName.setText(itemName);
        this.jTextFieldToName.setText(toName);
        this.jTextFieldFeedback.setText(feedback);
    }//GEN-LAST:event_jTableFeedbackMouseClicked

    private void jTextFieldToNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldToNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldToNameActionPerformed

    private void jTextFieldOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOrderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOrderIDActionPerformed

    private void jTextFieldItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldItemNameActionPerformed

    private void jTextFieldDelvIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDelvIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDelvIDActionPerformed

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
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Feedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Feedback;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane_aoTable;
    private javax.swing.JTable jTableFeedback;
    private javax.swing.JTextField jTextFieldDelvID;
    private javax.swing.JTextField jTextFieldFeedback;
    private javax.swing.JTextField jTextFieldItemName;
    private javax.swing.JTextField jTextFieldOrderID;
    private javax.swing.JTextField jTextFieldToName;
    // End of variables declaration//GEN-END:variables
}
