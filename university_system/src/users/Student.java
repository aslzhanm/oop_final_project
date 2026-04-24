package users;

import academic.Course;
import academic.Mark;
import employees.Teacher;
import enums.Language;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String studentId;
    private int yearOfStudy;
    private int totalCredits;
    private int failedCoursesCount;
    private List<Course> registeredCourses;

    public Student() {
        this.registeredCourses = new ArrayList<>();
    }

    public Student(int id, String username, String password, String name, String email, Language language,
                   String studentId, int yearOfStudy, int totalCredits, int failedCoursesCount) {
        super(id, username, password, name, email, language);
        this.studentId = studentId;
        this.yearOfStudy = yearOfStudy;
        this.totalCredits = totalCredits;
        this.failedCoursesCount = failedCoursesCount;
        this.registeredCourses = new ArrayList<>();
    }

    public List<Course> viewCourses() {
        System.out.println("viewCourses called");
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        System.out.println("registerForCourse called");

        if (checkCreditLimit(course) && checkFailedCoursesLimit()) {
            registeredCourses.add(course);
            totalCredits += course.getCredits();
            System.out.println("Course registered successfully");
        } else {
            System.out.println("Cannot register for course");
        }
    }

    public boolean checkCreditLimit(Course course) {
        System.out.println("checkCreditLimit called");
        return totalCredits + course.getCredits() <= 21;
    }

    public boolean checkFailedCoursesLimit() {
        System.out.println("checkFailedCoursesLimit called");
        return failedCoursesCount <= 3;
    }

    public List<Teacher> viewTeacherInfo(Course course) {
        System.out.println("viewTeacherInfo called");
        return new ArrayList<>();
    }

    public List<Mark> viewMarks() {
        System.out.println("viewMarks called");
        return new ArrayList<>();
    }

    public List<Mark> viewTranscript() {
        System.out.println("viewTranscript called");
        return new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public int getFailedCoursesCount() {
        return failedCoursesCount;
    }

    public void setFailedCoursesCount(int failedCoursesCount) {
        this.failedCoursesCount = failedCoursesCount;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", totalCredits=" + totalCredits +
                ", failedCoursesCount=" + failedCoursesCount +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}