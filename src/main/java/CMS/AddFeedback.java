/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMS;

import static CMS.ViewAssignedOrder.jTextFieldDelvID;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class AddFeedback extends javax.swing.JFrame {

    /**
     * Creates new form AddFeedback
     */
    public AddFeedback() {
        initComponents();
    }
    
    public AddFeedback(String delvID) {
        jTextFieldDelvID.setText(delvID);
    }
    
    public void clearFields() {
        jTextFieldOrderID.setText("");
        jTextFieldItemName.setText("");
        jTextFieldFromAddress.setText("");
        jTextFieldToAddress.setText("");
        jTextFieldFeedback.setText("");
        jTextFieldDelvID.setText("");
    }
    
    class Report {
        String orID;
        String delvID;
        String itemName;
        String packType;
        String fromName;
        String fromAddress;
        String fromPhone;
        String toName;
        String toAddress;
        String toPhone;
        String orderDate;
        String weight;
        String status;
        String delvDate;
        
        //1,2,Medicine,Medicine,Tej,Chitwan,989,Pradip,Pokhara,9876565,01-08-2021,5.5,Pending

        public Report(String orID, String delvID, String itemName, String packType, String fromName, String fromAddress, String fromPhone, String toName, String toAddress, String toPhone, String orderDate, String weight, String status, String delvDate) {
            this.orID = orID;
            this.delvID = delvID;
            this.itemName = itemName;
            this.packType = packType;
            this.fromName = fromName;
            this.fromAddress = fromAddress;
            this.fromPhone = fromPhone;
            this.toName = toName;
            this.toAddress = toAddress;
            this.toPhone = toPhone;
            this.orderDate = orderDate;
            this.weight = weight;
            this.status = status;
            this.delvDate = delvDate;
        }
    }
    
    public void addRow() {
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableFeedback.getModel();
        ArrayList<Report> aoList = ReportList();
        Object rowData[] = new Object[14];
        for (int i=0;i<aoList.size();i++) {
            //2,Other,Food,Kells,Ohio,677000,Justin,Texas,677999,18-08-2021,5.5
            //1,2,Medicine,Medicine,Tej,Chitwan,989,Pradip,Pokhara,9876565,01-08-2021,5.5,Pending
            
            rowData[0] = aoList.get(i).orID;
            rowData[1] = aoList.get(i).delvID;
            rowData[2] = aoList.get(i).itemName;
            rowData[3] = aoList.get(i).packType;
            rowData[4] = aoList.get(i).fromName;
            rowData[5] = aoList.get(i).fromAddress;
            rowData[6] = aoList.get(i).fromPhone;
            rowData[7] = aoList.get(i).toName;
            rowData[8] = aoList.get(i).toAddress;
            rowData[9] = aoList.get(i).toPhone;
            rowData[10] = aoList.get(i).orderDate;
            rowData[11] = aoList.get(i).weight;
            rowData[12] = aoList.get(i).status;
            rowData[13] = aoList.get(i).delvDate;
            tableModel.addRow(rowData);
        }
    }

    public ArrayList<Report> ReportList() {
        String fileLine;
        ArrayList<Report> aoList = new ArrayList<>();
        File repFile = new File("report.txt");
        if(repFile.exists()) {
            try {
                FileReader fr = new FileReader(repFile);
                BufferedReader br = new BufferedReader(fr);
                while ((fileLine=br.readLine())!=null) {
                    StringTokenizer st = new StringTokenizer(fileLine, ",");
                    String id = st.nextToken();
                    String id1 = st.nextToken();
                    String delvID = jTextFieldDelvID.getText();
                    if(id1.equals(delvID)) {
                        Report report = new Report(id,id1,st.nextToken(),st.nextToken(), st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                        aoList.add(report);
                    } 
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddFeedback.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddFeedback.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabelTitle1 = new javax.swing.JLabel();
        jScrollPane_aoTable = new javax.swing.JScrollPane();
        jTableFeedback = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOrderID = new javax.swing.JTextField();
        jTextFieldItemName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldFromAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldToAddress = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldFeedback = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonAddFeedBack = new javax.swing.JButton();
        jTextFieldDelvID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        jLabelTitle1.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabelTitle1.setForeground(new java.awt.Color(0, 0, 255));
        jLabelTitle1.setText("Add FeedBack");

        jTableFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Staff ID", "Package Type", "Item", "Sender Name", "Sender Address", "Sender Phone", "Receiver Name", "Receiver Address", "Receiver Phone", "Order Date", "Weight(Lbs)", "Status", "Delivery Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true, false, true
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

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Order ID:");

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

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Item Name:");

        jTextFieldFromAddress.setEditable(false);
        jTextFieldFromAddress.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldFromAddress.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldFromAddress.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldFromAddress.setBorder(null);
        jTextFieldFromAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldFromAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFromAddressActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Sender's Address:");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Receiver's Address:");

        jTextFieldToAddress.setEditable(false);
        jTextFieldToAddress.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldToAddress.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldToAddress.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldToAddress.setBorder(null);
        jTextFieldToAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldToAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldToAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFromAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldToAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldToAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFromAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jTextFieldFeedback.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Enter your text here");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Courier Details");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("FeedBack");

        jButtonAddFeedBack.setBackground(new java.awt.Color(0, 51, 204));
        jButtonAddFeedBack.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonAddFeedBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddFeedBack.setText("Add FeedBack");
        jButtonAddFeedBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAddFeedBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddFeedBackMouseClicked(evt);
            }
        });
        jButtonAddFeedBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFeedBackActionPerformed(evt);
            }
        });

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

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Delivery Staff ID:");

        jButtonClear.setBackground(new java.awt.Color(153, 255, 255));
        jButtonClear.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonClear.setForeground(new java.awt.Color(153, 0, 102));
        jButtonClear.setText("Clear Fields");
        jButtonClear.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClearMouseClicked(evt);
            }
        });
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDelvID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane_aoTable, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAddFeedBack, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDelvID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_aoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButtonAddFeedBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFeedbackMouseClicked
        DefaultTableModel tabModel = (DefaultTableModel) this.jTableFeedback.getModel();
        String Id = tabModel.getValueAt(jTableFeedback.getSelectedRow(),0).toString();
        //String delvID = tabModel.getValueAt(jTableFeedback.getSelectedRow(),1).toString();
        //String status = tabModel.getValueAt(jTableFeedback.getSelectedRow(),11).toString();
        String itemName = tabModel.getValueAt(jTableFeedback.getSelectedRow(),3).toString();
        String fromAddress = tabModel.getValueAt(jTableFeedback.getSelectedRow(),5).toString();
        String toAddress = tabModel.getValueAt(jTableFeedback.getSelectedRow(),8).toString();
        
        this.jTextFieldOrderID.setText(Id);
        //this.jTextFieldDelvID.setText(delvID);
        this.jTextFieldItemName.setText(itemName);
        this.jTextFieldFromAddress.setText(fromAddress);
        this.jTextFieldToAddress.setText(toAddress);
    }//GEN-LAST:event_jTableFeedbackMouseClicked

    private void jTextFieldOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOrderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOrderIDActionPerformed

    private void jTextFieldItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldItemNameActionPerformed

    private void jTextFieldFromAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFromAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFromAddressActionPerformed

    private void jTextFieldToAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldToAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldToAddressActionPerformed

    private void jButtonAddFeedBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddFeedBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddFeedBackMouseClicked

    private void jButtonAddFeedBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFeedBackActionPerformed
        // TODO add your handling code here:
        FileReader fr = null;
        try {
            String S;
            StringTokenizer st;
            File repFile = new File("report.txt");
            fr = new FileReader(repFile);
            BufferedReader br = new BufferedReader(fr);
            if(repFile.exists())
            {
                while((S=br.readLine())!=null)
                {
                    st = new StringTokenizer(S,",");
                    String orID = st.nextToken();
                    String dStaffID = st.nextToken();
                    String packType= st.nextToken();
                    String itemName = st.nextToken();
                    String fromName = st.nextToken();
                    String fromAddress = st.nextToken();
                    String fromPhone = st.nextToken();
                    String toName = st.nextToken();
                    String toAddress = st.nextToken();
                    
                    //bw.write(orID+","+dStaffID+","+packType+","+itemName+","+fromName+","+fromAddress+","+fromPhone+","+toName+","+toAddress+","+toPhone+","+orderDate+","+weight+","+status);

                    if (orID.equals(jTextFieldOrderID.getText()))
                    {
                        File fedFile = new File("feedback.txt");
                        if(!fedFile.exists())
                        {
                            fedFile.createNewFile();
                            FileWriter fw = new FileWriter(fedFile,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(orID+","+dStaffID+","+itemName+","+fromName+","+fromAddress+","+toName+","+toAddress+","+jTextFieldFeedback.getText());
                            bw.newLine();
                            bw.flush();
                            bw.close();
                            JOptionPane.showMessageDialog(this, "Feedback Added Successfully!");

                        }

                        else
                        {
                            FileWriter fw = new FileWriter(fedFile,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(orID+","+dStaffID+","+itemName+","+fromName+","+fromAddress+","+toName+","+toAddress+","+jTextFieldFeedback.getText());
                            bw.newLine();
                            bw.flush();
                            bw.close();
                            JOptionPane.showMessageDialog(this, "Feedback Added Successfully!");
                        }

                    }
                    clearFields();
                }

            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddFeedback.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddFeedback.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(AddFeedback.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonAddFeedBackActionPerformed

    private void jTextFieldDelvIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDelvIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDelvIDActionPerformed

    private void jButtonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClearMouseClicked

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        clearFields();

    }//GEN-LAST:event_jButtonClearActionPerformed

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
            java.util.logging.Logger.getLogger(AddFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFeedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddFeedBack;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane_aoTable;
    private javax.swing.JTable jTableFeedback;
    public static javax.swing.JTextField jTextFieldDelvID;
    private javax.swing.JTextField jTextFieldFeedback;
    private javax.swing.JTextField jTextFieldFromAddress;
    private javax.swing.JTextField jTextFieldItemName;
    private javax.swing.JTextField jTextFieldOrderID;
    private javax.swing.JTextField jTextFieldToAddress;
    // End of variables declaration//GEN-END:variables
}
