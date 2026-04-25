package academic;

import enums.UrgencyLevel;
import enums.RequestStatus;

public class Complaint {

    private String text;
    private UrgencyLevel urgency;
    private RequestStatus status;

    public Complaint() {}

    public Complaint(String text, UrgencyLevel urgency, RequestStatus status) {
        this.text = text;
        this.urgency = urgency;
        this.status = status;
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

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint{text='" + text + "', urgency=" + urgency + ", status=" + status + "}";
    }
}