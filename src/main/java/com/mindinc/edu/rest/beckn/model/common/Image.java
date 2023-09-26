package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Image {
    private String url;

    @JsonProperty("size_type")
    private String sizeType; //Enum [xs, sm, md, lg, xl, custom]
    private String width;
    private String height;
}
