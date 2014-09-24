package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Avatar extends TypedData {

    @JsonProperty("type")
    private final String type = "avatar";

    @JsonProperty("image_url")
    private URI imageURL;

    Avatar() {
    }

    public String getType() {
        return type;
    }

    public URI getImageURL() {
        return imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Avatar avatar = (Avatar) o;

        if (imageURL != null ? !imageURL.equals(avatar.imageURL) : avatar.imageURL != null) return false;
        //noinspection RedundantIfStatement
        if (!type.equals(avatar.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (imageURL != null ? imageURL.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Avatar{" +
            "type='" + type + '\'' +
            ", imageURL=" + imageURL +
            "} " + super.toString();
    }
}
