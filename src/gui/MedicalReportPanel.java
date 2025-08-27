package gui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.AppContext;
import model.MedicalReportModel;
import model.MySQL;
import model.User;

public class MedicalReportPanel extends javax.swing.JPanel {
    
    private String nic;   // patient NIC
    private List<MedicalReportModel> reports;
    private String id;
    
    private int recordId;
    
    User currentUser = AppContext.getInstance().getCurrentUser();
    
    public MedicalReportPanel(String nic, List<MedicalReportModel> reports, String id) {
        initComponents();
        
        loadData(nic, reports);
        this.nic = nic;
        this.reports = reports;
        this.id = id;
        
        jButton2.setVisible(currentUser.canAccess("Update Medical Report"));
        jButton3.setVisible(currentUser.canAccess("Add New Medical Report"));
        jButton2.setEnabled(false);
        
//        addMedicalRecord(currentUser.canAccess("Enter medical Details"));
    }
    
    
//    void addMedicalRecord(boolean isShow){
//    
//    jLabel1.setVisible(isShow);
//    diagnosisField.setVisible(isShow);
//    jLabel2.setVisible(isShow);
//    jTextArea1.setVisible(isShow);
//    jLabel3.setVisible(isShow);
//    allergiesField1.setVisible(isShow);
//    jLabel4.setVisible(isShow);
//    medicationField1.setVisible(isShow);
//    }
    
    void reset() {
        
        diagnosisField.setText("");
        jTextArea1.setText("");
        allergiesField1.setText("");
        medicationField1.setText("");
        jButton3.setEnabled(true);
          jButton2.setEnabled(false);
        
    }
    
    public void loadData(String nic, List<MedicalReportModel> reports) {
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for (MedicalReportModel r : reports) {
            Vector v = new Vector();
            
            v.add(r.getId());
            v.add(r.getCreatedAt());
            v.add(r.getDiagnosis());
            v.add(r.getTreatmentPlan());
            v.add(r.getAllergies());
            v.add(r.getMedications());
            
            model.addRow(v);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        diagnosisField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        allergiesField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        medicationField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Diagnosis");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Treatment");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Allergies");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Medications");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Record Id", "Date", "Diagnosis", "Treatment", "Allegies", "Medications"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setText("Add Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(allergiesField1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(medicationField1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(21, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diagnosisField, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagnosisField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(allergiesField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(medicationField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
        
        PatientManagementPanel pm = new PatientManagementPanel();
        pm.reset();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       
             int row = jTable1.getSelectedRow();
            
         
      
        
        if (row == -1) {
            
            JOptionPane.showMessageDialog(this, "Please Select Row", "Warning", JOptionPane.WARNING_MESSAGE);
            
        } else {
            
              int lastRow = jTable1.getRowCount() - 1;
               if (lastRow == row) {
            
            
             String diagnosis = diagnosisField.getText();
            String treatment = jTextArea1.getText();
            String allergie = allergiesField1.getText();
            String medication = medicationField1.getText();
            
            if (diagnosis.isEmpty()) {
                
                System.out.println("Please enter diagnosis");
            } else if (treatment.isEmpty()) {
                System.out.println("Please enter treatement");
            } else if (allergie.isEmpty()) {
                System.out.println("Please enter allergie");
            } else if (medication.isEmpty()) {
                System.out.println("Plase enter mediacation");
            } else {
                
                try {
                    MySQL.execute("UPDATE `medical records` SET `diagnosis`='" + diagnosis + "',`treatment_plan`='" + treatment + "',`allergies`='" + allergie + "',`medications`='" + medication + "',`patients_nic`='" + id + "' WHERE `record_id`='" + recordId + "' ");
                    JOptionPane.showMessageDialog(
                            null,
                            "Operation completed successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    
                    PatientManagementPanel p = new PatientManagementPanel();
                    p.check(nic, this);
                    
                    reset();
                } catch (Exception e) {
                    Logger.getLogger(MedicalReportPanel.class.getName()).log(Level.SEVERE, null, e);
                }
                
                System.out.println("Have report");
                
            }
            
            
            }else{
               
               JOptionPane.showMessageDialog(this, "Only Last Record Can Update", "Warning", JOptionPane.WARNING_MESSAGE);
               reset();
               }
        
            
            
           
            
        }
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String diagnosis = diagnosisField.getText();
        String treatment = jTextArea1.getText();
        String allergi = allergiesField1.getText();
        String medication = medicationField1.getText();
        
        if (diagnosis.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Diagnosis", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (treatment.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Treatments", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (allergi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Allergi", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (medication.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Medication", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(date);
            
            try {
                MySQL.execute("INSERT INTO `medical records` (`diagnosis`,`treatment_plan`,`allergies`,`medications`,`created_at`,`patients_nic`) VALUES ('" + diagnosis + "','" + treatment + "','" + allergi + "','" + medication + "','" + dateString + "','" + nic + "')");
                JOptionPane.showMessageDialog(
                            null,
                            "Operation completed successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                
                PatientManagementPanel p = new PatientManagementPanel();
                p.check(nic, this);
                
                reset();
                
            } catch (Exception ex) {
                Logger.getLogger(MedicalReportPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        
        if(evt.getClickCount()==1){
         reset();
        }



        if (evt.getClickCount() == 2) {
            
               jButton2.setEnabled(true);
            jButton3.setEnabled(false);
            
//            int lastRow = jTable1.getRowCount() - 1;
            int selectedRow = jTable1.getSelectedRow();
//            
//            if (lastRow == selectedRow) {
                
                recordId = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
                String diagnosis = jTable1.getValueAt(selectedRow, 1).toString();
                String treatment = jTable1.getValueAt(selectedRow, 2).toString();
                String allergi = jTable1.getValueAt(selectedRow, 3).toString();
                String medication = jTable1.getValueAt(selectedRow, 4).toString();
                
                diagnosisField.setText(diagnosis);
                jTextArea1.setText(treatment);
                allergiesField1.setText(allergi);
                medicationField1.setText(medication);
//            } else {
//                JOptionPane.showMessageDialog(this, "Only Last Record Can Update", "Warning", JOptionPane.WARNING_MESSAGE);
//            }
            
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField allergiesField1;
    private javax.swing.JTextField diagnosisField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField medicationField1;
    // End of variables declaration//GEN-END:variables
}
