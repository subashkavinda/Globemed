
package model;


public class PatientModel {
    
    private String firstName;
    private String lastName;
    private String dob;
    private String mobile;
    private String nic;
    private String address;
    private String gender;
   
    
    public PatientModel(String firstName,String lastName,String dob,String mobile,String nic,String address,String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.mobile = mobile;
        this.nic = nic;
        this.address = address;
        this.gender = gender;
    
    }
    
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

 
    
    
    
}
