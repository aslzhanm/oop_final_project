package communication;

import enums.RequestStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a tech support request submitted by a user.
 *
 * Status flow:
 *   (submitted) → VIEWED → ACCEPTED → DONE
 *                        → REJECTED
 *
 * Example requests: "fix a projector", "fix a printer", "reset password", etc.
 */
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    // ─── Fields ───────────────────────────────────────────────────────────────

    private String requestId;
    private String senderId;        // ID of the user who submitted the request
    private String description;     // what needs to be fixed / done
    private RequestStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String techSpecialistId; // assigned tech support specialist (nullable)

    // ─── Constructors ─────────────────────────────────────────────────────────

    public Request() {
        this.requestId = UUID.randomUUID().toString();
        this.status = RequestStatus.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Request(String senderId, String description) {
        this.requestId = UUID.randomUUID().toString();
        this.senderId = senderId;
        this.description = description;
        this.status = RequestStatus.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // ─── Status Transition Methods ────────────────────────────────────────────

    /**
     * Called when a TechSupportSpecialist views the request.
     * Status changes to VIEWED automatically.
     */
    public void markAsViewed(String specialistId) {
        this.techSpecialistId = specialistId;
        this.status = RequestStatus.VIEWED;
        this.updatedAt = LocalDateTime.now();
        System.out.println("Request [" + requestId + "] marked as VIEWED by " + specialistId);
    }

    public void accept() {
        this.status = RequestStatus.ACCEPTED;
        this.updatedAt = LocalDateTime.now();
        System.out.println("Request [" + requestId + "] ACCEPTED.");
    }

    public void reject() {
        this.status = RequestStatus.REJECTED;
        this.updatedAt = LocalDateTime.now();
        System.out.println("Request [" + requestId + "] REJECTED.");
    }

    public void markAsDone() {
        this.status = RequestStatus.DONE;
        this.updatedAt = LocalDateTime.now();
        System.out.println("Request [" + requestId + "] marked as DONE.");
    }

    // ─── Utility ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + requestId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", techSpecialistId='" + techSpecialistId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return Objects.equals(requestId, request.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId);
    }

    // ─── Getters & Setters ────────────────────────────────────────────────────

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getTechSpecialistId() { return techSpecialistId; }
    public void setTechSpecialistId(String techSpecialistId) { this.techSpecialistId = techSpecialistId; }
}
