package gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import model.AppoinmentModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.MySQL;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class BookNewAppoinmentPanel extends javax.swing.JPanel {

    private AppointmentMediator mediator;
    private String mobile;
    private String gender;

    public BookNewAppoinmentPanel() {
        initComponents();
        loadCombobox();

        jCheckBox1.setVisible(false);
        jCheckBox2.setVisible(false);
        jCheckBox3.setVisible(false);

        datechooser.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Date selectedDate = datechooser.getDate();
                if (selectedDate != null) {
                    jCheckBox1.setVisible(true);
                    jCheckBox2.setVisible(true);
                    jCheckBox3.setVisible(true);
                }
            }
        });

    }

    void reset() {

        patientf.setText("");
        specombo.setSelectedItem("Any");
        doctorcombo.setSelectedItem("Select Doctor");
        branchcombo.setSelectedItem("Select");
        datechooser.cleanup();
        buttonGroup1.clearSelection();
        typecombo.setSelectedItem("Select");
        note.setText("");
        jLabel3.setText("");

    }

    private void loadCombobox() {

        DefaultComboBoxModel doctor = (DefaultComboBoxModel) doctorcombo.getModel();
        doctor.removeAllElements();

        Vector v = new Vector();
        v.add("Select Doctor");
        v.add("kavindu");
        v.add("nimal");
        v.add("sanath");

        doctor.addAll(v);
        doctorcombo.setSelectedIndex(0);

        DefaultComboBoxModel spe = (DefaultComboBoxModel) specombo.getModel();
        spe.removeAllElements();

        Vector v1 = new Vector();
        v1.add("Any");
        v1.add("Cardiology");
        v1.add("Neurology");
        v1.add("Orthopedics");
        v1.add("General Practice");

        spe.addAll(v1);
        specombo.setSelectedIndex(0);

        DefaultComboBoxModel branch = (DefaultComboBoxModel) branchcombo.getModel();
        branch.removeAllElements();

        Vector v3 = new Vector();
        v3.add("Select");
        v3.add("Colombo");
        v3.add("Kurunegala");
        v3.add("Kandy");
        v3.add("Jaffna");

        branch.addAll(v3);
        branchcombo.setSelectedIndex(0);

        DefaultComboBoxModel type = (DefaultComboBoxModel) typecombo.getModel();
        type.removeAllElements();

        Vector v4 = new Vector();
        v4.add("Select");
        v4.add("consultation");
        v4.add("surgery");
        v4.add("diagnostic");
        v4.add("follow up");

        type.addAll(v4);
        typecombo.setSelectedIndex(0);

    }

    public void setMediator(AppointmentMediator mediator) {
        this.mediator = mediator;
        System.out.println("book eke mediator set");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker2 = new com.raven.swing.TimePicker();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        patientf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        doctorcombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        specombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        branchcombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        typecombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        note = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Book New Appoinment");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Patient");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Doctor");

        doctorcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText(" Specialization");

        specombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Facility");

        branchcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Date");

        datechooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datechooserMouseClicked(evt);
            }
        });
        datechooser.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                datechooserInputMethodTextChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Available Times");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText(" Appointment Type");

        typecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText(" Notes (Optional)");

        note.setColumns(20);
        note.setRows(5);
        jScrollPane1.setViewportView(note);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setText("Book Appoinment");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("3.15 PM");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("3.45 PM");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setText("4.15 PM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 173, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typecombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datechooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(patientf, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(doctorcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel9)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(branchcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(specombo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(39, 39, 39)
                                .addComponent(jCheckBox2))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox3))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(specombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(branchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doctorcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String nic = patientf.getText();

        String doctor = doctorcombo.getSelectedItem().toString();
        String patientName = jLabel3.getText();

        Date d = datechooser.getDate();

        String date = "";
        if (d == null) {
            JOptionPane.showMessageDialog(this, "Please select a date", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.format(d);
        }

        String type = typecombo.getSelectedItem().toString();
        String spe = specombo.getSelectedItem().toString();
        String branch = branchcombo.getSelectedItem().toString();
        String time = "";

        if (jCheckBox1.isSelected()) {

            time = jCheckBox1.getText();
        } else if (jCheckBox2.isSelected()) {

            time = jCheckBox2.getText();
        } else if (jCheckBox3.isSelected()) {

            time = jCheckBox3.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Please Select Time", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        String note = this.note.getText();

        if (nic.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please enter patient", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (doctor.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Plese select doctor", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (type.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please select type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (spe.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please select specification", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (branch.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please enter branch", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (note.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please Enter Note", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            if (mediator == null) {
                System.out.println("null mediator ");
            } else {
                AppoinmentModel appoinment = new AppoinmentModel(date, "Scheduled", note, nic, doctor, type, branch, "view", time, spe);
                mediator.bookAppointment(appoinment);
                reset();

                try {
                    ResultSet rs = MySQL.execute("SELECT * FROM `appointments` WHERE `patients_nic`='" + nic + "' AND `time`='" + time + "'");

                    if (rs.next()) {

                        String appointmentId = String.valueOf(rs.getInt("appointment_id"));

                        Map<String, Object> params = new HashMap<>();
                        params.put("Parameter1", patientName);
                        params.put("Parameter2", nic);
                        params.put("Parameter3", mobile);
                        params.put("Parameter4", gender);
                        params.put("Parameter5", appointmentId);
                        params.put("Parameter6", doctor);
                        params.put("Parameter7", type);
                        params.put("Parameter8", branch);
                        params.put("Parameter9", date);
                        params.put("Parameter10", time);
                        params.put("Parameter11", spe);

                        System.out.println(patientName);
                        System.out.println(nic);
                        System.out.println(mobile);
                        System.out.println(gender);
                        System.out.println(appointmentId);
                        System.out.println(doctor);
                        System.out.println(type);
                        System.out.println(branch);
                        System.out.println(date);
                        System.out.println(time);
                        System.out.println(spe);

                        String path = "src/reports/receipt.jasper";
                        JasperPrint jasperPrint = JasperFillManager.fillReport(path, params, new JREmptyDataSource());
                        JasperViewer.viewReport(jasperPrint, false);

                    }

                } catch (Exception ex) {
                    Logger.getLogger(BookNewAppoinmentPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nic = patientf.getText();

        if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Patient", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {

                ResultSet rs = MySQL.execute("SELECT * FROM `patients` WHERE `nic`='" + nic + "'");

                if (rs.next()) {
                    String name = rs.getString("first_name");

                    jLabel3.setText(name);

                    mobile = rs.getString("phone");
                    gender = rs.getString("gender");

                }
            } catch (SQLException ex) {
                Logger.getLogger(BookNewAppoinmentPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(BookNewAppoinmentPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void datechooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datechooserMouseClicked
        Date selectedDate = datechooser.getDate();

        if (selectedDate != null) {
            System.out.println("Selected Date: " + selectedDate);
        } else {
            System.out.println("No date selected!");
        }
    }//GEN-LAST:event_datechooserMouseClicked

    private void datechooserInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_datechooserInputMethodTextChanged
        Date selectedDate = datechooser.getDate();


    }//GEN-LAST:event_datechooserInputMethodTextChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> branchcombo;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JComboBox<String> doctorcombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextArea note;
    private javax.swing.JTextField patientf;
    private javax.swing.JComboBox<String> specombo;
    private com.raven.swing.TimePicker timePicker2;
    private javax.swing.JComboBox<String> typecombo;
    // End of variables declaration//GEN-END:variables
}
