package academic;

import enums.CourseType;

public class Course {

    private String name;
    private CourseType type;

    public Course() {}

    public Course(String name, CourseType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Course{name='" + name + "', type=" + type + "}";
    }
}