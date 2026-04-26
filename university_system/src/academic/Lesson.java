package academic;

import enums.LessonType;
import java.util.*;

public class Lesson {

    private String topic; // corrected to topic
    private LessonType type;
    // added lesson id, date
    private String lessonId;
    private Date date;

    public Lesson() {}

    public Lesson(String title, LessonType type, String li, Date d) {
        this.topic = title;
        this.type = type;
        this.date = d;
        this.lessonId = li;
    }

    public String getTitle() {
        return topic;
    }

    public void setTitle(String title) {
        this.topic = title;
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Lesson{title='" + topic + "', type=" + type + "}";
    }
}