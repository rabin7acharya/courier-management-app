/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class ManageOrder extends javax.swing.JFrame {

    public ManageOrder() {
        initComponents();
        addRow();
    }
    
    class Order {
        int orID;
        String packType;
        String itemName;
        String fromName;
        String fromAddress;
        String fromPhone;
        String toName;
        String toAddress;
        String toPhone;
        String orderDate;
        String weight;

        public Order(int orID, String packType, String itemName, String fromName, String fromAddress, String fromPhone, String toName, String toAddress, String toPhone, String orderDate, String weight) {
            this.orID = orID;
            this.packType = packType;
            this.itemName = itemName;
            this.fromName = fromName;
            this.fromAddress = fromAddress;
            this.fromPhone = fromPhone;
            this.toName = toName;
            this.toAddress = toAddress;
            this.toPhone = toPhone;
            this.orderDate = orderDate;
            this.weight = weight;
        }

             
    }
    
    private void addRow() {
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableOrderMngt.getModel();
        ArrayList<Order> orderList = OrderList();
        Object rowData[] = new Object[11];
        for (int i=0;i<orderList.size();i++) {
            //bw.write(i+","+packType+","+itemName+","+fromName+","+fromAddress+","+fromPhone+","+toName+","+toAddress+","+toPhone+","+orderDate+","+weight);          
            rowData[0] = orderList.get(i).orID;
            rowData[1] = orderList.get(i).packType;
            rowData[2] = orderList.get(i).itemName;
            rowData[3] = orderList.get(i).fromName;
            rowData[4] = orderList.get(i).fromAddress;
            rowData[5] = orderList.get(i).fromPhone;
            rowData[6] = orderList.get(i).toName;
            rowData[7] = orderList.get(i).toAddress;
            rowData[8] = orderList.get(i).toPhone;
            rowData[9] = orderList.get(i).orderDate;
            rowData[10] = orderList.get(i).weight;
            tableModel.addRow(rowData);
        }
    } 
            
        
    public ArrayList<Order> OrderList() {
        String fileLine;
        ArrayList<Order> oList = new ArrayList<>();
        File orderFile = new File("order.txt");
        if(orderFile.exists()) {
            try {
                FileReader fr = new FileReader(orderFile);
                BufferedReader br = new BufferedReader(fr);
                while ((fileLine=br.readLine())!=null) {
                    StringTokenizer st = new StringTokenizer(fileLine, ",");
                    Order order = new Order(Integer.parseInt(st.nextToken()),st.nextToken(),st.nextToken(),st.nextToken(), st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(), st.nextToken());
                    oList.add(order);  
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
            return oList;
        } else {
            return null;
        }

    }
    
    public void assignOrder() {
        FileReader fr = null;
        try{
            String s;
            StringTokenizer st;
            File ordFile = new File("order.txt");
            fr = new FileReader(ordFile);
            BufferedReader br = new BufferedReader(fr);
            if(ordFile.exists()) {
                while((s=br.readLine())!=null) {
                    st = new StringTokenizer(s,",");
                    String orID = st.nextToken();
                    String packType = st.nextToken();
                    String itemName = st.nextToken();
                    String fromName = st.nextToken();
                    String fromAddress = st.nextToken();
                    String fromPhone = st.nextToken();
                    String toName = st.nextToken();
                    String toAddress = st.nextToken();
                    String toPhone = st.nextToken();
                    String orderDate = st.nextToken();
                    String weight = st.nextToken();
                    
                    //1,Medicine,Medicine,Tej,Chitwan,989,Pradip,Pokhara,9876565,01-08-2021,5.5
                    
                    if(orID.equals(jTextFieldOrderID.getText())) {
                        String dStaffID = this.jTextFieldDelvStaffID.getText();
                        String status = "Pending";
                        File ordAssign = new File("orderAssign.txt");
                        
                        File regFile = new File("reg.txt");
                        br = new BufferedReader (new FileReader(regFile));
                        int flag = 0;
                        while((s=br.readLine())!=null) {
                            st = new StringTokenizer(s,",");
                            String i = st.nextToken();
                            String fName = st.nextToken();
                            String lName = st.nextToken();
                            String ctzn = st.nextToken();
                            String gender = st.nextToken();
                            String dob = st.nextToken();
                            String contry = st.nextToken();
                            String city = st.nextToken();
                            String postal = st.nextToken();
                            String email = st.nextToken();
                            String phone = st.nextToken();
                            String des = st.nextToken();
                            
                            if(i.equals(dStaffID)&&des.equals("Delivery Staff")) {
                                flag=1;
                                if(!ordAssign.exists()) {
                                    ordAssign.createNewFile();
                                    FileWriter fw = new FileWriter(ordAssign, true);
                                    BufferedWriter bw = new BufferedWriter(fw);
                                    bw.write(orID+","+dStaffID+","+packType+","+itemName+","+fromName+","+fromAddress+","+fromPhone+","+toName+","+toAddress+","+toPhone+","+orderDate+","+weight+","+status);
                                    bw.newLine();
                                    bw.flush();
                                    bw.close();
                                    JOptionPane.showMessageDialog(this, "Order Assigned Successfully!");
                                }
                                else {
                                    FileWriter fw = new FileWriter(ordAssign, true);
                                    BufferedWriter bw = new BufferedWriter(fw);
                                    bw.write(orID+","+dStaffID+","+packType+","+itemName+","+fromName+","+fromAddress+","+fromPhone+","+toName+","+toAddress+","+toPhone+","+orderDate+","+weight+","+status);
                                    bw.newLine();
                                    bw.flush();
                                    bw.close();
                                    JOptionPane.showMessageDialog(this, "Order Assigned Successfully!");
                                }
                            } 
                        }
                        if(flag==0) {
                                
                            JOptionPane.showMessageDialog(this, "Error!\nNo Delivery Staff Found of ID: "+dStaffID);
                                
                        }
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "File Not Found!");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        jScrollPane_manOrdTableSP = new javax.swing.JScrollPane();
        jTableOrderMngt = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDelvStaffID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOrderID = new javax.swing.JTextField();
        jTextFieldItemName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldFromAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldToAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonAssignOrder = new javax.swing.JButton();
        jButtonDeleteOrder = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(220, 220, 242));

        jLabelTitle1.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabelTitle1.setForeground(new java.awt.Color(0, 0, 255));
        jLabelTitle1.setText("Order Management");

        jTableOrderMngt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Pakage Type", "Item Name", "Sender Name", "Sender Address", "Sender Number", "Receiver Name", "Receiver Add", "Receiver Number", "Ordered Date", "Weight (Lbs)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrderMngt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrderMngtMouseClicked(evt);
            }
        });
        jScrollPane_manOrdTableSP.setViewportView(jTableOrderMngt);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Delivery Staff ID");

        jTextFieldDelvStaffID.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldDelvStaffID.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jTextFieldDelvStaffID.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldDelvStaffID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldDelvStaffID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDelvStaffIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDelvStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDelvStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Order Details");

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
                .addComponent(jTextFieldOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFromAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldToAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldToAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFromAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Assign Order");

        jButtonAssignOrder.setBackground(new java.awt.Color(0, 51, 204));
        jButtonAssignOrder.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonAssignOrder.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAssignOrder.setText("Assign Order");
        jButtonAssignOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAssignOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAssignOrderMouseClicked(evt);
            }
        });
        jButtonAssignOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssignOrderActionPerformed(evt);
            }
        });

        jButtonDeleteOrder.setBackground(new java.awt.Color(255, 0, 51));
        jButtonDeleteOrder.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonDeleteOrder.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDeleteOrder.setText("Delete Order");
        jButtonDeleteOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonDeleteOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteOrderMouseClicked(evt);
            }
        });
        jButtonDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteOrderActionPerformed(evt);
            }
        });

        jButtonClear.setBackground(new java.awt.Color(0, 255, 255));
        jButtonClear.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonClear.setForeground(new java.awt.Color(102, 102, 0));
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabelTitle1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonAssignOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane_manOrdTableSP, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane_manOrdTableSP, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAssignOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableOrderMngtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrderMngtMouseClicked
        DefaultTableModel tabModel = (DefaultTableModel) this.jTableOrderMngt.getModel();
        String orID = tabModel.getValueAt(jTableOrderMngt.getSelectedRow(),0).toString();
        String itemName = tabModel.getValueAt(jTableOrderMngt.getSelectedRow(),1).toString();
        String fromAddress = tabModel.getValueAt(jTableOrderMngt.getSelectedRow(),4).toString();
        String toAddress = tabModel.getValueAt(jTableOrderMngt.getSelectedRow(),5).toString();
        this.jTextFieldOrderID.setText(orID);
        this.jTextFieldItemName.setText(itemName);
        this.jTextFieldFromAddress.setText(fromAddress);
        this.jTextFieldToAddress.setText(toAddress);
    }//GEN-LAST:event_jTableOrderMngtMouseClicked

    private void jTextFieldOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOrderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOrderIDActionPerformed

    private void jTextFieldDelvStaffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDelvStaffIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDelvStaffIDActionPerformed

    private void jTextFieldItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldItemNameActionPerformed

    private void jTextFieldFromAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFromAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFromAddressActionPerformed

    private void jTextFieldToAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldToAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldToAddressActionPerformed

    private void jButtonAssignOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAssignOrderMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAssignOrderMouseClicked

    private void jButtonAssignOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignOrderActionPerformed
        assignOrder();
    }//GEN-LAST:event_jButtonAssignOrderActionPerformed

    private void jButtonDeleteOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteOrderMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteOrderMouseClicked

    private void jButtonDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteOrderActionPerformed
        try {
            FileReader fr;
            StringTokenizer st;
            String s;
            File ordFile = new File("order.txt");
            File tempFile = new File("tempOrder.txt");
            fr = new FileReader(ordFile);
            FileWriter fw = new FileWriter(tempFile);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            while((s=br.readLine())!=null) {
                st = new StringTokenizer(s, ",");
                String id = st.nextToken();
                if(id.equals(jTextFieldOrderID.getText())) {
                    continue;
                }
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
            JOptionPane.showMessageDialog(this, "Order ID: "+jTextFieldOrderID.getText()+" deleted Successfully!");
            ordFile.delete();
            tempFile.renameTo(ordFile);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDeleteOrderActionPerformed

    private void jButtonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClearMouseClicked

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAssignOrder;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDeleteOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane_manOrdTableSP;
    private javax.swing.JTable jTableOrderMngt;
    private javax.swing.JTextField jTextFieldDelvStaffID;
    private javax.swing.JTextField jTextFieldFromAddress;
    private javax.swing.JTextField jTextFieldItemName;
    private javax.swing.JTextField jTextFieldOrderID;
    private javax.swing.JTextField jTextFieldToAddress;
    // End of variables declaration//GEN-END:variables
}
