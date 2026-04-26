package employees;

import enums.Language;
import java.util.List;
import java.util.ArrayList;
import communication.*; // imported communication

public class TechSupportSpecialist extends Employee {

    public TechSupportSpecialist(int id, String username, String password, String name, String email, Language language, String employeeId, double salary) {
        super(id, username, password, name, email, language, employeeId, salary);
    }

    public List<Request> viewRequests() {
        System.out.println("viewRequests called");
        return new ArrayList<>();
    }

    public void acceptRequest(Request r) {
        System.out.println("acceptRequest called");
    }

    public void rejectRequest(Request r) {
        System.out.println("rejectRequest called");
    }

    public void markDone(Request r) {
        System.out.println("markDone called");
    }

    @Override
    public String toString() {
        return "TechSupportSpecialist{" + super.toString() + "}";
    }
}