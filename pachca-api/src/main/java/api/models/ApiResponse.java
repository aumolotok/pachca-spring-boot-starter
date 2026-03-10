package api.models;

import api.models.data.EventItem;
import api.models.meta.Meta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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