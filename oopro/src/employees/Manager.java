package employees;

import enums.Language;

public class Manager extends Employee {

    public Manager(int id, String username, String password, String name, String email, Language language, String employeeId, double salary) {
        super(id, username, password, name, email, language, employeeId, salary);
    }

    public void assignCourse(Teacher teacher, Course course) {
        System.out.println("assignCourse called");
    }

    public void approveRegistration(Student student, Course course) {
        System.out.println("approveRegistration called");
    }

    public void addCourseForRegistration(Course course) {
        System.out.println("addCourseForRegistration called");
    }

    public Student viewStudentInfo(Student student) {
        System.out.println("viewStudentInfo called");
        return student;
    }

    public void generateReport() {
        System.out.println("generateReport called");
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() + "}";
    }
}