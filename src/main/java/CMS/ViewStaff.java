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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ViewStaff extends javax.swing.JFrame {

    /**
     * Creates new form ViewStaff
     */
    public ViewStaff() {
        initComponents();
        addRow();
    }
    
    public class Address {
        String contry;
        String city;
        int postal;
        
        public Address(String contry, String city, int postal) {
            this.contry = contry;
            this.city = city;
            this.postal = postal;
        }
    }
    
    public class Staff {
        int id;
        String firstName, lastName;
        String ctzn;
        String gender;
        String dob;
        Address address;
        String email;
        String phone;
        String des;
        String pass;
        
        public Staff(int id, String firstName, String lastName, String ctzn, String gender, String dob, Address address, String email, String phone, String des, String pass) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.ctzn = ctzn;
            this.gender = gender;
            this.dob = dob;
            this.address = address;
            this.email = email;
            this.phone = phone;
            this.des = des;
            this.pass = pass;
        }
    }
    
    public void clearFields() {
        jTextFieldID.setText("");
        jTextFieldLastName.setText("");
        jTextFieldFirstName.setText("");
        buttonGroup1.clearSelection();
        jTextFieldCtzn.setText("");
        jTextFieldContry.setText("");
        jTextFieldCity.setText("");
        jTextFieldPostal.setText("");
        jTextFieldEmail.setText("");
        jTextFieldPhone.setText("");
        jComboBoxDesignation.setSelectedIndex(0);
        date_chooser.setCalendar(null);
    }
        
    private void addRow() {
        DefaultTableModel model = (DefaultTableModel) this.jTableEmpList.getModel();
        ArrayList<Staff> sList = getViewStaff();
        Object rowData[] = new Object[13];
        for(int i=0; i<sList.size(); i++) {
            rowData[0] = sList.get(i).id;
            rowData[1] = sList.get(i).firstName;
            rowData[2] = sList.get(i).lastName;
            rowData[3] = sList.get(i).ctzn;
            rowData[4] = sList.get(i).gender;
            rowData[5] = sList.get(i).dob;
            rowData[6] = sList.get(i).address.contry;
            rowData[7] = sList.get(i).address.city;
            rowData[8] = sList.get(i).address.postal;
            rowData[9] = sList.get(i).email;
            rowData[10] = sList.get(i).phone;
            rowData[11] = sList.get(i).des;
            rowData[12] = sList.get(i).pass;
            model.addRow(rowData);
        }
    }
        
        
        /*
        TOOOOOOO DOOOOOOOOOO
        
        private void addRow() {
            DefaultTableModel table = (DefaultTableModel) this.jTableEmpList.getModel();
            ArrayList<Staff> staffList = ViewStaff();
        }*/
        
    public ArrayList<Staff> getViewStaff(){
        Staff staff;
        String staffLine;
        StringTokenizer st;
        ArrayList<Staff> sList = new ArrayList<>();
        File regFile = new File("reg.txt");
        if(regFile.exists()) {
            FileReader reader = null;
            try {
                reader = new FileReader(regFile);
                BufferedReader br = new BufferedReader(reader);
                try {
                    while((staffLine = br.readLine())!=null){
                        st = new StringTokenizer(staffLine, ",");
                        staff = new Staff(Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), new Address(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken())), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                        sList.add(staff);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ViewStaff.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ViewStaff.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(ViewStaff.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return sList;
        }
        else {
            
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmpList = new javax.swing.JTable();
        jTextFieldPhone = new javax.swing.JTextField();
        jTextFieldCtzn = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxDesignation = new javax.swing.JComboBox<>();
        date_chooser = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldLastName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldContry = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldCity = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPostal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jRadioButtonOther = new javax.swing.JRadioButton();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButtonDeleteUser = new javax.swing.JButton();
        jTextFieldPassword = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButtonClear1 = new javax.swing.JButton();
        jButtonUpdateUser = new javax.swing.JButton();
        jTextFieldID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabelTitle1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setForeground(new java.awt.Color(164, 208, 247));

        jTableEmpList.setBackground(new java.awt.Color(204, 255, 255));
        jTableEmpList.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jTableEmpList.setForeground(new java.awt.Color(0, 0, 153));
        jTableEmpList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Citizinship", "Gender", "DOB", "Contry", "City", "Postal", "Email", "Phone", "Designation", "Password"
            }
        ));
        jTableEmpList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmpList);

        jTextFieldPhone.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldPhone.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldPhone.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhoneActionPerformed(evt);
            }
        });

        jTextFieldCtzn.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldCtzn.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldCtzn.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldCtzn.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldCtzn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCtznActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(54, 84, 196));
        jLabel7.setText("Citizenship No.");

        jComboBoxDesignation.setBackground(new java.awt.Color(0, 51, 153));
        jComboBoxDesignation.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jComboBoxDesignation.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxDesignation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Managerial Staff", "Delivery Staff" }));
        jComboBoxDesignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDesignationActionPerformed(evt);
            }
        });

        date_chooser.setBackground(new java.awt.Color(255, 255, 255));
        date_chooser.setForeground(new java.awt.Color(0, 51, 153));
        date_chooser.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(54, 84, 196));
        jLabel9.setText("Date of Birth");

        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("First Name");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(54, 84, 196));
        jLabel2.setText("Name");

        jLabel10.setForeground(new java.awt.Color(0, 51, 204));
        jLabel10.setText("Last Name");

        jTextFieldLastName.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldLastName.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldLastName.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldLastName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastNameActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("Contry");

        jTextFieldContry.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldContry.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldContry.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldContry.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldContry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContryActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(0, 51, 204));
        jLabel12.setText("City");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(54, 84, 196));
        jLabel3.setText("Address");

        jLabel13.setForeground(new java.awt.Color(0, 51, 204));
        jLabel13.setText("Postal Code");

        jTextFieldCity.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldCity.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldCity.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldCity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCityActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(0, 51, 204));
        jLabel14.setText("Phone");

        jTextFieldPostal.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldPostal.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldPostal.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldPostal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPostalActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(0, 51, 204));
        jLabel15.setText("Email");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(54, 84, 196));
        jLabel5.setText("Gender");

        buttonGroup1.add(jRadioButtonMale);
        jRadioButtonMale.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jRadioButtonMale.setForeground(new java.awt.Color(102, 102, 255));
        jRadioButtonMale.setText("Male");

        buttonGroup1.add(jRadioButtonFemale);
        jRadioButtonFemale.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jRadioButtonFemale.setForeground(new java.awt.Color(102, 102, 255));
        jRadioButtonFemale.setText("Female");

        buttonGroup1.add(jRadioButtonOther);
        jRadioButtonOther.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jRadioButtonOther.setForeground(new java.awt.Color(102, 102, 255));
        jRadioButtonOther.setText("Other");

        jTextFieldFirstName.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldFirstName.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldFirstName.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldFirstName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFirstNameActionPerformed(evt);
            }
        });

        jTextFieldEmail.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldEmail.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(54, 84, 196));
        jLabel6.setText("Contact");

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(54, 84, 196));
        jLabel16.setText("Designation");

        jButtonDeleteUser.setBackground(new java.awt.Color(255, 0, 51));
        jButtonDeleteUser.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDeleteUser.setText("Delete User");
        jButtonDeleteUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteUserMouseClicked(evt);
            }
        });
        jButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUserActionPerformed(evt);
            }
        });

        jTextFieldPassword.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldPassword.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldPassword.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPasswordActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(0, 51, 204));
        jLabel17.setText("Password");

        jButtonClear1.setBackground(new java.awt.Color(0, 255, 255));
        jButtonClear1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonClear1.setForeground(new java.awt.Color(102, 102, 0));
        jButtonClear1.setText("Clear Fields");
        jButtonClear1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonClear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClear1MouseClicked(evt);
            }
        });
        jButtonClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClear1ActionPerformed(evt);
            }
        });

        jButtonUpdateUser.setBackground(new java.awt.Color(0, 51, 204));
        jButtonUpdateUser.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonUpdateUser.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdateUser.setText("Update User");
        jButtonUpdateUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonUpdateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUpdateUserMouseClicked(evt);
            }
        });
        jButtonUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateUserActionPerformed(evt);
            }
        });

        jTextFieldID.setEditable(false);
        jTextFieldID.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldID.setFont(new java.awt.Font("Poppins", 2, 12)); // NOI18N
        jTextFieldID.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldID.setBorder(null);
        jTextFieldID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(54, 84, 196));
        jLabel8.setText("User ID");

        jLabelTitle1.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabelTitle1.setForeground(new java.awt.Color(0, 0, 255));
        jLabelTitle1.setText("Update Staff");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(428, 428, 428)
                                        .addComponent(jLabel8)
                                        .addGap(5, 5, 5)
                                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jTextFieldCtzn, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRadioButtonMale)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonFemale)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonOther))
                                    .addComponent(jLabel16)
                                    .addComponent(jComboBoxDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addGap(0, 185, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldContry, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jTextFieldPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabelTitle1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonMale, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonOther, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCtzn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldContry)
                    .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
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

    private void jTableEmpListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpListMouseClicked
        // TODO add your handling code here:
        RegisterStaff reg = new RegisterStaff();
        reg.clearFields();
        DefaultTableModel tabModel = (DefaultTableModel) this.jTableEmpList.getModel();
        String id = tabModel.getValueAt(jTableEmpList.getSelectedRow(),0).toString();
        String firstName = tabModel.getValueAt(jTableEmpList.getSelectedRow(),1).toString();
        String lastName = tabModel.getValueAt(jTableEmpList.getSelectedRow(),2).toString();
        String ctzn = tabModel.getValueAt(jTableEmpList.getSelectedRow(),3).toString();
        String gender = tabModel.getValueAt(jTableEmpList.getSelectedRow(),4).toString();
        //for Date Chooser
        try {
            int row = jTableEmpList.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tabModel.getValueAt(row,5));
            date_chooser.setDate(date);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Date Format Found!");
        }
        String contry = tabModel.getValueAt(jTableEmpList.getSelectedRow(),6).toString();
        String city = tabModel.getValueAt(jTableEmpList.getSelectedRow(),7).toString();
        String postal = tabModel.getValueAt(jTableEmpList.getSelectedRow(),8).toString();
        String email = tabModel.getValueAt(jTableEmpList.getSelectedRow(),9).toString();
        String phone = tabModel.getValueAt(jTableEmpList.getSelectedRow(),10).toString();
        String des = tabModel.getValueAt(jTableEmpList.getSelectedRow(),11).toString();
        String pass = tabModel.getValueAt(jTableEmpList.getSelectedRow(),12).toString();
        this.jTextFieldID.setText(id);
        this.jTextFieldFirstName.setText(firstName);
        this.jTextFieldLastName.setText(lastName);
        this.jTextFieldCtzn.setText(ctzn);
        switch(gender) {
            case "Male" -> {
                jRadioButtonMale.setSelected(true); jRadioButtonFemale.setSelected(false); jRadioButtonOther.setSelected(false);
            }
            case "Female" -> {
                jRadioButtonFemale.setSelected(true); jRadioButtonMale.setSelected(false); jRadioButtonOther.setSelected(false);
            }
            case "Other" -> {
                jRadioButtonOther.setSelected(true); jRadioButtonMale.setSelected(false); jRadioButtonFemale.setSelected(false);
            }
        }
        switch(des) {
            case "Managerial Staff" -> jComboBoxDesignation.setSelectedIndex(0);
            case "Delivery Staff" -> jComboBoxDesignation.setSelectedIndex(1);
        }
        this.jTextFieldContry.setText(contry);
        this.jTextFieldCity.setText(city);
        this.jTextFieldPostal.setText(postal);
        this.jTextFieldEmail.setText(email);
        this.jTextFieldPhone.setText(phone);
        this.jTextFieldLastName.setText(lastName);
        this.jTextFieldPassword.setText(pass);  
    }//GEN-LAST:event_jTableEmpListMouseClicked

    private void jTextFieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhoneActionPerformed

    private void jTextFieldCtznActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCtznActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCtznActionPerformed

    private void jComboBoxDesignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDesignationActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxDesignationActionPerformed

    private void jTextFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLastNameActionPerformed

    private void jTextFieldContryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContryActionPerformed

    private void jTextFieldCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCityActionPerformed

    private void jTextFieldPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPostalActionPerformed

    private void jTextFieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFirstNameActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jButtonDeleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteUserMouseClicked

    private void jButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUserActionPerformed
        try {
            // TODO add your handling code here:
            FileReader fr;
            StringTokenizer st;
            String s;
            File regFile = new File("reg.txt");
            File tmpFile = new File("tmp.txt");
            fr = new FileReader(regFile);
            FileWriter fw = new FileWriter(tmpFile);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            while ((s=br.readLine())!=null) {
                st = new StringTokenizer(s, ",");
                if(st.nextToken().equals(jTextFieldID.getText())) {
                    continue;
                }
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
            regFile.delete();
            JOptionPane.showMessageDialog(this, "User Deleted Successfully!");
            tmpFile.renameTo(regFile);
            
        } catch (IOException ex) {
            Logger.getLogger(ViewStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonDeleteUserActionPerformed

    private void jTextFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPasswordActionPerformed

    private void jButtonClear1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClear1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClear1MouseClicked

    private void jButtonClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClear1ActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_jButtonClear1ActionPerformed

    private void jButtonUpdateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpdateUserMouseClicked

    private void jButtonUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateUserActionPerformed
        FileReader fr = null;
        StringTokenizer st;
        String s;
        try {
            // TODO add your handling code here:
            File regFile = new File("reg.txt");
            File tmpFile = new File("tmp.txt");
            fr = new FileReader(regFile);
            FileWriter fw = new FileWriter(tmpFile);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            while ((s=br.readLine())!=null) {
                st = new StringTokenizer(s, ",");
                String id = this.jTextFieldID.getText();
                String firstName = this.jTextFieldFirstName.getText();
                String lastName = this.jTextFieldLastName.getText();
                String ctzn = this.jTextFieldCtzn.getText();
                String password = this.jTextFieldPassword.getText();
                SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                String dob = date.format(date_chooser.getDate());
                String gender = null;
                if (jRadioButtonMale.isSelected()==true) {
                    gender = "Male";
                }
                if (jRadioButtonFemale.isSelected()==true) {
                    gender = "Female";
                }
                if (jRadioButtonOther.isSelected()==true) {
                    gender = "Other";
                }
                String contry = this.jTextFieldContry.getText();
                String city = this.jTextFieldCity.getText();
                String postal = this.jTextFieldPostal.getText();
                String email = this.jTextFieldEmail.getText();
                String phone = this.jTextFieldPhone.getText();
                String designation = (String)this.jComboBoxDesignation.getSelectedItem();
                if(st.nextToken().equals(jTextFieldID.getText())) {
                    bw.write(id+","+firstName + "," + lastName + "," + ctzn + "," + gender + "," + dob + "," + contry + "," + city + "," + postal + "," + email + "," + phone + "," + designation +"," + password);
                    //bw.write(jTextFieldID.getText()+","+jTextFieldFirstName.getText()+","+jTextFieldLastName.getText()+","+jTextFieldCtzn.getText()+","++ "," + dob + "," + contry + "," + city + "," + postal + "," + email + "," + phone + "," + designation +"," + password);
                    bw.newLine();
                    continue;
                }
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
            regFile.delete();
            tmpFile.renameTo(regFile);
            JOptionPane.showMessageDialog(this, "User Information Updated Successfully!");
            clearFields();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewStaff.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ViewStaff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButtonUpdateUserActionPerformed

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

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
            java.util.logging.Logger.getLogger(ViewStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser date_chooser;
    private javax.swing.JButton jButtonClear1;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonUpdateUser;
    private javax.swing.JComboBox<String> jComboBoxDesignation;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JRadioButton jRadioButtonOther;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmpList;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldContry;
    private javax.swing.JTextField jTextFieldCtzn;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldPostal;
    // End of variables declaration//GEN-END:variables
}
