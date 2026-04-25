package academic;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private String studentId;
    private List<Mark> marks = new ArrayList<>();

    public Transcript() {}

    public Transcript(String studentId) {
        this.studentId = studentId;
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Transcript{studentId='" + studentId + "', marks=" + marks + "}";
    }
}