package employees;
import enums.Language;
import users.*;

public class Employee extends User {

    private String employeeId;
    private double salary;

    public Employee(int id, String username, String password, String name, String email, Language language, String employeeId, double salary) {
        super(id, username, password, name, email, language);
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public void sendMessage(User receiver, String text) {
        System.out.println("sendMessage called");
    }

    public String getEmployeeId() { return employeeId; }
    public double getSalary() { return salary; }

    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Employee{employeeId='" + employeeId + "', salary=" + salary + ", " + super.toString() + "}";
    }
}