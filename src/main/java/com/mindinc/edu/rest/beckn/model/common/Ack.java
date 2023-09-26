package com.mindinc.edu.rest.beckn.model.common;

import com.mindinc.edu.rest.beckn.enums.AckStatus;

public class Ack {
    private AckStatus status;

    public Ack() {
    }

    public Ack(AckStatus status) {
        this.status = status;
    }

    public AckStatus getStatus() {
        return status;
    }

    public void setStatus(AckStatus status) {
        this.status = status;
    }
}
