package academic;

import enums.CourseType;
import java.util.*;

public class Course {

    private String title;
    private CourseType type;
//    added course id, credits, lessons
    private String courseId;
    private int credits;
    private List<Lesson> lessons;

    public Course() {}

    public Course(String name, CourseType type, String ci, int cr) {
        this.title = name;
        this.type = type;
        this.courseId = ci;
        this.credits = cr;
        this.lessons = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }
    
    
//    added only this because used in student class
    public int getCredits() {
    	return credits;
    }

    @Override
    public String toString() {
        return "Course{title='" + title + "', type=" + type + "}";
    }

	
}