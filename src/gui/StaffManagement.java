package gui;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class StaffManagement extends javax.swing.JPanel {

    public StaffManagement() {
        initComponents();
        loadRole();
        loadGender();
        loadStaff();
        loadSpecialization();

        jComboBox3.setVisible(false);
        jLabel10.setVisible(false);
    }

    void reset() {

        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField3.setText("");
        jTextField4.setText("");
        jPasswordField1.setText("");
        jComboBox4.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jTable1.clearSelection();
        jTextField3.setEditable(true);

    }

    void loadStaff() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `staff` ");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString("first_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("role"));
                v.add(rs.getString("nic"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("password"));
                v.add(rs.getString("specialization"));
                v.add(rs.getString("gender"));

                model.addRow(v);
            }

        } catch (Exception ex) {
            Logger.getLogger(StaffManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void loadSpecialization() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox3.getModel();
        model.removeAllElements();

        Vector v = new Vector();

        v.add("Select Specialization");
        v.add("Cardiology");
        v.add("Neurology");
        v.add("Orthopedics");
        v.add("General Paractice");

        model.addAll(v);
        jComboBox3.setSelectedIndex(0);
    }

    void loadGender() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox4.getModel();
        model.removeAllElements();

        Vector v = new Vector();

        v.add("Select Gender");
        v.add("Male");
        v.add("Female");
        v.add("Other");

        model.addAll(v);
        jComboBox4.setSelectedIndex(0);
    }

    void loadRole() {

        DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox1.getModel();
        model.removeAllElements();

        Vector v = new Vector();

        v.add("Select Role");
        v.add("Admin");
        v.add("Doctor");
        v.add("Nurse");
        v.add("Parmacist");

        model.addAll(v);
        jComboBox1.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();

        jLabel9.setText("jLabel9");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Staff Management");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 40));

        jLabel2.setText("First Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 40));

        jLabel3.setText("Last Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 140, -1));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 140, -1));

        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 190, -1));

        jLabel6.setText("Nic");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 140, -1));

        jLabel7.setText("Mobile number");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 140, -1));

        jLabel8.setText("Password");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

        jLabel10.setText("Specialization");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 130, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Role", "Nic", "Mobile Number", "Password", "Specialization", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 980, 260));

        jButton1.setText("Create  New Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 150, 50));

        jButton2.setText("Update Selected ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 150, 50));

        jLabel11.setText("Gender");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 140, -1));
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 160, -1));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        boolean isInsurance = "Doctor".equals(jComboBox1.getSelectedItem());
        jComboBox3.setVisible(isInsurance);
        jLabel10.setVisible(isInsurance);


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {

            jPasswordField1.setEchoChar((char) 0);
        } else {
            jPasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String firstName = jTextField1.getText();
        String lastName = jTextField2.getText();
        String role = jComboBox1.getSelectedItem().toString();
        String nic = jTextField3.getText();
        String mobile = jTextField4.getText();
        char[] passwordchr = jPasswordField1.getPassword();
        String password = new String(passwordchr);
        String gender = jComboBox4.getSelectedItem().toString();
        String spe = jComboBox3.getSelectedItem().toString();

        if (firstName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter  First Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter  Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (role.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Role", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter  Nic", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (password.equals(null)) {
            JOptionPane.showMessageDialog(this, "Please Enter Password", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gender.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Gender", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (spe.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Specification", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            if ("Select Specialization".equals(spe)) {

                spe = "-";
            }

            try {
                ResultSet rs = MySQL.execute("SELECT * FROM `staff` WHERE `nic`='" + nic + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Nic Allready Added", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    MySQL.execute("INSERT INTO `staff` (`first_name`,`last_name`,`role`,`nic`,`phone`,`password`,`specialization`,`gender`) VALUES ('" + firstName + "','" + lastName + "','" + role + "','" + nic + "','" + mobile + "','" + password + "','" + spe + "','" + gender + "')");
                    JOptionPane.showMessageDialog(
                            this,
                            "Operation Successful!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    loadStaff();
                    reset();

                    ResultSet rs2 = MySQL.execute("SELECT * FROM `staff` WHERE `staff_id`='" + 3 + "'");

                    if (rs2.next()) {
                        System.out.println(rs2.getString("password"));
                    }
                }

            } catch (Exception ex) {
                Logger.getLogger(StaffManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {

            int row = jTable1.getSelectedRow();

            String firstName = jTable1.getValueAt(row, 0).toString();
            String lastName = jTable1.getValueAt(row, 1).toString();
            String role = jTable1.getValueAt(row, 2).toString();
            String nic = jTable1.getValueAt(row, 3).toString();
            String mobile = jTable1.getValueAt(row, 4).toString();
            String password = jTable1.getValueAt(row, 5).toString();
            String spe = jTable1.getValueAt(row, 6).toString();
            String gender = jTable1.getValueAt(row, 7).toString();

            if ("-".equals(spe)) {
                jComboBox4.setSelectedItem("Select Specialization");
            }

            jTextField1.setText(firstName);
            jTextField2.setText(lastName);
            jComboBox1.setSelectedItem(role);
            jTextField3.setText(nic);
            jTextField3.setEditable(false);
            jTextField4.setText(mobile);
            jPasswordField1.setText(password);
            jComboBox3.setSelectedItem(spe);
            jComboBox4.setSelectedItem(gender);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable1.getSelectedRow();

        if (row != -1) {

            String firstName = jTextField1.getText();
            String lastName = jTextField2.getText();
            String role = jComboBox1.getSelectedItem().toString();
            String nic = jTextField3.getText();
            String mobile = jTextField4.getText();
            char[] passwordchr = jPasswordField1.getPassword();
            String password = new String(passwordchr);
            String gender = jComboBox4.getSelectedItem().toString();
            String spe = jComboBox3.getSelectedItem().toString();

            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter  First Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter  Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (role.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select Role", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter  Nic", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (password.equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Password", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select Gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (spe.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select Specification", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                if ("Select Specialization".equals(spe)) {

                    spe = "-";
                }

                if (role.equals("Nurse") || role.equals("Admin") || role.equals("Pharmacist")) {
                    spe = "-";
                }

                try {
                    MySQL.execute("UPDATE `staff` SET `first_name`='" + firstName + "',`last_name`='" + lastName + "',`role`='" + role + "',`nic`='" + nic + "',`phone`='" + mobile + "',`password`='" + password + "',`specialization`='" + spe + "',`gender`='" + gender + "' WHERE `nic`='" + nic + "'");

                    JOptionPane.showMessageDialog(
                            this,
                            "Operation Successful!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    loadStaff();
                    reset();
                } catch (Exception ex) {
                    Logger.getLogger(StaffManagement.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else {

            JOptionPane.showMessageDialog(this, "Please Select User", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
