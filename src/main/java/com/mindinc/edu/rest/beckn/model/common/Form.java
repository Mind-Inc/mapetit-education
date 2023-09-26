package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Form {
    @JsonProperty("url")
    private String url;

    @JsonProperty("data")
    private Object data;

    @JsonProperty("mime_type")
    private String mimeType;

    @JsonProperty("submission_id")
    private String submissionId;    //UUID

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }
}
