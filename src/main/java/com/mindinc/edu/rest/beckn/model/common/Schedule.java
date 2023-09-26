package com.mindinc.edu.rest.beckn.model.common;

import lombok.Data;

import java.util.List;

@Data
public class Schedule {
    private String frequency;
    private List<String> holidays;
    private List<String> times;
}