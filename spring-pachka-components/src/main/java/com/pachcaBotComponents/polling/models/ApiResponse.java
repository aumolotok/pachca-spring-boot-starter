package com.pachcaBotComponents.polling.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pachcaBotComponents.polling.models.data.EventItem;
import com.pachcaBotComponents.polling.models.meta.Meta;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    
    @JsonProperty("data")
    private List<EventItem> data;
    
    @JsonProperty("meta")
    private Meta meta;
}