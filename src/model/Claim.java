package model;

public class Claim {

//    private String id;
    private String patientNic;
    private String serviceType;
    private Double amount;
    private String status;

    public Claim( String patientNic, String serviceType, double amount) {
//        this.id = id;
        this.patientNic = patientNic;
        this.serviceType = serviceType;
        this.amount = amount;
        this.status = "SUBMITTED";
    }


//    public String getId() {
//        return id;
//    }

    public String getPatientNic() {
        return patientNic;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
