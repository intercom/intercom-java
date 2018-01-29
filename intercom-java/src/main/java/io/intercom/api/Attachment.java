package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Attachment extends TypedData {

    @JsonProperty("type")
    private final String type = "upload";
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("content_type")
    private String contentType;
    @JsonProperty("filesize")
    private long filesize;
    @JsonProperty("width")
    private long width;
    @JsonProperty("height")
    private long height;

    public Attachment() {
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getContentType() {
        return contentType;
    }

    public long getFilesize() {
        return filesize;
    }

    public long getWidth() {
        return width;
    }

    public long getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment attachment = (Attachment) o;

        if (name != null ? !name.equals(attachment.name) : attachment.name != null) return false;
        if (url != null ? !url.equals(attachment.url) : attachment.url != null) return false;
        if (contentType != null ? !contentType.equals(attachment.contentType) : attachment.contentType != null) return false;
        if (filesize != attachment.filesize) return false;
        if (height != attachment.height) return false;
        if (width != attachment.width) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (int) (filesize ^ (filesize >>> 32));
        result = 31 * result + (int) (height ^ (height>>> 32));
        result = 31 * result + (int) (width ^ (width>>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Avatar{" +
            "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", content_type'=" + contentType + '\'' +
                ", filesize=" + filesize +
                ", height=" + height +
                ", widht=" + width +
            "} " + super.toString();
    }
}
