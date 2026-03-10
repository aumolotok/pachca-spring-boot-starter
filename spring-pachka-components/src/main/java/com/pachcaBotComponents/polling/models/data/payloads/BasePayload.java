package com.pachcaBotComponents.polling.models.data.payloads;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MessagePayload.class, name = "message"),
        @JsonSubTypes.Type(value = ReactionPayload.class, name = "reaction")
})
public class BasePayload {
}
