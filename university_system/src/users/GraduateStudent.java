package users;

import enums.Language;
import interfaces.Researcher;
import research.ResearchPaper;

import java.util.ArrayList;
import java.util.List;

public class GraduateStudent extends Student {
    private Researcher researchSupervisor;
    private List<ResearchPaper> diplomaPapers;

    public GraduateStudent() {
        this.diplomaPapers = new ArrayList<>();
    }

    public GraduateStudent(int id, String username, String password, String name, String email, Language language,
                           String studentId, int yearOfStudy, int totalCredits, int failedCoursesCount,
                           Researcher researchSupervisor) {
        super(id, username, password, name, email, language, studentId, yearOfStudy, totalCredits, failedCoursesCount);
        this.researchSupervisor = researchSupervisor;
        this.diplomaPapers = new ArrayList<>();
    }

    public Researcher getResearchSupervisor() {
        return researchSupervisor;
    }

    public void setResearchSupervisor(Researcher researchSupervisor) {
        this.researchSupervisor = researchSupervisor;
    }

    public List<ResearchPaper> getDiplomaPapers() {
        return diplomaPapers;
    }

    public void setDiplomaPapers(List<ResearchPaper> diplomaPapers) {
        this.diplomaPapers = diplomaPapers;
    }

    public void addDiplomaPaper(ResearchPaper paper) {
        System.out.println("addDiplomaPaper called");
        diplomaPapers.add(paper);
    }

    @Override
    public String toString() {
        return "GraduateStudent{" +
                "researchSupervisor=" + researchSupervisor +
                ", diplomaPapers=" + diplomaPapers +
                '}';
    }
}