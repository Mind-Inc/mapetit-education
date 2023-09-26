package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class Context {
    private String domain;

    private Location location;

    private String action;

    @JsonProperty("version")
    private String version;

    @JsonProperty("bap_id")
    private String bapId;

    @JsonProperty("bap_uri")
    private String bapUri;

    @JsonProperty("bpp_id")
    private String bppId;

    @JsonProperty("bpp_uri")
    private String bppUri;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("message_id")
    private String messageId;

    private String timestamp;
    private String key;
    private String ttl;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBapId() {
        return bapId;
    }

    public void setBapId(String bapId) {
        this.bapId = bapId;
    }

    public String getBapUri() {
        return bapUri;
    }

    public void setBapUri(String bapUri) {
        this.bapUri = bapUri;
    }

    public String getBppId() {
        return bppId;
    }

    public void setBppId(String bppId) {
        this.bppId = bppId;
    }

    public String getBppUri() {
        return bppUri;
    }

    public void setBppUri(String bppUri) {
        this.bppUri = bppUri;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
}
