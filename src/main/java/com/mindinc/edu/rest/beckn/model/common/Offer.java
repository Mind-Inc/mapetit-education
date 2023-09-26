package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Offer {
    private String id;
    private Descriptor descriptor;

    @JsonProperty("location_ids")
    private List<String> locationIds;

    @JsonProperty("category_ids")
    private List<String> categoryIds;

    @JsonProperty("item_ids")
    private List<String> itemIds;

    private Time time;

    private List<TagGroup> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    public List<String> getLocationIds() {
        return locationIds;
    }

    public void setLocationIds(List<String> locationIds) {
        this.locationIds = locationIds;
    }

    public List<String> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
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
