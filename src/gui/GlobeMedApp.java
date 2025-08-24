/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author subash kavinda
 */

    
    
    import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobeMedApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private JLabel dateTimeLabel;

    public GlobeMedApp() {
        setTitle("GlobeMed - Appointment Scheduling System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(41, 128, 185));
        header.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel logo = new JLabel("G", SwingConstants.CENTER);
        logo.setPreferredSize(new Dimension(60, 60));
        logo.setOpaque(true);
        logo.setBackground(Color.WHITE);
        logo.setForeground(new Color(41, 128, 185));
        logo.setFont(new Font("Arial", Font.BOLD, 30));
        logo.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2));

        JPanel titleInfo = new JPanel(new GridLayout(2,1));
        titleInfo.setOpaque(false);
        JLabel title = new JLabel("GlobeMed", JLabel.LEFT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        JLabel subtitle = new JLabel("Multi-Location Healthcare Scheduling System", JLabel.LEFT);
        subtitle.setForeground(Color.WHITE);

        titleInfo.add(title);
        titleInfo.add(subtitle);

        JPanel leftHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftHeader.setOpaque(false);
        leftHeader.add(logo);
        leftHeader.add(titleInfo);

        JPanel rightHeader = new JPanel(new GridLayout(2,1));
        rightHeader.setOpaque(false);
        dateTimeLabel = new JLabel("", JLabel.RIGHT);
        dateTimeLabel.setForeground(Color.WHITE);
        JLabel status = new JLabel("🟢 All Systems Operational", JLabel.RIGHT);
        status.setForeground(Color.WHITE);
        rightHeader.add(dateTimeLabel);
        rightHeader.add(status);

        header.add(leftHeader, BorderLayout.WEST);
        header.add(rightHeader, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        // Menu bar
        JPanel menuBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuBar.setBackground(new Color(52,73,94));

        JButton btnDashboard = createMenuButton("📊 Dashboard", "dashboard");
        JButton btnBooking   = createMenuButton("📅 Book Appointment", "booking");
        JButton btnManage    = createMenuButton("🔧 Manage", "manage");
        JButton btnReports   = createMenuButton("📈 Reports", "reports");
        JButton btnSettings  = createMenuButton("⚙️ Settings", "settings");

        menuBar.add(btnDashboard);
        menuBar.add(btnBooking);
        menuBar.add(btnManage);
        menuBar.add(btnReports);
        menuBar.add(btnSettings);

        add(menuBar, BorderLayout.SOUTH);

        // Content with CardLayout
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(createDashboardPanel(), "dashboard");
        contentPanel.add(createBookingPanel(), "booking");
        contentPanel.add(createManagePanel(), "manage");
        contentPanel.add(createReportsPanel(), "reports");
        contentPanel.add(createSettingsPanel(), "settings");

        add(contentPanel, BorderLayout.CENTER);

        // Update time
        Timer timer = new Timer(1000, e -> updateDateTime());
        timer.start();
        updateDateTime();

        setVisible(true);
    }

    private JButton createMenuButton(String text, String cardName) {
        JButton btn = new JButton(text);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(52,73,94));
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.addActionListener(e -> cardLayout.show(contentPanel, cardName));
        return btn;
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20,20,20,20));

        // Stats
        JPanel stats = new JPanel(new GridLayout(1,4,15,15));
        stats.add(makeStatCard("📅", "24", "Total Appointments", new Color(39,174,96)));
        stats.add(makeStatCard("✅", "18", "Scheduled", new Color(52,152,219)));
        stats.add(makeStatCard("❌", "3", "Cancelled", new Color(231,76,60)));
        stats.add(makeStatCard("🕐", "12", "Available Slots", new Color(243,156,18)));

        panel.add(stats, BorderLayout.NORTH);

        // Table
        String[] cols = {"ID", "Patient", "Doctor", "Facility", "Date/Time", "Type", "Status"};
        Object[][] data = {
                {"APT001","John Doe","Dr. Smith","Central","2024-12-01 10:00","Consultation","Scheduled"},
                {"APT002","Jane Smith","Dr. Johnson","West","2024-12-01 14:30","Follow-up","Completed"},
                {"APT003","Bob Johnson","Dr. Brown","East","2024-12-01 16:00","Surgery","Cancelled"},
                {"APT004","Alice Wilson","Dr. Davis","Central","2024-12-02 09:30","Diagnostic","Scheduled"}
        };
        JTable table = new JTable(new DefaultTableModel(data, cols));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createTitledBorder("Recent Appointments"));

        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }

    private JPanel makeStatCard(String icon, String value, String label, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(color, 3));
        JLabel iconLbl = new JLabel(icon, JLabel.CENTER);
        iconLbl.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        JLabel valLbl = new JLabel(value, JLabel.CENTER);
        valLbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        valLbl.setForeground(color);
        JLabel labelLbl = new JLabel(label, JLabel.CENTER);
        card.add(iconLbl, BorderLayout.NORTH);
        card.add(valLbl, BorderLayout.CENTER);
        card.add(labelLbl, BorderLayout.SOUTH);
        return card;
    }

    private JPanel createBookingPanel() {
        JPanel panel = new JPanel(new GridLayout(0,2,15,15));
        panel.setBorder(new EmptyBorder(20,20,20,20));

        panel.add(new JLabel("👤 Patient:"));
        panel.add(new JComboBox<>(new String[]{"Select","John Doe","Jane Smith","Bob Johnson"}));

        panel.add(new JLabel("🏥 Specialization:"));
        panel.add(new JComboBox<>(new String[]{"Any","Cardiology","Neurology"}));

        panel.add(new JLabel("👨‍⚕️ Doctor:"));
        panel.add(new JComboBox<>(new String[]{"Select Doctor","Dr. Smith","Dr. Johnson"}));

        panel.add(new JLabel("🏢 Facility:"));
        panel.add(new JComboBox<>(new String[]{"Central - NY","West - LA","East - Boston"}));

        panel.add(new JLabel("📅 Date:"));
        panel.add(new JTextField("2024-12-01"));

        panel.add(new JLabel("🕐 Time:"));
        panel.add(new JTextField("10:00"));

        panel.add(new JLabel("📋 Type:"));
        panel.add(new JComboBox<>(new String[]{"Consultation","Follow-up","Surgery"}));

        panel.add(new JLabel("📝 Notes:"));
        panel.add(new JTextArea(3,20));

        JButton bookBtn = new JButton("📅 Book Appointment");
        bookBtn.setBackground(new Color(39,174,96));
        bookBtn.setForeground(Color.WHITE);

        JPanel btnPanel = new JPanel();
        btnPanel.add(bookBtn);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(panel, BorderLayout.CENTER);
        wrapper.add(btnPanel, BorderLayout.SOUTH);

        return wrapper;
    }

    private JPanel createManagePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20,20,20,20));

        JComboBox<String> combo = new JComboBox<>(new String[]{
                "Choose appointment","APT001 - John Doe","APT004 - Alice Wilson"
        });

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("🔍 Select Appointment:"));
        top.add(combo);

        JPanel actions = new JPanel(new GridLayout(1,3,20,20));

        JButton cancel = new JButton("❌ Cancel");
        cancel.setBackground(new Color(231,76,60));
        cancel.setForeground(Color.WHITE);

        JButton reschedule = new JButton("📅 Reschedule");
        reschedule.setBackground(new Color(243,156,18));
        reschedule.setForeground(Color.WHITE);

        JButton view = new JButton("ℹ️ View Details");
        view.setBackground(new Color(52,152,219));
        view.setForeground(Color.WHITE);

        actions.add(cancel);
        actions.add(reschedule);
        actions.add(view);

        panel.add(top, BorderLayout.NORTH);
        panel.add(actions, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createReportsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel("📊 Reports & Analytics (Coming Soon)", JLabel.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panel.add(lbl, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createSettingsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel("⚙️ System Settings (Configure preferences)", JLabel.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panel.add(lbl, BorderLayout.CENTER);
        return panel;
    }

    private void updateDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM d, yyyy - HH:mm:ss");
        dateTimeLabel.setText(sdf.format(new Date()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GlobeMedApp::new);
    }
}


    /**
     * Creates new form GlobeMedApp
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
