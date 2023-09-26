package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class Item {
    private String id;

    @JsonProperty("parent_item_id")
    private String parentItemId;

    private Descriptor descriptor;

    private String manufacturer;

    private Price price;

    @JsonProperty("category_ids")
    private List<String> categoryIds;

    @JsonProperty("fulfillment_ids")
    private List<String> fulfillmentIds;

    @JsonProperty("location_ids")
    private List<String> locationIds;

    @JsonProperty("payment_ids")
    private List<String> paymentIds;

    @JsonProperty("add_ons")
    private List<AddOn> addOns;

    private XInput xinput;

    private Time time;

    private boolean rateable;

    private List<TagGroup> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<String> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<String> getFulfillmentIds() {
        return fulfillmentIds;
    }

    public void setFulfillmentIds(List<String> fulfillmentIds) {
        this.fulfillmentIds = fulfillmentIds;
    }

    public List<String> getLocationIds() {
        return locationIds;
    }

    public void setLocationIds(List<String> locationIds) {
        this.locationIds = locationIds;
    }

    public List<String> getPaymentIds() {
        return paymentIds;
    }

    public void setPaymentIds(List<String> paymentIds) {
        this.paymentIds = paymentIds;
    }

    public List<AddOn> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOn> addOns) {
        this.addOns = addOns;
    }

    public XInput getXinput() {
        return xinput;
    }

    public void setXinput(XInput xinput) {
        this.xinput = xinput;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isRateable() {
        return rateable;
    }

    public void setRateable(boolean rateable) {
        this.rateable = rateable;
    }

    public List<TagGroup> getTags() {
        return tags;
    }

    public void setTags(List<TagGroup> tags) {
        this.tags = tags;
    }
}
