package api.models.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThreadInfo {
    
    @JsonProperty("message_id")
    private Integer messageId;
    
    @JsonProperty("message_chat_id")
    private Integer messageChatId;
}