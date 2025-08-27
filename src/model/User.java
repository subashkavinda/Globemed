
package model;

import patterns.RoleComponent;


public class User {
    
    
      private String username;
    private RoleComponent role; 
    
    private String lastname;
    private String nic;
    private String mobile;
    private String password;
 

    public User(String username, RoleComponent role,String lastname,String nic, String mobile, String password) {
        this.username = username;
        this.role = role;
        this.lastname = lastname;
        this.nic = nic;
        this.mobile = mobile;
        this.password = password;
       
    }
    
    

    public String getUsername() {
        return username;
    }

    public boolean canAccess(String permission) {
        return role.hasPermission(permission);
    }

    public String getRoleName() {
        return role.getRoleName();
    }

    public String getLastname() {
        return lastname;
    }

    public String getNic() {
        return nic;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

 
}
