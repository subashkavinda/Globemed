
package model;

import patterns.ReportVisitor;


public class Financial {
     private String patientName;
    
    private int appointmentId;
    private String serviceType;
    private double amount;
    
    private String patientMobile;
    private String patientDob;
    
    private String insuranceCompany;
    private String policyNumber;
    private String HolderName;
    private boolean claimInsurance;

    public Financial(String patientName, int appointmentId, String serviceType, double amount,String patientMobile,String patientDob,boolean claimInsurance) {
        this.patientName = patientName;
        this.appointmentId = appointmentId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.patientMobile =patientMobile;
        this.patientDob = patientDob;
        this.claimInsurance =claimInsurance;
    }
    
    
    
     public Financial(String patientName, int appointmentId, String serviceType, double amount,String patientMobile,String patientDob,String insurenceCompany,String policyNumber,String HolderName,boolean claimInsurance) {
        this.patientName = patientName;
        this.appointmentId = appointmentId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.patientMobile =patientMobile;
        this.patientDob = patientDob;
        this.insuranceCompany =insurenceCompany;
        this.policyNumber = policyNumber;
        this.HolderName = HolderName;
         this.claimInsurance =claimInsurance;
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

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getHolderName() {
        return HolderName;
    }

    public void setHolderName(String HolderName) {
        this.HolderName = HolderName;
    }

    public boolean isClaimInsurance() {
        return claimInsurance;
    }

    public void setClaimInsurance(boolean claimInsurance) {
        this.claimInsurance = claimInsurance;
    }
    
    
    
}
