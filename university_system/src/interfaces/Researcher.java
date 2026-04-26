package interfaces;

import research.ResearchPaper;
import research.ResearchProject;

import java.util.Comparator;
import java.util.List;

/**
 * Interface representing a Researcher in the university system.
 * Can be implemented by Teacher, Student (Graduate), or standalone Employee.
 */
public interface Researcher {

    // ─── Core Research Info ───────────────────────────────────────────────────

    List<ResearchPaper> getPapers();

    List<ResearchProject> getProjects();

    /**
     * Calculates the h-index of the researcher.
     * h-index = largest h such that h papers have at least h citations each.
     */
    default int calculateHIndex() {
        List<ResearchPaper> papers = getPapers();
        if (papers == null || papers.isEmpty()) return 0;

        // Sort citations descending
        List<Integer> citations = papers.stream()
                .map(ResearchPaper::getCitations)
                .sorted((a, b) -> b - a)
                .toList();

        int h = 0;
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }

    // ─── Paper Management ─────────────────────────────────────────────────────

    void addPaper(ResearchPaper paper);

    void joinProject(ResearchProject project) throws Exception;

    /**
     * Prints all papers sorted by the given comparator.
     * Example comparators: by citations, by date, by pages (length).
     */
    default void printPapers(Comparator<ResearchPaper> comparator) {
        List<ResearchPaper> papers = getPapers();
        if (papers == null || papers.isEmpty()) {
            System.out.println("No research papers found.");
            return;
        }
        papers.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }
}
