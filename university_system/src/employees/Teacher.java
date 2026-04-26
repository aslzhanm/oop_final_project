package employees;

import enums.Language;
import enums.TeacherPosition;
import enums.UrgencyLevel;
import java.util.List;
import java.util.ArrayList;
import academic.*; // imported academic, users
import users.*;

public class Teacher extends Employee {
	
    private TeacherPosition position;
    private List<Course> courses;

    public Teacher(int id, String username, String password, String name, String email, Language language, String employeeId, double salary, TeacherPosition position) {
        super(id, username, password, name, email, language, employeeId, salary);
        this.position = position;
        this.courses = new ArrayList<>();
    }

    public void putMark(Student student, Course course, Mark mark) {
        System.out.println("putMark called");
    }

    public void addLesson(Course course, Lesson lesson) {
        System.out.println("addLesson called");
    }

    public void updateCourse(Course course) {
        System.out.println("updateCourse called");
    }

    public void sendComplaint(Student student, UrgencyLevel urgency, String text) {
        System.out.println("sendComplaint called");
    }

    public TeacherPosition getPosition() { return position; }
    public List<Course> getCourses() { return courses; }

    public void setPosition(TeacherPosition position) { this.position = position; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    @Override
    public String toString() {
        return "Teacher{position=" + position + ", coursesCount=" + courses.size() + ", " + super.toString() + "}";
    }
}