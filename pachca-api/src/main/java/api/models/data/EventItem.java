package api.models.data;

import api.models.data.payloads.BasePayload;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventItem {
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("event_type")
    private String eventType;
    
    @JsonProperty("payload")
    private BasePayload payload;
    
    @JsonProperty("created_at")
    private String createdAt;
}