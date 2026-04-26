package communication;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.*;
import users.*;



 
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    // ─── Fields ───────────────────────────────────────────────────────────────

    private User sender;      
    private User receiver;    
    private String text;
    private Date date;

 

    public Message(String text, User s, User r, Date d) {
        this.sender = s;
        this.receiver = r;
        this.text = text;
        this.date = d;
    }

   
  
    public User getSender() { return sender; }
    public void setSenderId(User senderId) { this.sender = senderId; }

    public User getReceiver() { return receiver; }
    public void setReceiver(User receiverId) { this.receiver = receiverId; }

    public String getText() { return text; }
    public void setText(String subject) { this.text = subject; }

    public Date getDate() { return date; }
    public void setSentAt(Date sentAt) { this.date = sentAt; }


}
