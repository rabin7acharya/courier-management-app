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
public class Report extends javax.swing.JFrame {

    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
        addRow();
    }
    
    class manReport {
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

        public manReport(String orID, String delvID, String itemName, String packType, String fromName, String fromAddress, String fromPhone, String toName, String toAddress, String toPhone, String orderDate, String weight, String status, String delvDate) {
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
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableReport.getModel();
        ArrayList<manReport> aoList = ReportList();
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

    public ArrayList<manReport> ReportList() {
        String fileLine;
        ArrayList<manReport> aoList = new ArrayList<>();
        File repFile = new File("report.txt");
        if(repFile.exists()) {
            try {
                FileReader fr = new FileReader(repFile);
                BufferedReader br = new BufferedReader(fr);
                while ((fileLine=br.readLine())!=null) {
                    StringTokenizer st = new StringTokenizer(fileLine, ",");
                    String id = st.nextToken();
                    String id1 = st.nextToken();
                    manReport report = new manReport(id,id1,st.nextToken(),st.nextToken(), st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                    aoList.add(report);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
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
        jTableReport = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOrderID = new javax.swing.JTextField();
        jTextFieldItemName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldOrderDate = new javax.swing.JTextField();
        jLabelOrderDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldWeight = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldFromName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldFromAddress = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldDelvID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextFieldToName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldToAddress = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabelTitle1.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabelTitle1.setForeground(new java.awt.Color(0, 0, 255));
        jLabelTitle1.setText("Report");

        jTableReport.setBackground(new java.awt.Color(204, 255, 255));
        jTableReport.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableReportMouseClicked(evt);
            }
        });
        jScrollPane_aoTable.setViewportView(jTableReport);

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

        jTextFieldOrderDate.setEditable(false);
        jTextFieldOrderDate.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldOrderDate.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldOrderDate.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldOrderDate.setBorder(null);
        jTextFieldOrderDate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldOrderDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOrderDateActionPerformed(evt);
            }
        });

        jLabelOrderDate.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabelOrderDate.setForeground(new java.awt.Color(0, 51, 204));
        jLabelOrderDate.setText("Ordered Date:");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Weight(Lbs):");

        jTextFieldWeight.setEditable(false);
        jTextFieldWeight.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldWeight.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldWeight.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldWeight.setBorder(null);
        jTextFieldWeight.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWeightActionPerformed(evt);
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
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabelOrderDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelOrderDate)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jTextFieldFromName.setEditable(false);
        jTextFieldFromName.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldFromName.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldFromName.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldFromName.setBorder(null);
        jTextFieldFromName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldFromName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFromNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 204));
        jLabel9.setText("Name:");

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 204));
        jLabel10.setText("Address:");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFromAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFromName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFromName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFromAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("Sender's Details");

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 204));
        jLabel12.setText("Receiver's Details");

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

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

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 204));
        jLabel13.setText("Staff ID:");

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 204));
        jLabel14.setText("Status:");

        jTextFieldStatus.setEditable(false);
        jTextFieldStatus.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldStatus.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldStatus.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldStatus.setBorder(null);
        jTextFieldStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldStatus))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDelvID, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDelvID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Order Details");

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

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

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 204));
        jLabel15.setText("Name:");

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 204));
        jLabel16.setText("Address:");

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldToAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldToName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldToName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldToAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 204));
        jLabel17.setText("Delivery Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane_aoTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelTitle1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(248, 248, 248)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_aoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReportMouseClicked
        DefaultTableModel tabModel = (DefaultTableModel) this.jTableReport.getModel();
        String ordId = tabModel.getValueAt(jTableReport.getSelectedRow(),0).toString();
        String delvID = tabModel.getValueAt(jTableReport.getSelectedRow(),1).toString();
        String itemName = tabModel.getValueAt(jTableReport.getSelectedRow(),3).toString();
        String fromName = tabModel.getValueAt(jTableReport.getSelectedRow(),4).toString();
        String fromAddress = tabModel.getValueAt(jTableReport.getSelectedRow(),5).toString();
        String toName = tabModel.getValueAt(jTableReport.getSelectedRow(),7).toString();
        String toAddress = tabModel.getValueAt(jTableReport.getSelectedRow(),8).toString();
        String status = tabModel.getValueAt(jTableReport.getSelectedRow(),12).toString();
        String ordDate = tabModel.getValueAt(jTableReport.getSelectedRow(),10).toString();
        String weight = tabModel.getValueAt(jTableReport.getSelectedRow(),11).toString();
        
        this.jTextFieldOrderID.setText(ordId);
        this.jTextFieldDelvID.setText(delvID);
        this.jTextFieldItemName.setText(itemName);
        this.jTextFieldFromName.setText(fromName);
        this.jTextFieldFromAddress.setText(fromAddress);
        this.jTextFieldToName.setText(toName);
        this.jTextFieldToAddress.setText(toAddress);
        this.jTextFieldStatus.setText(status);
        this.jTextFieldOrderDate.setText(ordDate);
        this.jTextFieldWeight.setText(weight);
        
    }//GEN-LAST:event_jTableReportMouseClicked

    private void jTextFieldOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOrderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOrderIDActionPerformed

    private void jTextFieldItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldItemNameActionPerformed

    private void jTextFieldOrderDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOrderDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOrderDateActionPerformed

    private void jTextFieldWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldWeightActionPerformed

    private void jTextFieldFromNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFromNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFromNameActionPerformed

    private void jTextFieldFromAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFromAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFromAddressActionPerformed

    private void jTextFieldDelvIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDelvIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDelvIDActionPerformed

    private void jTextFieldStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStatusActionPerformed

    private void jTextFieldToNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldToNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldToNameActionPerformed

    private void jTextFieldToAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldToAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldToAddressActionPerformed

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelOrderDate;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane_aoTable;
    private javax.swing.JTable jTableReport;
    private javax.swing.JTextField jTextFieldDelvID;
    private javax.swing.JTextField jTextFieldFromAddress;
    private javax.swing.JTextField jTextFieldFromName;
    private javax.swing.JTextField jTextFieldItemName;
    private javax.swing.JTextField jTextFieldOrderDate;
    private javax.swing.JTextField jTextFieldOrderID;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldToAddress;
    private javax.swing.JTextField jTextFieldToName;
    private javax.swing.JTextField jTextFieldWeight;
    // End of variables declaration//GEN-END:variables
}