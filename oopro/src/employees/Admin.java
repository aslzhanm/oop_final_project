package employees;

import enums.Language;

public class Admin extends Employee {

    public Admin(int id, String username, String password, String name, String email, Language language, String employeeId, double salary) {
        super(id, username, password, name, email, language, employeeId, salary);
    }

    public void addUser(User user) {
        System.out.println("addUser called");
    }

    public void removeUser(User user) {
        System.out.println("removeUser called");
    }

    public void updateUser(User user) {
        System.out.println("updateUser called");
    }

    public void viewLogs() {
        System.out.println("viewLogs called");
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() + "}";
    }
}
