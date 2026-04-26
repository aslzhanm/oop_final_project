package research;

import enums.CitationFormat;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.*;


public class ResearchPaper implements Serializable, Comparable<ResearchPaper> {

    private static final long serialVersionUID = 1L;

    // ─── Fields ───────────────────────────────────────────────────────────────


    private int pages;              // number of pages (used for "article length" sort)
    private Date publishDate; // corected name (cap)
    private String doi;
    private int citations;
    private String title;

 
    public ResearchPaper(String title, List<String> authors, String journal,
                         int pages, Date datePublished, String doi) {
        this.title = title;

        this.pages = pages;
        this.publishDate = datePublished;
        this.doi = doi;
        this.citations = 0;
    }

   
    public String getCitation(CitationFormat format) {
    	return "ok";
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
                ", pages=" + pages +
                ", datePublished=" + publishDate +
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

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public Date getDatePublished() { return publishDate; }
    public void setDatePublished(Date datePublished) { this.publishDate = datePublished; }

    public String getDoi() { return doi; }
    public void setDoi(String doi) { this.doi = doi; }

    public int getCitations() { return citations; }
    public void setCitations(int citations) { this.citations = citations; }
    public void addCitation() { this.citations++; }
}
