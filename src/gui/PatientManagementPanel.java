package gui;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MedicalReportModel;
import model.MySQL;
import model.PatientModel;

interface PatientData {

    PatientModel getDetails();

    String getPatientId();

    MedicalReportModel getMedicalInfo();

}

class BasicPatientData implements PatientData {

    private PatientModel patient;

    public BasicPatientData(PatientModel patient) {
        this.patient = patient;
    }

    @Override
    public PatientModel getDetails() {

        return patient;
    }

    @Override
    public String getPatientId() {

        return patient.getNic();
    }

    @Override
    public MedicalReportModel getMedicalInfo() {

        return null;
    }
}

abstract class PatientDecorator implements PatientData {

    protected PatientData patientData;

    public PatientDecorator(PatientData patientData) {
        this.patientData = patientData;
    }

    @Override
    public PatientModel getDetails() {
        return patientData.getDetails();
    }

    @Override
    public String getPatientId() {
        return patientData.getPatientId();
    }

    @Override
    public MedicalReportModel getMedicalInfo() {
        return patientData.getMedicalInfo();
    }
}

class MedicalRecordDecorator extends PatientDecorator {

    private MedicalReportModel medicalRecord;

    public MedicalRecordDecorator(PatientData patientData, MedicalReportModel medicalRecord) {
        super(patientData);
        this.medicalRecord = medicalRecord;
    }

    @Override
    public MedicalReportModel getMedicalInfo() {
        return medicalRecord;
    }
}

public class PatientManagementPanel extends javax.swing.JPanel {

    

    private Map<String, PatientData> patients = new HashMap<>();
    private DefaultTableModel model;

    public PatientManagementPanel() {
        initComponents();
        loadPatientFromDb();
        loadGender();

      
     
    }

    private void loadGender() {
        Vector v = new Vector();
        v.add("Select Gender");
        v.add("Male");
        v.add("Female");
        v.add("Other");

        DefaultComboBoxModel model = (DefaultComboBoxModel) genderCombo.getModel();
        model.removeAllElements();

        model.addAll(v);
        genderCombo.setSelectedIndex(0);
    }

    public void reset() {

        nicfield.setText("");
        nicfield.setEditable(true);
        firstNameField.setText("");
        lastNameField.setText("");
        dobField.setText("");
        mobileField.setText("");
        addressField.setText("");
        genderCombo.setSelectedIndex(0);
        jTable1.clearSelection();
        loadPatientFromDb();
        
        System.out.println("call");

    }

