package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Stop {
    private String id;

    @JsonProperty("parent_stop_id")
    private String parentStopId;
    private Location location;
    private String type;
    private Time time;
    private Descriptor instructions;
    private Contact contact;
    private Person person;
    private Authorization authorization;
}
