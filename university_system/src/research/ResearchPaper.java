package research;

import enums.CitationFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an academic research paper in the university system.
 * Fields inspired by: "LMS Logs and Student Performance: The Influence of Retaking a Course"
 */
public class ResearchPaper implements Serializable, Comparable<ResearchPaper> {

    private static final long serialVersionUID = 1L;

    // ─── Fields ───────────────────────────────────────────────────────────────

    private String title;
    private List<String> authors;   // list of author names
    private String journal;
    private int pages;              // number of pages (used for "article length" sort)
    private LocalDate datePublished;
    private String doi;
    private int citations;

    // ─── Constructors ─────────────────────────────────────────────────────────

    public ResearchPaper() {
        this.authors = new ArrayList<>();
    }

    public ResearchPaper(String title, List<String> authors, String journal,
                         int pages, LocalDate datePublished, String doi) {
        this.title = title;
        this.authors = authors != null ? authors : new ArrayList<>();
        this.journal = journal;
        this.pages = pages;
        this.datePublished = datePublished;
        this.doi = doi;
        this.citations = 0;
    }

    // ─── Citation Formatting ─────────────────────────────────────────────────

    /**
     * Returns a citation string in the requested format.
     *
     * @param format CitationFormat.PLAIN_TEXT or CitationFormat.BIBTEX
     */
    public String getCitation(CitationFormat format) {
        if (format == CitationFormat.BIBTEX) {
            // BibTeX format
            String key = (authors.isEmpty() ? "unknown" : authors.get(0).split(" ")[0].toLowerCase())
                    + (datePublished != null ? datePublished.getYear() : "0000");
            return "@article{" + key + ",\n" +
                    "  title={" + title + "},\n" +
                    "  author={" + String.join(" and ", authors) + "},\n" +
                    "  journal={" + journal + "},\n" +
                    "  pages={" + pages + "},\n" +
                    "  year={" + (datePublished != null ? datePublished.getYear() : "N/A") + "},\n" +
                    "  doi={" + doi + "}\n" +
                    "}";
        } else {
            // Plain Text format
            return String.join(", ", authors) + ". (" +
                    (datePublished != null ? datePublished.getYear() : "N/A") + "). " +
                    title + ". " + journal + ". " +
                    "Pages: " + pages + ". DOI: " + doi;
        }
    }

    // ─── Comparable ───────────────────────────────────────────────────────────

    /** Default sort: by citations descending */
    @Override
    public int compareTo(ResearchPaper other) {
        return Integer.compare(other.citations, this.citations);
    }

    // ─── Utility ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "ResearchPaper{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", journal='" + journal + '\'' +
                ", pages=" + pages +
                ", datePublished=" + datePublished +
                ", doi='" + doi + '\'' +
                ", citations=" + citations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchPaper)) return false;
        ResearchPaper that = (ResearchPaper) o;
        return Objects.equals(doi, that.doi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doi);
    }

    // ─── Getters & Setters ────────────────────────────────────────────────────

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<String> getAuthors() { return authors; }
    public void setAuthors(List<String> authors) { this.authors = authors; }

    public String getJournal() { return journal; }
    public void setJournal(String journal) { this.journal = journal; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public LocalDate getDatePublished() { return datePublished; }
    public void setDatePublished(LocalDate datePublished) { this.datePublished = datePublished; }

    public String getDoi() { return doi; }
    public void setDoi(String doi) { this.doi = doi; }

    public int getCitations() { return citations; }
    public void setCitations(int citations) { this.citations = citations; }
    public void addCitation() { this.citations++; }
}
