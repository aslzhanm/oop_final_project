package academic;

import enums.UrgencyLevel;
import enums.RequestStatus;

public class Complaint {

    private String text;
    private UrgencyLevel urgency;

    public Complaint() {}

    public Complaint(String text, UrgencyLevel urgency) {
        this.text = text;
        this.urgency = urgency;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UrgencyLevel getUrgency() {
        return urgency;
    }

    public void setUrgency(UrgencyLevel urgency) {
        this.urgency = urgency;
    }

    
    @Override
    public String toString() {
        return "Complaint{text='" + text + "', urgency=" + urgency + "}";
    }
}