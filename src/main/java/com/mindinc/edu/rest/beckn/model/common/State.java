package com.mindinc.edu.rest.beckn.model.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class State {
    private String name;
    private String code;
}
