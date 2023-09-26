package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Descriptor {

    private String code;
    private String name;

    @JsonProperty("short_desc")
    private String shortDesc;

    @JsonProperty("long_desc")
    private String longDesc;

    @JsonProperty("additional_desc")
    private AdditionalDesc additionalDesc;

    private List<MediaFile> media;

    private List<Image> images;

    public Descriptor(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public AdditionalDesc getAdditionalDesc() {
        return additionalDesc;
    }

    public void setAdditionalDesc(AdditionalDesc additionalDesc) {
        this.additionalDesc = additionalDesc;
    }

    public List<MediaFile> getMedia() {
        return media;
    }

    public void setMedia(List<MediaFile> media) {
        this.media = media;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
