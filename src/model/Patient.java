
package model;

import patterns.ReportVisitor;


public class Patient {
    
    private String name;
    private String diagnosis;
    private String treatmentPlan;

    public Patient(String name, String diagnosis, String treatmentPlan) {
        this.name = name;
        this.diagnosis = diagnosis;
        this.treatmentPlan = treatmentPlan;
    }

    public String getName() {
        return name;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void accept(ReportVisitor visitor) {
        visitor.visit(this);
    }
    
}
