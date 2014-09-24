package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationData extends TypedData {

    @JsonProperty("type")
    private final String type = "location_data";

    @JsonProperty("city_name")
    private String city_Name;

    @JsonProperty("continent_code")
    private String continentCode;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("latitude")
    private float latitude;

    @JsonProperty("longitude")
    private float longitude;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("region_name")
    private String regionName;

    @JsonProperty("timezone")
    private String timezone;

    public LocationData() {
    }

    public String getType() {
        return type;
    }

    public String getCity_Name() {
        return city_Name;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationData that = (LocationData) o;

        if (Float.compare(that.latitude, latitude) != 0) return false;
        if (Float.compare(that.longitude, longitude) != 0) return false;
        if (city_Name != null ? !city_Name.equals(that.city_Name) : that.city_Name != null) return false;
        if (continentCode != null ? !continentCode.equals(that.continentCode) : that.continentCode != null)
            return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;
        if (regionName != null ? !regionName.equals(that.regionName) : that.regionName != null) return false;
        if (timezone != null ? !timezone.equals(that.timezone) : that.timezone != null) return false;
        //noinspection RedundantIfStatement
        if (!type.equals(that.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (city_Name != null ? city_Name.hashCode() : 0);
        result = 31 * result + (continentCode != null ? continentCode.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
        result = 31 * result + (longitude != +0.0f ? Float.floatToIntBits(longitude) : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LocationData{" +
            "type='" + type + '\'' +
            ", city_Name='" + city_Name + '\'' +
            ", continentCode='" + continentCode + '\'' +
            ", countryCode='" + countryCode + '\'' +
            ", countryName='" + countryName + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            ", postalCode='" + postalCode + '\'' +
            ", regionName='" + regionName + '\'' +
            ", timezone='" + timezone + '\'' +
            "} " + super.toString();
    }
}
