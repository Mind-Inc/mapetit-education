package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String id;
    private Descriptor descriptor;

    @JsonProperty("map_url")
    private String mapUrl;
    private String gps;
    private String address;
    private City city;
    private String district;
    private State state;
    private Country country;

    @JsonProperty("area_code")
    private String areaCode;
    private Circle circle;
    private String polygon;

    @JsonProperty("3dspace")
    private String threeDSpace;

    private String rating;
}
