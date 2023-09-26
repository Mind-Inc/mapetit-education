package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Category {
    private String id;

    @JsonProperty("parent_category_id")
    private String parentCategoryId;

    private Descriptor descriptor;

    private Time time;

    private List<TagGroup> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<TagGroup> getTags() {
        return tags;
    }

    public void setTags(List<TagGroup> tags) {
        this.tags = tags;
    }
}
