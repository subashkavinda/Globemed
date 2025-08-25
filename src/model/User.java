
package model;

import patterns.RoleComponent;


public class User {
    
    
      private String username;
    private RoleComponent role; 

    public User(String username, RoleComponent role) {
        this.username = username;
        this.role = role;
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
}
