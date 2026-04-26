package academic;

public class Mark {

//    private String studentId;
//    private int score;
//	added all fields
	private double firstAttestation;
	private double secondAttestation;
	private double finalExam;

	

    public Mark() {}

    public Mark(double f, double s, double fin) {
        this.finalExam = fin;
        this.firstAttestation = f;
        this.secondAttestation = s;
    }
    
    public double getTotal() {
    	return 100;
    }

//    public String getStudentId() {
//        return studentId;
//    }

//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }

//    public int getScore() {
//        return score;
//    }

//    public void setScore(int score) {
//        this.score = score;
//    }

//    @Override
//    public String toString() {
//        return "Mark{studentId='" + studentId + "', score=" + score + "}";
//    }
}