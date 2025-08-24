
package gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.AppoinmentModel;
import model.MySQL;


public interface AppointmentMediator {
       void bookAppointment(AppoinmentModel appoinment);
    void cancelAppointment(int appointmentId);
    void refreshDashboard();
    void showMessage(String message);
    void clearBookingForm();
    void updateAppointment(AppoinmentModel appoitment,int id);
}


class AppointmentScheduler implements AppointmentMediator {
    private AppoinementDashBoardPanel dashboardPanel;
    private BookNewAppoinmentPanel bookingPanel;
    private ManageAppoinment managePanel;
    
    public AppointmentScheduler(AppoinementDashBoardPanel dashboard, 
                               BookNewAppoinmentPanel booking, 
                               ManageAppoinment manage) {
        this.dashboardPanel = dashboard;
        this.bookingPanel = booking;
        this.managePanel = manage;
    }

    @Override
    public void bookAppointment(AppoinmentModel appoinment) {
        // Validate input
//        if (patient.trim().isEmpty() || time.trim().isEmpty()) {
//            showMessage("❌ Please fill in patient name and time!");
//            return;
//        }

            System.out.println("book appointment method call");

             String date = appoinment.getDate();
             String status = appoinment.getStatus();
             String note = appoinment.getNotes();
             int pid = appoinment.getPid();
             String doctor = appoinment.getDoctor();
             String type = appoinment.getType();
             String branch = appoinment.getBranch();
             String action = appoinment.getAction();
             String time = appoinment.getTime();
             String spe = appoinment.getSpe();
             
             
             System.out.println(date);
             System.out.println(status);
             System.out.println(note);
             System.out.println(pid);
             System.out.println(doctor);
             System.out.println(type);
             System.out.println(branch);
             System.out.println(action);
      
        
        try {
           MySQL.execute("INSERT INTO `appointments` (`appointment_date`,`status`,`notes`,`patients_nic`,`doctor`,`type`,`branch`,`action`,`time`,`specialization`) VALUES ('"+date+"','"+status+"','"+note+"','"+pid+"','"+doctor+"','"+type+"','"+branch+"','"+action+"','"+time+"','"+spe+"') ");
            
            System.out.println("Book Appointment Succesfull");
        } catch (Exception e) {
            showMessage("⚠️ Error: " + e.getMessage());
        }
    }

    @Override
    public void cancelAppointment(int appointmentId) {
        try {
            
            System.out.println(appointmentId);
            System.out.println("awa");
            MySQL.execute("DELETE FROM `appointments` WHERE `appointment_id`='"+appointmentId+"'");
            System.out.println("delete appoitment");
        } catch (Exception e) {
            showMessage("️ Error: " + e.getMessage());
        }
    }

    @Override
    public void refreshDashboard() {
        

        
        if (dashboardPanel != null) {
            dashboardPanel.loadAppointments();
        }
    }

    @Override
    public void showMessage(String message) {
        if (managePanel != null) {
//            managePanel.showMessage(message);
        }
    }

    @Override
    public void clearBookingForm() {
        if (bookingPanel != null) {
//            bookingPanel.clearForm();
        }
    }

    @Override
    public void updateAppointment(AppoinmentModel appoitment,int id) {
        
        try {
            MySQL.execute("UPDATE `appointments` SET `appointment_date`='"+appoitment.getDate()+"', `status`='"+appoitment.getStatus()+"',`notes`='"+appoitment.getNotes()+"',`doctor`='"+appoitment.getDoctor()+"',`type`='"+appoitment.getType()+"',`branch`='"+appoitment.getBranch()+"',`action`='"+appoitment.getAction()+"',`patients_nic`='"+appoitment.getPid()+"',`specialization`='"+appoitment.getSpe()+"',`time`='"+appoitment.getTime()+"' WHERE `appointment_id`='"+id+"'");
            System.out.println("updated appointment");
        } catch (Exception ex) {
            Logger.getLogger(AppointmentScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
