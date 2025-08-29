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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Staff Management");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Role");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Nic");

        jLabel7.setText("Mobile number");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Password");

        jLabel10.setText("Specialization");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jButton1.setText("Create  New Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Selected ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Gender");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(62, 62, 62)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBox1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11)
                        .addGap(52, 52, 52)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 528, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
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
