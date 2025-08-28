
package model;

import patterns.ReportVisitor;


public class Financial {
     private String patientName;
    
    private int appointmentId;
    private String serviceType;
    private double amount;
    
    private String patientMobile;
    private String patientDob;

    public Financial(String patientName, int appointmentId, String serviceType, double amount,String patientMobile,String patientDob) {
        this.patientName = patientName;
        this.appointmentId = appointmentId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.patientMobile =patientMobile;
        this.patientDob = patientDob;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getAmount() {
        return amount;
    }

    public void accept(ReportVisitor visitor) {
        visitor.visit(this);
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public String getPatientDob() {
        return patientDob;
    }
    
    
    
}
