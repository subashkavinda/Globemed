package patterns;

import java.util.HashSet;
import java.util.Set;

public class Role implements RoleComponent {

    private String name;
    private Set<String> permissions;

    public Role(String name) {
        this.name = name;
        this.permissions = new HashSet<>();

        if (name.equalsIgnoreCase("Doctor")) {
            permissions.add("view_patient");
            permissions.add("write_prescription");
        } else if (name.equalsIgnoreCase("Nurse")) {
            permissions.add("view_patient");
            permissions.add("update_vitals");
        } else if (name.equalsIgnoreCase("Admin")) {
            permissions.add("manage_users");
            permissions.add("view_reports");
        }
    }

    public void addPermission(String permission) {
        permissions.add(permission);
    }

    @Override
    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }

    @Override
    public String getRoleName() {
        return name;
    }

}
