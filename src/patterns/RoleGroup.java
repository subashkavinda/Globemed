
package patterns;

import java.util.ArrayList;
import java.util.List;


public class RoleGroup implements RoleComponent{
     private String name;
    private List<RoleComponent> roles;
    
    public RoleGroup(String name) {
        this.name = name;
        this.roles = new ArrayList<>();
    }
    
    public void addRole(RoleComponent role) {
        roles.add(role);
    }
    
    @Override
    public boolean hasPermission(String permission) {
        return roles.stream().anyMatch(role -> role.hasPermission(permission));
    }
    
    @Override
    public String getRoleName() {
        return name + " (Combined Role)";
    }
}