    private void loadPatientFromDb() {

        try {

            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            ResultSet rs = MySQL.execute("SELECT * FROM `patients`");

            while (rs.next()) {
                PatientModel p = new PatientModel(rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("dob"),
                        rs.getString("phone"),
                        rs.getString("nic"),
                        rs.getString("address"),
                        rs.getString("gender")
                        
                );

                PatientData pp = new BasicPatientData(p);
                patients.put(String.valueOf(p.getNic()), pp);

                ResultSet rs2 = MySQL.execute("SELECT * FROM `medical records` WHERE patients_nic='" + p.getNic() + "'");
                if (rs2.next()) {

                    System.out.println("done done");
                    MedicalReportModel m = new MedicalReportModel(
                            rs2.getString("diagnosis"),
                            rs2.getString("treatment_plan"),
                            rs2.getString("allergies"),
                            rs2.getString("medications"),
                            rs2.getString("created_at"),
                            rs2.getString("updated_at"),
                            rs2.getString("patients_nic"),
                            rs2.getInt("record_id")
                    );
                    pp = new MedicalRecordDecorator(pp, m);
                   patients.put(String.valueOf(p.getNic()), pp);
                }

                Vector v = new Vector();

                v.add(rs.getString("nic"));
                v.add(rs.getString("first_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("dob"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("address"));
                v.add(rs.getString("gender"));

                model.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nicfield = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        dobField = new javax.swing.JTextField();
        mobileField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        genderCombo = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setText("Nic");

        jLabel4.setText("First Name");

        jLabel5.setText("Last Name");

        jLabel6.setText("Birth day");

        jLabel7.setText("Mobile Number");

        jLabel8.setText("address");

        jLabel9.setText("Gender");

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton6.setBackground(new java.awt.Color(0, 255, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nicfield)
                    .addComponent(firstNameField)
                    .addComponent(lastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dobField)
                    .addComponent(mobileField)
                    .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(nicfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel8))
                            .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "nic", "First Name", "Last Name", "Birth Day", "Mobile Number", "Address", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Patients Record");

        jButton1.setText("Add Patient");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Selected");

        jButton3.setText("Update Selected");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("NIC");

        jButton4.setText("Serach By Nic");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Show medical history");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton5)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            int row = jTable1.getSelectedRow();

            String nic = jTable1.getValueAt(row, 0).toString();
            String firstName = jTable1.getValueAt(row, 1).toString();
            String lastName = jTable1.getValueAt(row, 2).toString();
            String dob = jTable1.getValueAt(row, 3).toString();
            String mobile = jTable1.getValueAt(row, 4).toString();
            String address = jTable1.getValueAt(row, 5).toString();
            String gender = jTable1.getValueAt(row, 6).toString();

            nicfield.setText(nic);
            nicfield.setEditable(false);

            firstNameField.setText(firstName);
            lastNameField.setText(lastName);
            dobField.setText(dob);
            mobileField.setText(mobile);
            addressField.setText(address);
            genderCombo.setSelectedItem(gender);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nic = nicfield.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dob = dobField.getText();
        String mobile = mobileField.getText();
        String address = addressField.getText();
        String gender = (String) genderCombo.getSelectedItem();

        if (nic.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Please Enter  Nic Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (firstName.isEmpty()) {
              JOptionPane.showMessageDialog(this, "Please Enter  First Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lastName.isEmpty()) {
              JOptionPane.showMessageDialog(this, "Please Enter  Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (dob.isEmpty()) {
              JOptionPane.showMessageDialog(this, "Please Enter  Birthdaty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
              JOptionPane.showMessageDialog(this, "Please Enter Your Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (address.isEmpty()) {
              JOptionPane.showMessageDialog(this, "Please Enter Your Address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gender.equals("Select Gender")) {
              JOptionPane.showMessageDialog(this, "Please Select gender", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
         
            try {
                MySQL.execute("INSERT INTO `patients` (`first_name`,`last_name`,`dob`,`phone`,`nic`,`address`,`gender`) VALUES ('" + firstName + "','" + lastName + "','" + dob + "','" + mobile + "','" + nic + "','" + address + "','" + gender + "')");
                reset();

            } catch (Exception ex) {
//                Logger.getLogger(PatientManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int row = jTable1.getSelectedRow();

        if (row != -1) {

            String nic = nicfield.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String dob = dobField.getText();
            String mobile = mobileField.getText();
            String address = addressField.getText();
            String gender = (String) genderCombo.getSelectedItem();

            if (nic.isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Please Enter Your Nic Number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (firstName.isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Please Enter Your First Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (lastName.isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Please Enter Your Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (dob.isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Please Enter Your Birthdaty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Please Enter Your Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (address.isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Please Enter Your Address", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.equals("Select Gender")) {
                  JOptionPane.showMessageDialog(this, "Please Select gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    MySQL.execute("UPDATE `patients` SET "
                            + "`first_name`='" + firstName + "',"
                            + "`last_name`='" + lastName + "',"
                            + "`dob`='" + dob + "',"
                            + "`phone`='" + mobile + "',"
                            + "`address`='" + address + "',"
                            + "`gender`='" + gender + "' "
                            + "WHERE `nic`='" + nic + "'");
                    reset();
                } catch (Exception ex) {
//                    Logger.getLogger(PatientManagement.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else {
//            JOptionPane.showMessageDialog(this, "please select user", "message", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String nic = search.getText();

        if (!nic.isEmpty()) {

            PatientData patient = patients.get(nic);

            if (patient != null) {
                PatientModel patientDetails = patient.getDetails();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                Vector v = new Vector();
                v.add(patientDetails.getNic());
                v.add(patientDetails.getFirstName());
                v.add(patientDetails.getLastName());
                v.add(patientDetails.getDob());
                v.add(patientDetails.getMobile());
                v.add(patientDetails.getAddress());
                v.add(patientDetails.getGender());

                model.addRow(v);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int row = jTable1.getSelectedRow();

        if (row != -1) {

            String nic = jTable1.getValueAt(row, 0).toString();
            PatientData pd = patients.get(nic);
            
            PatientModel patient = pd.getDetails();

            if (pd != null) {
                MedicalReportModel report = pd.getMedicalInfo();
                if (report != null) {
                    System.out.println(report.getDiagnosis());
                    
                JFrame frame = new JFrame("Medical Report for " + nic);
                MedicalReportPanel ppp = new MedicalReportPanel(nic, report,patient.getNic());
                frame.add(ppp);
                frame.pack();
                frame.setLocationRelativeTo(this);
                frame.setVisible(true);
                    
//                     reportPanel.loadData(nic, report);
                } else {
                    
                    JFrame frame = new JFrame("Medical Report for " + nic);
                MedicalReportPanel ppp = new MedicalReportPanel(nic, report,patient.getNic());
                frame.add(ppp);
                frame.pack();
                frame.setLocationRelativeTo(this);
                frame.setVisible(true);
                    
                    
                    System.out.println("No medical record found for this patient.");
                }
            }else{
                System.out.println("not found user");
            }

        } else {
              JOptionPane.showMessageDialog(this, "Please Select Patient", "Warning", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField dobField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JComboBox<String> genderCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField mobileField;
    private javax.swing.JTextField nicfield;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
