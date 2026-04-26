package communication;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a news post in the university system.
 *
 * Rules from spec:
 * - News with topic "Research" must be pinned/prioritized.
 * - When a Researcher publishes a paper → announcement news is auto-generated.
 * - Top cited researcher news is auto-generated periodically.
 * - News can have comments.
 */
public class News implements Serializable, Comparable<News> {

    private static final long serialVersionUID = 1L;

    // ─── Inner class: Comment ─────────────────────────────────────────────────

    public static class Comment implements Serializable {
        private String authorId;
        private String text;
        private LocalDateTime createdAt;

        public Comment() {}

        public Comment(String authorId, String text) {
            this.authorId = authorId;
            this.text = text;
            this.createdAt = LocalDateTime.now();
        }

        public String getAuthorId() { return authorId; }
        public void setAuthorId(String authorId) { this.authorId = authorId; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

        @Override
        public String toString() {
            return "[" + authorId + " @ " + createdAt + "]: " + text;
        }
    }

    // ─── Fields ───────────────────────────────────────────────────────────────

    private String newsId;
    private String title;
    private String topic;       // e.g., "Research", "Events", "Academic", etc.
    private String content;
    private String authorId;
    private LocalDateTime publishedAt;
    private boolean isPinned;   // true if topic == "Research"
    private List<Comment> comments;

    // ─── Constructors ─────────────────────────────────────────────────────────

    public News() {
        this.newsId = UUID.randomUUID().toString();
        this.publishedAt = LocalDateTime.now();
        this.comments = new ArrayList<>();
        this.isPinned = false;
    }

    public News(String title, String topic, String content, String authorId) {
        this.newsId = UUID.randomUUID().toString();
        this.title = title;
        this.topic = topic;
        this.content = content;
        this.authorId = authorId;
        this.publishedAt = LocalDateTime.now();
        this.comments = new ArrayList<>();
        // Auto-pin research news
        this.isPinned = "Research".equalsIgnoreCase(topic);
    }

    // ─── Factory Methods (auto-generated news) ────────────────────────────────

    /**
     * Automatically creates an announcement when a researcher publishes a paper.
     */
    public static News createPaperAnnouncement(String researcherName, String paperTitle) {
        String content = "Researcher " + researcherName +
                " has published a new paper: \"" + paperTitle + "\".";
        return new News("New Research Paper Published", "Research", content, "SYSTEM");
    }

    /**
     * Automatically creates news about the top cited researcher of the year.
     */
    public static News createTopResearcherNews(String researcherName, int citations, int year) {
        String content = researcherName + " is the top cited researcher of " + year +
                " with " + citations + " total citations.";
        return new News("Top Cited Researcher of " + year, "Research", content, "SYSTEM");
    }

    // ─── Comment Management ───────────────────────────────────────────────────

    public void addComment(String authorId, String text) {
        comments.add(new Comment(authorId, text));
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    // ─── Comparable ───────────────────────────────────────────────────────────

    /**
     * Pinned (Research) news comes first; then sorted by date descending.
     */
    @Override
    public int compareTo(News other) {
        if (this.isPinned && !other.isPinned) return -1;
        if (!this.isPinned && other.isPinned) return 1;
        return other.publishedAt.compareTo(this.publishedAt); // newest first
    }

    // ─── Utility ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "News{" +
                "newsId='" + newsId + '\'' +
                ", title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                ", author='" + authorId + '\'' +
                ", publishedAt=" + publishedAt +
                ", pinned=" + isPinned +
                ", comments=" + comments.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return Objects.equals(newsId, news.newsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId);
    }

    // ─── Getters & Setters ────────────────────────────────────────────────────

    public String getNewsId() { return newsId; }
    public void setNewsId(String newsId) { this.newsId = newsId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) {
        this.topic = topic;
        this.isPinned = "Research".equalsIgnoreCase(topic);
    }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getAuthorId() { return authorId; }
    public void setAuthorId(String authorId) { this.authorId = authorId; }

    public LocalDateTime getPublishedAt() { return publishedAt; }
    public void setPublishedAt(LocalDateTime publishedAt) { this.publishedAt = publishedAt; }

    public boolean isPinned() { return isPinned; }
    public void setPinned(boolean pinned) { isPinned = pinned; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
}
