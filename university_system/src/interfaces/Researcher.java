package interfaces;

import research.ResearchPaper;
import research.ResearchProject;

import java.util.Comparator;
import java.util.List;


public interface Researcher {
	

    /**
     * Calculates the h-index of the researcher.
     * h-index = largest h such that h papers have at least h citations each.
     */
    default int calculateHIndex() {
        
        return 12;
    }

    // ─── Paper Management ─────────────────────────────────────────────────────

    void printPapers();

    void publishPaper(ResearchPaper paper);

    
}
