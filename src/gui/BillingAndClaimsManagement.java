package gui;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.Claim;
import model.Financial;
import model.MySQL;
import patterns.FinancialReport;

public class BillingAndClaimsManagement extends javax.swing.JFrame {

    public BillingAndClaimsManagement() {
        initComponents();
        loadPaymentMethod();
        setInsuranceFieldsVisible(false);
        loadServicetype();

        jButton1.setVisible(false);

        loadInsurenceClaim();
    }

    private String patientName;
    private String patientMobile;
    private String patientdob;

    private int appointmentid;
    private String appointmenttype;

    void reset() {

        jTextField3.setText("");
        jTextField1.setText("");
        jTextField1.setEditable(true);
        jComboBox1.setEnabled(true);
        jTextField2.setText("");

    }

    void loadInsurenceClaim() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `insurance` ");

            while (rs.next()) {

                String nic = rs.getString("patientNic");
                String insurenceCompany = rs.getString("insurance_company");
                String policyNumber = rs.getString("policy_number");
                String holderName = rs.getString("policyHolderName");
                String servicetype = rs.getString("servicetype");
                String amountText = rs.getString("claim_amount");
                double amount = Double.parseDouble(amountText);

                JButton b = new JButton();

                Vector v = new Vector();
                v.add(rs.getInt("claim_id"));
                v.add(rs.getString("patientNic"));
                v.add(rs.getString("policy_number"));
                v.add(rs.getString("servicetype"));
                v.add(rs.getString("claim_amount"));

                int bilId = rs.getInt("billing_bill_id");

                ResultSet rr = MySQL.execute("SELECT * FROM `patients` WHERE `nic`='" + nic + "'");
                ResultSet rrr = MySQL.execute("SELECT * FROM `billing` WHERE `bill_id`='" + bilId + "'");

                JButton btn = new JButton(rs.getString("claim_status"));
                JButton btn2 = new JButton();

                if ("Approved".equalsIgnoreCase(rs.getString("claim_status"))) {
                    btn.setBackground(Color.GREEN);
                    btn.setForeground(Color.black);
                    btn.addActionListener(e -> System.out.println("approve clicked"));

                    v.add(btn);

                    btn2.setText("Generate Report");
                    btn2.setBackground(Color.orange);
                    btn2.setForeground(Color.black);

                    btn2.addActionListener(e -> {

                        try {
                            if (rr.next()) {

                                if (rrr.next()) {

                                    int api = rrr.getInt("appointments_appointment_id");
                                    String pn = rr.getString("first_name") + " " + rr.getString("last_name");
                                    String pm = rr.getString("phone");
                                    String pd = rr.getString("dob");

                                    Financial f = new Financial(pn, api, servicetype, amount,
                                            pm, pd, insurenceCompany,
                                            policyNumber, holderName, true);

                                    f.accept(new FinancialReport());
                                }

                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    );

                    v.add(btn2);
                } else {
                    btn.setBackground(Color.YELLOW);
                    btn.addActionListener(e -> System.out.println("pending clicked"));

                    v.add(btn);

                    btn2.setText("View");
                    btn2.setBackground(Color.GREEN);
                    btn2.setForeground(Color.black);
                    v.add(btn2);
                }

                model.addRow(v);
            }

            jTable1.getColumn("Status").setCellRenderer(new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    return (Component) value; 
                }
            });

            jTable1.getColumn("Action").setCellRenderer(new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    return (Component) value; 
                }
            });

            jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    int row = jTable1.rowAtPoint(e.getPoint());
                    int col = jTable1.columnAtPoint(e.getPoint());

                    if (col == jTable1.getColumnModel().getColumnIndex("Action")) {
                        Object value = jTable1.getValueAt(row, col);
                        if (value instanceof JButton btn) {
                            String text = btn.getText();
                            if ("Approved".equalsIgnoreCase(text)) {
                                System.out.println("approve clicked for row " + row);
                            } else {
                                System.out.println("pending clicked for row " + row);
                            }
                        }
                    }
                }
            });

            jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    int row = jTable1.rowAtPoint(e.getPoint());
                    int col = jTable1.columnAtPoint(e.getPoint());

                    if (col == jTable1.getColumnModel().getColumnIndex("Action")) {
                        Object value = jTable1.getValueAt(row, col);
                        if (value instanceof JButton btn) {
                            btn.doClick(); 
                        }
                    }
                }
            });

        } catch (Exception ex) {
            Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int id;
    int billingId;

    void setInsuranceFieldsVisible(boolean visible) {

        jLabel7.setVisible(visible);
        jTextField4.setVisible(visible);

        jLabel8.setVisible(visible);
        jTextField5.setVisible(visible);

        jLabel9.setVisible(visible);
        jTextField6.setVisible(visible);

        jButton1.setVisible(visible);
    }

    void loadServicetype() {

        DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox1.getModel();
        model.removeAllElements();

        Vector v = new Vector();
        v.add("consultation");
        v.add("surgery");
        v.add("diagnostic");
        v.add("follow up");

        model.addAll(v);
        jComboBox1.setSelectedIndex(0);

    }

    void loadPaymentMethod() {

        DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox2.getModel();
        model.removeAllElements();

        Vector v = new Vector();
        v.add("Direct Payment");
        v.add("Insurance");

        model.addAll(v);
        jComboBox2.setSelectedIndex(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Billing & Claims Management");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Patient nic");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Service Type");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Amount");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Payment Method");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Insurence Company");

        jLabel8.setText("Policy Number");

        jLabel9.setText("Policy Holder Name");

        jButton2.setText("Process Billing");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Submit  Insurence Claim");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, 194, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(136, 136, 136)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Claim ID", "Patient Nic", "Policy Number", "Service Type", "Amount", "Status", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
        }

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("Pending Insurance Claims.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ClaimProcessor processor = new ClaimProcessor();

        String nic = jTextField1.getText();
        String amount = jTextField2.getText();

        String companyName = jTextField4.getText();
        String policyNumber = jTextField5.getText();
        String policyholderName = jTextField6.getText();
        String status = "Pending";
        String type = jComboBox1.getSelectedItem().toString();

        if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Add Appointment Details", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (companyName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Company Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (policyNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Policy Number ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (policyholderName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Policy Holder Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                ResultSet rss = MySQL.execute("SELECT * FROM `billing` WHERE `appointments_appointment_id`='" + id + "' AND `patients_nic`='" + nic + "'");

                if (rss.next()) {
                    JOptionPane.showMessageDialog(this, "Allready Submitted", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    Claim standardClaim = new Claim(nic, "CONSULTATION", Double.parseDouble("100"));
                    boolean result1 = processor.processStandardClaim(standardClaim);

                    try {
                        MySQL.execute("INSERT INTO `billing` (`total_amount`,`status`,`appointments_appointment_id`,`patients_nic`) VALUES ('" + amount + "','" + status + "','" + id + "','" + nic + "')");
                        ResultSet rs = MySQL.execute("SELECT * FROM `billing` WHERE `appointments_appointment_id`='" + id + "' AND `patients_nic`='" + nic + "'");

                        if (rs.next()) {
                            billingId = rs.getInt("bill_id");

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (result1) {
                        System.out.println(String.valueOf(billingId));
                        status = "Approved";
                        String billingStatus = "Paid";

                        MySQL.execute("INSERT INTO `insurance` (`insurance_company`,`claim_status`,`claim_amount`,`billing_bill_id`,`policy_number`,`policyHolderName`,`patientNic`,`servicetype`) VALUES ('" + companyName + "','" + status + "','" + amount + "','" + billingId + "','" + policyNumber + "','" + policyholderName + "','" + nic + "','" + type + "')");
                        MySQL.execute("UPDATE `billing` SET `status`='" + billingStatus + "' WHERE `bill_id`='" + billingId + "'");

                        ResultSet u = MySQL.execute("SELECT * FROM `insurance` WHERE `billing_bill_id`='" + billingId + "'");

                        if (u.next()) {

                            int id = u.getInt("claim_id");

                            MySQL.execute("UPDATE `billing` SET `insurance_claim_id1`='" + id + "' WHERE `bill_id`='" + billingId + "'");
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                "Insurence Approved  successfully!",
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        loadInsurenceClaim();
                    } else {
                        String status2 = "Pending";
                        MySQL.execute("INSERT INTO `insurance` (`insurance_company`,`claim_status`,`claim_amount`,`billing_bill_id`,`policy_number`,`policyHolderName`,`patientNic`) VALUES ('" + companyName + "','" + status2 + "','" + amount + "','" + billingId + "','" + policyNumber + "','" + policyholderName + "','" + nic + "')");

                        JOptionPane.showMessageDialog(
                                null,
                                "Insurence Claim Pending",
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        loadInsurenceClaim();
                    }
                }

            } catch (Exception ex) {
                Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        boolean isInsurance = "Insurance".equals(jComboBox2.getSelectedItem());
        setInsuranceFieldsVisible(isInsurance);
        jButton1.setVisible(isInsurance);
        jButton2.setVisible(!isInsurance);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        jTextField1.setEditable(false);
        jComboBox1.setEnabled(false);

        int appointmentId = Integer.parseInt(jTextField3.getText());

        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `appointments` WHERE `appointment_id`='" + appointmentId + "' ");

            if (rs.next()) {
                id = rs.getInt("appointment_id");
                jTextField1.setText(rs.getString("patients_nic"));
                jComboBox1.setSelectedItem(rs.getString("type"));

                appointmentid = rs.getInt("appointment_id");
                appointmenttype = rs.getString("type");

            }

        } catch (Exception ex) {
            Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String nic = jTextField1.getText();
        String type = jComboBox1.getSelectedItem().toString();
        String amountText = jTextField2.getText();
        String appointmentIdText = jTextField3.getText();
        int appointmentId = 0;

        ClaimProcessor processor = new ClaimProcessor();

        if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Add Appointment Details", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(appointmentIdText.isEmpty()){
             appointmentId = Integer.parseInt(appointmentIdText);
        
        } else if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            ResultSet patientdata;
            try {
                patientdata = MySQL.execute("SELECT * FROM `patients` WHERE `nic`='" + nic + "'");

                if (patientdata.next()) {

                    patientName = patientdata.getString("first_name");
                    patientMobile = patientdata.getString("phone");
                    patientdob = patientdata.getString("dob");
                }
            } catch (Exception ex) {
                Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

            double amount = Double.parseDouble(amountText);
            Claim directClaim = new Claim(nic, type, amount);
            boolean result3 = processor.processDirectPayment(directClaim);
            System.out.println(result3);

            try {
                ResultSet check = MySQL.execute("SELECT * FROM `billing` WHERE `appointments_appointment_id`='" + appointmentId + "'");

                if (check.next()) {

                    if ("Paid".equals(check.getString("status"))) {

                        JOptionPane.showMessageDialog(this, "This Payment AllReady Pay", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {

                        if (result3) {
                            String status = "Paid";

                            MySQL.execute("UPDATE `billing` SET `status`='" + status + "' WHERE `appointments_appointment_id`='" + appointmentId + "'");

                            int result = JOptionPane.showConfirmDialog(
                                    this,
                                    "Payment completed successfully. Would you like to generate the bill now?",
                                    "Cancel",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE
                            );

                            if (result == JOptionPane.YES_OPTION) {

                                System.out.println("ok generate bill update");

                            }

                        }

                    }
                } else {

                    if (result3) {
                        String status = "Paid";
                        MySQL.execute("INSERT INTO `billing` (`total_amount`,`status`,`appointments_appointment_id`,`patients_nic`) VALUES ('" + amount + "','" + status + "','" + id + "','" + nic + "')");

                        int result = JOptionPane.showConfirmDialog(
                                this,
                                "Payment completed successfully. Would you like to generate the bill now?",
                                "Cancel",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE
                        );

                        if (result == JOptionPane.YES_OPTION) {

                            Financial finance = new Financial(patientName, appointmentid, appointmenttype, amount, patientMobile, patientdob, false);

                            finance.accept(new FinancialReport());

                        }

                        reset();
                    }

                }

            } catch (Exception ex) {
                Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillingAndClaimsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingAndClaimsManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
