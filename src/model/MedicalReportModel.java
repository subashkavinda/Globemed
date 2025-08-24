
package model;


public class MedicalReportModel {
    private String diagnosis;
    private String treatmentPlan;
    private String allergies;
    private String medications;
    private String createdAt;
    private String updatedAt;
    private String patientId;
    private int id;
    
    
    
    public MedicalReportModel(String diagnosis,String treatmentPlan, String allergies,String medications,String createdAt,String updatedAt,String patientID,int id){
        this.diagnosis = diagnosis;
        this.treatmentPlan = treatmentPlan;
        this.allergies = allergies;
        this.medications = medications;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.patientId = patientID;
        this.id = id;
    }
    
    
    

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
