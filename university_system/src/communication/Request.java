package communication;

import enums.RequestStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    private RequestStatus status;
    private String description;

//    }

    public Request(RequestStatus r, String description) {
        
        this.description = description;
        this.status = r;
        
    }

    
    // ─── Utility ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Request{" +
                
                ", description='" + description + '\'' +
                ", status=" + status +
                
                '}';
    }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }


}
