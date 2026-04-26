package communication;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.*;
import users.*;


/**
 * Represents a message sent between users/employees in the university system.
 * Any employee can send a message to any other employee.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    // ─── Fields ───────────────────────────────────────────────────────────────

    private User sender;      
    private User receiver;    
    private String text;
    private Date date;

    // ─── Constructors ─────────────────────────────────────────────────────────

//    public Message() {
//        this.messageId = UUID.randomUUID().toString();
//        this.sentAt = LocalDateTime.now();
//        this.isRead = false;
//    }

    public Message(String text, User s, User r, Date d) {
        this.sender = s;
        this.receiver = r;
        this.text = text;
        this.date = d;
    }

    // ─── Methods ──────────────────────────────────────────────────────────────

//    public void markAsRead() {
//        this.isRead = true;
//    }
//
//    // ─── Utility ─────────────────────────────────────────────────────────────
//
//    @Override
//    public String toString() {
//        return "Message{" +
//                "messageId='" + messageId + '\'' +
//                ", from='" + senderId + '\'' +
//                ", to='" + receiverId + '\'' +
//                ", subject='" + subject + '\'' +
//                ", sentAt=" + sentAt +
//                ", isRead=" + isRead +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Message)) return false;
//        Message message = (Message) o;
//        return Objects.equals(messageId, message.messageId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(messageId);
//    }

    // ─── Getters & Setters ────────────────────────────────────────────────────

  
    public User getSender() { return sender; }
    public void setSenderId(User senderId) { this.sender = senderId; }

    public User getReceiver() { return receiver; }
    public void setReceiver(User receiverId) { this.receiver = receiverId; }

    public String getText() { return text; }
    public void setText(String subject) { this.text = subject; }

    public Date getDate() { return date; }
    public void setSentAt(Date sentAt) { this.date = sentAt; }


}
