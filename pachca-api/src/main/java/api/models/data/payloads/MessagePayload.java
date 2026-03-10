package api.models.data.payloads;

import api.models.data.ThreadInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessagePayload extends BasePayload{
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("event")
    private String event;
    
    @JsonProperty("entity_type")
    private String entityType;
    
    @JsonProperty("entity_id")
    private Integer entityId;
    
    @JsonProperty("content")
    private String content;
    
    @JsonProperty("user_id")
    private Integer userId;
    
    @JsonProperty("created_at")
    private String createdAt;
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("chat_id")
    private Integer chatId;
    
    @JsonProperty("parent_message_id")
    private Integer parentMessageId;
    
    @JsonProperty("thread")
    private ThreadInfo thread;
    
    @JsonProperty("webhook_timestamp")
    private Long webhookTimestamp;
}