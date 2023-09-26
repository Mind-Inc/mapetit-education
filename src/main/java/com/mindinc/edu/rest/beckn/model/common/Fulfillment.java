package com.mindinc.edu.rest.beckn.model.common;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Fulfillment {
    private String id;
    private String type;
    private OrderState state;
    private boolean tracking;
    private Customer customer;
    private Agent agent;
    private Contact contact;
    private List<Stop> stops;
    private String path;
    private List<TagGroup> tags;
}