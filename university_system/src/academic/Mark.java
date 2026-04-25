package academic;

public class Mark {

    private String studentId;
    private int score;

    public Mark() {}

    public Mark(String studentId, int score) {
        this.studentId = studentId;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Mark{studentId='" + studentId + "', score=" + score + "}";
    }
}