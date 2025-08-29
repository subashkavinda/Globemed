package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import model.AppContext;
import model.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MedicalReportModel;
import model.MySQL;

public class DoctorAppointment extends javax.swing.JPanel {

    private JScrollPane scrollPane;

    public DoctorAppointment() {
        initComponents();
        scrollPane = new JScrollPane(jPanel1);
        loadAppointment();
    }

    void loadAppointment() {
        jPanel1.removeAll();
        User currentUser = AppContext.getInstance().getCurrentUser();

        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `appointments` WHERE `doctor`='" + currentUser.getUsername() + "' AND `status`='" + "Scheduled" + "' ORDER BY `time`");

            jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));

            while (rs.next()) {

                List<MedicalReportModel> reports = new ArrayList<>();

                SingleDoctorAppointment panel = new SingleDoctorAppointment();

                ResultSet rs1 = MySQL.execute("SELECT * FROM `patients` WHERE `nic`='" + rs.getString("patients_nic") + "'");

                if (rs1.next()) {
                    panel.set(rs.getString("patients_nic"), rs1.getString("phone"), rs1.getString("gender"), rs.getInt("appointment_id"), this,rs.getString("time"));
                }

                ResultSet rs2 = MySQL.execute("SELECT * FROM `medical records` WHERE `patients_nic`='" + rs.getString("patients_nic") + "'");

                while (rs2.next()) {
                    MedicalReportModel report = new MedicalReportModel(
                            rs2.getString("diagnosis"),
                            rs2.getString("treatment_plan"),
                            rs2.getString("allergies"),
                            rs2.getString("medications"),
                            rs2.getString("created_at"),
                            rs2.getString("updated_at"),
                            rs2.getString("patients_nic"),
                            rs2.getInt("record_id")
                    );

                    reports.add(report);
                }

                panel.setMedicalData(rs.getString("patients_nic"), reports, rs.getString("patients_nic"));

                jPanel1.add(panel);
                jPanel1.add(Box.createVerticalStrut(10));

            }

            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            scrollPane.setPreferredSize(new Dimension(800, 500));

            setLayout(new FlowLayout());
            add(scrollPane);

            jPanel1.revalidate();
            jPanel1.repaint();

        } catch (Exception ex) {
            Logger.getLogger(DoctorAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Doctor Appointments.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(322, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
