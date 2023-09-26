package com.mindinc.edu.rest.beckn.model.response;

import com.mindinc.edu.rest.beckn.model.common.Ack;
import lombok.Data;

@Data
public class ResponseMessage {
    private Ack ack;
}
