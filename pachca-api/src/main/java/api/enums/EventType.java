package api.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EventType {
    @JsonProperty("message_new")
    MESSAGE_NEW,

    @JsonProperty("message_update")
    MESSAGE_UPDATE,

    @JsonProperty("reaction_new")
    REACTION_NEW,

    @JsonProperty("reaction_delete")
    REACTION_DELETE,

    @JsonProperty("button_click")
    BUTTON_CLICK
}
