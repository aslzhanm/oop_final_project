package research;

import interfaces.Researcher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a research project in the university.
 * Only Researchers can join. Throws custom exception otherwise.
 */
public class ResearchProject implements Serializable {

    private static final long serialVersionUID = 1L;

    // ─── Fields ───────────────────────────────────────────────────────────────

    private String topic;
    private List<Researcher> participants;
    private List<ResearchPaper> publishedPapers;

    // ─── Constructors ─────────────────────────────────────────────────────────

    public ResearchProject() {
        this.participants = new ArrayList<>();
        this.publishedPapers = new ArrayList<>();
    }

    public ResearchProject(String topic) {
        this.topic = topic;
        this.participants = new ArrayList<>();
        this.publishedPapers = new ArrayList<>();
    }

    // ─── Methods ──────────────────────────────────────────────────────────────

    /**
     * Add a researcher to the project.
     * Only objects implementing Researcher can join.
     * (Called internally by Researcher.joinProject — but also usable directly.)
     */
    public void addParticipant(Researcher researcher) {
        if (!participants.contains(researcher)) {
            participants.add(researcher);
            System.out.println("Researcher added to project: " + topic);
        }
    }

    /**
     * Attempt to add a non-researcher to the project — throws custom exception.
     * Used when someone who is NOT a Researcher tries to join.
     */
    public void addNonResearcher(Object person) throws Exception {
        throw new Exception("NotAResearcherException: Only Researchers can join a ResearchProject. " +
                "Person: " + person.toString());
    }

    public void addPaper(ResearchPaper paper) {
        if (!publishedPapers.contains(paper)) {
            publishedPapers.add(paper);
            System.out.println("Paper added to project: " + paper.getTitle());
        }
    }

    public void removePaper(ResearchPaper paper) {
        publishedPapers.remove(paper);
    }

    public void removeParticipant(Researcher researcher) {
        participants.remove(researcher);
    }

    // ─── Utility ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "ResearchProject{" +
                "topic='" + topic + '\'' +
                ", participantsCount=" + participants.size() +
                ", papersCount=" + publishedPapers.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchProject)) return false;
        ResearchProject that = (ResearchProject) o;
        return Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic);
    }

    // ─── Getters & Setters ────────────────────────────────────────────────────

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public List<Researcher> getParticipants() { return participants; }
    public void setParticipants(List<Researcher> participants) { this.participants = participants; }

    public List<ResearchPaper> getPublishedPapers() { return publishedPapers; }
    public void setPublishedPapers(List<ResearchPaper> publishedPapers) { this.publishedPapers = publishedPapers; }
}
