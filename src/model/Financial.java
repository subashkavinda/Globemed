
package model;

import patterns.ReportVisitor;


public class Financial {
     private String patientName;
    private String appointmentId;
    private String serviceType;
    private double amount;

    public Financial(String patientName, String appointmentId, String serviceType, double amount) {
        this.patientName = patientName;
        this.appointmentId = appointmentId;
        this.serviceType = serviceType;
        this.amount = amount;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getAppointmentId() {
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
}
