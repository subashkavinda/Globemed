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
            permissions.add("Update Medical Report");
            permissions.add("View Today Appointment");
            permissions.add("Add New Medical Report");
            permissions.add("Enter medical Details");
            
        } else if (name.equalsIgnoreCase("Nurse")) {
            permissions.add("view_patient");
            permissions.add("update_vitals");
            permissions.add("Appointment Scheduling an manage");
            permissions.add("Enter Patient Details");
            permissions.add("Add Patient");
            permissions.add("Update Patient");
        } else if (name.equalsIgnoreCase("Admin")) {
            permissions.add("manage_users");
            permissions.add("view_reports");
            permissions.add("Genarate Report");
            permissions.add("Manage Staff");
            permissions.add("Appointment Scheduling an manage");
            permissions.add("Billing & Payments");
            permissions.add("Enter Patient Details");
            permissions.add("View Doctors Appointments");
             permissions.add("Enter Patient Details");
               permissions.add("Add Patient");
                permissions.add("Update Patient");
        } else if (name.equalsIgnoreCase("Pharmacist")) {
            permissions.add("view_patient");
            permissions.add("Billing & Payments");
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
