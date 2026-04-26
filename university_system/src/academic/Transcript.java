package academic;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

	
    private List<Mark> marks = new ArrayList<>();

    public Transcript() {}

  
    // added generate pdf
    public void generatePDF() {
        System.out.println("done");
    }
    

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "marks: " + marks;
    }
}