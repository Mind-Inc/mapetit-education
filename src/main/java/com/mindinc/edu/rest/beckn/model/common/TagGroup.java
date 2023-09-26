package com.mindinc.edu.rest.beckn.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagGroup {

    @Builder.Default
    private boolean display = true;
    private Descriptor descriptor;
    private List<Tag> list;
}
