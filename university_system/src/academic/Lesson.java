package academic;

import enums.LessonType;

public class Lesson {

    private String title;
    private LessonType type;

    public Lesson() {}

    public Lesson(String title, LessonType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Lesson{title='" + title + "', type=" + type + "}";
    }
}