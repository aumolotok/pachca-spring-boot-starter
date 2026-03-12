package api.models.data;

import api.enums.EventType;
import api.models.data.payloads.BasePayload;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EventItem<PayloadType extends BasePayload> {
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("event_type")
    private EventType eventType;
    
    @JsonProperty("payload")
    private PayloadType payload;
    
    @JsonProperty("created_at")
    private String createdAt;
}