package research;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a university research journal.
 * Users can subscribe to receive notifications when new papers are published.
 *
 * Design Pattern: OBSERVER
 *   - Journal = Subject (Observable)
 *   - Subscribers = Observers
 *   When a new paper is published, all subscribers are notified automatically.
 */
public class Journal implements Serializable {

    private static final long serialVersionUID = 1L;

    // ─── Fields ───────────────────────────────────────────────────────────────

    private String name;
    private String issn;            // International Standard Serial Number
    private List<ResearchPaper> papers;
    private List<String> subscribers; // stores subscriber names/IDs (or User references)

    // ─── Constructors ─────────────────────────────────────────────────────────

    public Journal() {
        this.papers = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public Journal(String name, String issn) {
        this.name = name;
        this.issn = issn;
        this.papers = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    // ─── Observer Pattern Methods ─────────────────────────────────────────────

    /** Subscribe a user to this journal (by name or ID). */
    public void subscribe(String userId) {
        if (!subscribers.contains(userId)) {
            subscribers.add(userId);
            System.out.println("User [" + userId + "] subscribed to journal: " + name);
        }
    }

    /** Unsubscribe a user from this journal. */
    public void unsubscribe(String userId) {
        subscribers.remove(userId);
        System.out.println("User [" + userId + "] unsubscribed from journal: " + name);
    }

    /**
     * Notify all subscribers about a new paper.
     * Called automatically when publishPaper() is used.
     */
    private void notifySubscribers(ResearchPaper paper) {
        System.out.println("=== JOURNAL NOTIFICATION [" + name + "] ===");
        System.out.println("New paper published: " + paper.getTitle());
        for (String userId : subscribers) {
            System.out.println("  Notified: " + userId);
        }
    }

    // ─── Paper Management ─────────────────────────────────────────────────────

    /**
     * Publish a new paper in this journal.
     * Automatically notifies all subscribers. (Observer pattern trigger)
     */
    public void publishPaper(ResearchPaper paper) {
        papers.add(paper);
        System.out.println("Paper published in [" + name + "]: " + paper.getTitle());
        notifySubscribers(paper);
    }

    public void removePaper(ResearchPaper paper) {
        papers.remove(paper);
    }

    // ─── Utility ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Journal{" +
                "name='" + name + '\'' +
                ", issn='" + issn + '\'' +
                ", papersCount=" + papers.size() +
                ", subscribersCount=" + subscribers.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        Journal journal = (Journal) o;
        return Objects.equals(issn, journal.issn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issn);
    }

    // ─── Getters & Setters ────────────────────────────────────────────────────

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIssn() { return issn; }
    public void setIssn(String issn) { this.issn = issn; }

    public List<ResearchPaper> getPapers() { return papers; }
    public void setPapers(List<ResearchPaper> papers) { this.papers = papers; }

    public List<String> getSubscribers() { return subscribers; }
    public void setSubscribers(List<String> subscribers) { this.subscribers = subscribers; }
}
