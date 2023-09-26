package com.mindinc.edu.rest.beckn.model.search;

import com.mindinc.edu.rest.beckn.model.common.Context;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SearchRequest {
    private Context context;
    private SearchMessage message;
    //private Error error;
}
