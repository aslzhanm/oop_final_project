package users;

import java.util.ArrayList;
import academic.*;
import employees.*;
import enums.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== University System Demo ===");

        Course course = new Course(
                "OOP",
                CourseType.MAJOR,
                "CS101",
                3
        );

        Student student = new Student();

        Teacher teacher = new Teacher(
                1,
                "teacher1",
                "1234",
                "John Doe",
                "john@uni.kz",
                Language.EN,
                "EMP001",
                500000,
                TeacherPosition.PROFESSOR
        );

        System.out.println("\n--- Actions ---");

        student.registerForCourse(course);
        teacher.addLesson(course, new Lesson());

        System.out.println("\n--- Objects ---");
        System.out.println(course);
        System.out.println(student);
        System.out.println(teacher);

        System.out.println("\n=== Demo Finished ===");
    }
}