package api.models.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageModel {
    private Message message;
}
