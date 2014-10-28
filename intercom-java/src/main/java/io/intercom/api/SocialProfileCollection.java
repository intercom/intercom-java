package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SocialProfileCollection extends TypedData {

    @JsonProperty("type")
    private String type = "social_profile.list";

    @JsonProperty("social_profiles")
    private List<SocialProfile> socialProfiles = Lists.newArrayList();

    SocialProfileCollection() {
    }

    public String getType() {
        return type;
    }

    public List<SocialProfile> getSocialProfiles() {
        return socialProfiles == null ? null : ImmutableList.<SocialProfile>builder().addAll(socialProfiles).build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocialProfileCollection that = (SocialProfileCollection) o;

        if (socialProfiles != null ? !socialProfiles.equals(that.socialProfiles) : that.socialProfiles != null)
            return false;
        //noinspection RedundantIfStatement
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (socialProfiles != null ? socialProfiles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SocialProfileCollection{" +
            "type='" + type + '\'' +
            ", socialProfiles=" + socialProfiles +
            "} " + super.toString();
    }
}
