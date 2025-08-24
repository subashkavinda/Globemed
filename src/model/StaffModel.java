
package model;


public class StaffModel {
    
    private String first_name;
    private String last_name;
    private String role;
    private String department;
    private String email;
    private String phone;
    private String created_at;
    private String upadted_at;
    private String password;
    
    
    public StaffModel(String firstname,String lastname,String role,String depertment,String email,String phone,String createdat,String updatedat,String password){
        this.first_name = firstname;
        this.last_name = lastname;
        this.role = role;
        this.department = depertment;
        this.email = email;
        this.phone = phone;
        this.created_at = createdat;
        this.upadted_at = updatedat;
        this.password = password;
        
    }
    
    

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpadted_at() {
        return upadted_at;
    }

    public void setUpadted_at(String upadted_at) {
        this.upadted_at = upadted_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
