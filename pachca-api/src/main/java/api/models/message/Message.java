package api.models.message;

import api.models.message.buttons.Button;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Message {
    private String entity_type;
    private int entity_id;
    private String content;
    private List<List<Button>> buttons;
}
