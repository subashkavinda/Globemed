
package model;


public class AppoinmentModel {
    
    
    private int id;
    private String date;
    private String status;
    private String notes;
    private int pid;
    private String doctor;
    private String type;
    private String branch;
    private String action;
    private String time;
    private String spe;
    
    
    public AppoinmentModel(String date,String status, String note,int pid,String doctor,String type,String branch,String action,String time,String spe){
       this.date = date;
       this.status = status;
       this.notes = note;
       this.pid = pid;
       this.doctor = doctor;
       this.type = type;
       this.branch = branch;
       this.action = action;
       this.time = time;
       this.spe = spe;
    }
    


    public int getId() {
        return id;
    }

  

    public String getDate() {
        return date;
    }


    public String getStatus() {
        return status;
    }

  

    public String getNotes() {
        return notes;
    }

   

    public int getPid() {
        return pid;
    }



    public String getDoctor() {
        return doctor;
    }

  

    public String getType() {
        return type;
    }

 

    public String getBranch() {
        return branch;
    }



    public String getAction() {
        return action;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpe() {
        return spe;
    }

    public void setSpe(String spe) {
        this.spe = spe;
    }

    
    
    
    
}
