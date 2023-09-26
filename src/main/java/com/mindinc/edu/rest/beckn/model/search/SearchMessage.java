package com.mindinc.edu.rest.beckn.model.search;

import com.mindinc.edu.rest.beckn.model.common.Intent;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SearchMessage {
    private Intent intent;
}
