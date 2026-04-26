package communication;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a message sent between users/employees in the university system.
 * Any employee can send a message to any other employee.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    // ─── Fields ───────────────────────────────────────────────────────────────

    private String messageId;
    private String senderId;      // ID of the sender (User)
    private String receiverId;    // ID of the receiver (User)
    private String subject;
    private String content;
    private LocalDateTime sentAt;
    private boolean isRead;

    // ─── Constructors ─────────────────────────────────────────────────────────

    public Message() {
        this.messageId = UUID.randomUUID().toString();
        this.sentAt = LocalDateTime.now();
        this.isRead = false;
    }

    public Message(String senderId, String receiverId, String subject, String content) {
        this.messageId = UUID.randomUUID().toString();
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.subject = subject;
        this.content = content;
        this.sentAt = LocalDateTime.now();
        this.isRead = false;
    }

    // ─── Methods ──────────────────────────────────────────────────────────────

    public void markAsRead() {
        this.isRead = true;
    }

    // ─── Utility ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", from='" + senderId + '\'' +
                ", to='" + receiverId + '\'' +
                ", subject='" + subject + '\'' +
                ", sentAt=" + sentAt +
                ", isRead=" + isRead +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(messageId, message.messageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId);
    }

    // ─── Getters & Setters ────────────────────────────────────────────────────

    public String getMessageId() { return messageId; }
    public void setMessageId(String messageId) { this.messageId = messageId; }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getReceiverId() { return receiverId; }
    public void setReceiverId(String receiverId) { this.receiverId = receiverId; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }

    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }
}
