package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Payment {
    private String id;

    @JsonProperty("collected_by")
    private String collectedBy;
    private String url;
    private PaymentParams params;
    private String type; //Enum [ PRE-ORDER, PRE-FULFILLMENT, ON-FULFILLMENT, POST-FULFILLMENT ]
    private String status; //Enum [ PAID, NOT-PAID ]
    private Time time;
    private List<TagGroup> tags;
}
