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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class MyProfile extends javax.swing.JFrame {

    /**
     * Creates new form MyProfile
     */
    public MyProfile() {
        initComponents();
    }
    
    public MyProfile(String id) {
        this.jTextID.setText(id);
    }
    
    public void clearFields() {
        jTextFieldFirstName.setText("");
        jTextFieldLastName.setText("");
        jTextFieldCtzn.setText("");
        jTextFieldPassword.setText("");
        jTextFieldContry.setText("");
        jTextFieldCity.setText("");
        jTextFieldPostal.setText("");
        jTextFieldEmail.setText("");
        jTextFieldPhone.setText("");
        
    }
    
    public void loadProfile() {
        try {
            BufferedReader br;
            String s;
            String uID = this.jTextID.getText();
            StringTokenizer st;
            File regFile = new File("reg.txt");
            br = new BufferedReader(new FileReader(regFile));
            if(regFile.exists()) {
                try {
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
                        String pass = st.nextToken();
                        if(i.equals(uID)) {
                            //this.jTextID.setText(id);
                            this.jTextFieldFirstName.setText(fName);
                            this.jTextFieldLastName.setText(lName);
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
                            /*switch(des) {
                                case "Managerial Staff" -> jComboBoxDesignation.setSelectedIndex(0);
                                case "Delivery Staff" -> jComboBoxDesignation.setSelectedIndex(1);
                            }*/
                            this.jTextFieldDes.setText(des);
                            this.jTextFieldContry.setText(contry);
                            this.jTextFieldCity.setText(city);
                            this.jTextFieldPostal.setText(postal);
                            this.jTextFieldEmail.setText(email);
                            this.jTextFieldPhone.setText(phone);
                            this.jTextFieldLastName.setText(lName);
                            this.jTextFieldPassword.setText(pass);
                            this.jTextFieldDob.setText(dob);
                            
                        }
                        /*else {
                            JOptionPane.showMessageDialog(this, "File Not Found!");
                        }*/
 
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(MyProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateProfile() {
        FileReader fr = null;
        StringTokenizer st;
        String s;
        try {
            File regFile = new File("reg.txt");
            File tmpFile = new File("temp.txt");
            fr = new FileReader(regFile);
            FileWriter fw = new FileWriter(tmpFile);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            while((s=br.readLine())!=null) {

                st = new StringTokenizer(s,",");
                String id = this.jTextID.getText();
                String firstName = this.jTextFieldFirstName.getText();
                String lastName = this.jTextFieldLastName.getText();
                String ctzn = this.jTextFieldCtzn.getText();
                String password = this.jTextFieldPassword.getText();
                String dob = this.jTextFieldDob.getText();
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
                String designation = this.jTextFieldDes.getText();//(String)this.jComboBoxDesignation.getSelectedItem();
                if(st.nextToken().equals(id)){
                    bw.write(id+","+firstName + "," + lastName + "," + ctzn + "," + gender + "," + dob + "," + contry + "," + city + "," + postal + "," + email + "," + phone + "," + designation +"," + password);
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
            JOptionPane.showMessageDialog(this, "Your Profile Updated Successfully!");
            
            
            

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
    }
    
    /*public void DisplayProfile() {
        BufferedReader br;
        String s;
        String uID = this.jTextFieldID.getText();
        StringTokenizer st;
        File regFile = new File("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\empMngt\\reg.txt");
        br = new BufferedReader(new FileReader(regFile));
        if(regFile.exists()) {
            while((s=br.readLine())!=null) {
                st = new StringTokenizer(s,",");
                String i = st.nextToken();
                String n = st.ne
            }
            
        }
    }*/

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
        jLabelTitle1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldLastName = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jRadioButtonOther = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldContry = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldPostal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldDes = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldCtzn = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldDob = new javax.swing.JTextField();
        jButtonUpdateProf = new javax.swing.JButton();
        jButtonClear2 = new javax.swing.JButton();
        jTextID = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldPassword = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(145, 224, 239));
        jPanel1.setForeground(new java.awt.Color(153, 255, 255));

        jLabelTitle1.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabelTitle1.setForeground(new java.awt.Color(0, 0, 255));
        jLabelTitle1.setText("User Profile");

        jLabel17.setForeground(new java.awt.Color(0, 51, 204));
        jLabel17.setText("Designation");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setForeground(new java.awt.Color(153, 255, 255));

        jTextFieldFirstName.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldFirstName.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldFirstName.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldFirstName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFirstNameActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("First Name");

        jTextFieldLastName.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldLastName.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldLastName.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldLastName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastNameActionPerformed(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(0, 51, 204));
        jLabel20.setText("Last Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(jTextFieldLastName))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setForeground(new java.awt.Color(153, 255, 255));

        buttonGroup1.add(jRadioButtonFemale);
        jRadioButtonFemale.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jRadioButtonFemale.setForeground(new java.awt.Color(102, 102, 255));
        jRadioButtonFemale.setText("Female");

        buttonGroup1.add(jRadioButtonMale);
        jRadioButtonMale.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jRadioButtonMale.setForeground(new java.awt.Color(102, 102, 255));
        jRadioButtonMale.setText("Male");

        buttonGroup1.add(jRadioButtonOther);
        jRadioButtonOther.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jRadioButtonOther.setForeground(new java.awt.Color(102, 102, 255));
        jRadioButtonOther.setText("Other");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jRadioButtonMale)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonFemale)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonOther)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonMale, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonOther, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setForeground(new java.awt.Color(153, 255, 255));

        jTextFieldContry.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldContry.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldContry.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldContry.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldContry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContryActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("Contry");

        jTextFieldCity.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldCity.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldCity.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldCity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCityActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(0, 51, 204));
        jLabel12.setText("City");

        jTextFieldPostal.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldPostal.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldPostal.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldPostal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPostalActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(0, 51, 204));
        jLabel13.setText("Postal Code");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldPostal, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(jTextFieldCity)
                    .addComponent(jTextFieldContry))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldContry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Name");

        jLabel22.setForeground(new java.awt.Color(0, 51, 204));
        jLabel22.setText("Gender");

        jLabel21.setForeground(new java.awt.Color(0, 51, 204));
        jLabel21.setText("Address");

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setForeground(new java.awt.Color(153, 255, 255));

        jTextFieldDes.setEditable(false);
        jTextFieldDes.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldDes.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldDes.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldDes.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jTextFieldDes, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTextFieldDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jTextFieldEmail.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldEmail.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jLabel23.setForeground(new java.awt.Color(0, 51, 204));
        jLabel23.setText("Email");

        jTextFieldPhone.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldPhone.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldPhone.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhoneActionPerformed(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(0, 51, 204));
        jLabel24.setText("Phone");

        jLabel25.setForeground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(jTextFieldEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel26.setForeground(new java.awt.Color(0, 51, 204));
        jLabel26.setText("Contact");

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setForeground(new java.awt.Color(153, 255, 255));

        jLabel27.setForeground(new java.awt.Color(0, 51, 204));
        jLabel27.setText("DOB");

        jTextFieldCtzn.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldCtzn.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldCtzn.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldCtzn.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldCtzn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCtznActionPerformed(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(0, 51, 204));
        jLabel28.setText("Ctzn No.");

        jLabel29.setForeground(new java.awt.Color(0, 51, 204));

        jTextFieldDob.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldDob.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldDob.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldDob.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldDob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCtzn, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDob, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextFieldDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel29))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCtzn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButtonUpdateProf.setBackground(new java.awt.Color(0, 51, 153));
        jButtonUpdateProf.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonUpdateProf.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdateProf.setText("Update");
        jButtonUpdateProf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonUpdateProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUpdateProfMouseClicked(evt);
            }
        });
        jButtonUpdateProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateProfActionPerformed(evt);
            }
        });

        jButtonClear2.setBackground(new java.awt.Color(0, 255, 255));
        jButtonClear2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jButtonClear2.setForeground(new java.awt.Color(102, 102, 0));
        jButtonClear2.setText("Clear Fields");
        jButtonClear2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonClear2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClear2MouseClicked(evt);
            }
        });
        jButtonClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClear2ActionPerformed(evt);
            }
        });

        jTextID.setEditable(false);
        jTextID.setBackground(new java.awt.Color(204, 255, 255));
        jTextID.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextID.setForeground(new java.awt.Color(102, 102, 255));
        jTextID.setBorder(null);
        jTextID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDActionPerformed(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(0, 51, 204));
        jLabel30.setText("ID:");

        jTextFieldPassword.setBackground(new java.awt.Color(204, 255, 255));
        jTextFieldPassword.setFont(new java.awt.Font("Poppins", 2, 18)); // NOI18N
        jTextFieldPassword.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPasswordActionPerformed(evt);
            }
        });

        jLabel31.setForeground(new java.awt.Color(0, 51, 204));
        jLabel31.setText("Password");

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
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonUpdateProf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonBack)
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabelTitle1)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(150, 150, 150))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBack)
                    .addComponent(jLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonUpdateProf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void jTextFieldCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCityActionPerformed

    private void jTextFieldPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPostalActionPerformed

    private void jTextFieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFirstNameActionPerformed

    private void jTextFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLastNameActionPerformed

    private void jTextFieldContryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContryActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jTextFieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhoneActionPerformed

    private void jTextFieldCtznActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCtznActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCtznActionPerformed

    private void jButtonUpdateProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateProfMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpdateProfMouseClicked

    private void jButtonUpdateProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateProfActionPerformed
        updateProfile();
        
    }//GEN-LAST:event_jButtonUpdateProfActionPerformed

    private void jButtonClear2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClear2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClear2MouseClicked

    private void jButtonClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClear2ActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_jButtonClear2ActionPerformed

    private void jTextIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDActionPerformed

    private void jTextFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPasswordActionPerformed

    private void jTextFieldDobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDobActionPerformed

    private void jTextFieldDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        DeliveryStaff ds = new  DeliveryStaff();
        this.setVisible(false);
        ds.setVisible(true);
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
            java.util.logging.Logger.getLogger(MyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonClear2;
    private javax.swing.JButton jButtonUpdateProf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JRadioButton jRadioButtonOther;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldContry;
    private javax.swing.JTextField jTextFieldCtzn;
    private javax.swing.JTextField jTextFieldDes;
    private javax.swing.JTextField jTextFieldDob;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldPostal;
    public static javax.swing.JTextField jTextID;
    // End of variables declaration//GEN-END:variables
}
