package io.intercom.api;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdminAwayMode extends TypedData {

    @JsonProperty("id")
    private String id;

    @JsonProperty("away_mode_enabled")
    private boolean awayModeEnabled;

    @JsonProperty("away_mode_reassign")
    private boolean awayModeReassign;

    public AdminAwayMode(String Id, boolean awayModeEnabled, boolean awayModeReassign) {
        this.id = id;
        this.awayModeEnabled = awayModeEnabled;
        this.awayModeReassign = awayModeReassign;
    }
    String getId() {
        return id;
    }
    public boolean getAwayModeEnabled(){
        return awayModeEnabled;
    }

    public boolean getAwayModeReassign(){
        return awayModeReassign;
    }

    @Override
    public String toString() {
        return "AdminAwayMode{" +
                "id='" + id + '\'' +
                ", awayModeEnabled=" + awayModeEnabled +
                ", awayModeReassign=" + awayModeReassign +
                "} " + super.toString();
    }
}
