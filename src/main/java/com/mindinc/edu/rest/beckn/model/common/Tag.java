package com.mindinc.edu.rest.beckn.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    private Descriptor descriptor;
    private String value;
    private boolean display;

    public Tag(Descriptor descriptor) {
        this.descriptor = descriptor;
    }
}
