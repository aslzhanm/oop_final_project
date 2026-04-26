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


    // ─── Inner class: Comment ─────────────────────────────────────────────────

    public class News implements Serializable {
        private String title;
        private String text;
        private String topic;
        private boolean pinned;

        public News() {}

        public News(String title, String text, String topic, boolean p) {
            this.title = title;
            this.text = text;
            this.topic = topic;
            this.pinned = p;
        }

         
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        
//        @Override
//        public String toString() {
//            return "[" + + " @ " + createdAt + "]: " + text;
//        }
      

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getTopic() { return topic; }
        public void setTopic(String topic) {
            this.topic = topic;
        }
        
        public void setPin(boolean b) {
        	this.pinned = b;
        }
    }

    
    

    // ─── Getters & Setters ────────────────────────────────────────────────────

    

    

