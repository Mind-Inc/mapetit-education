package com.mindinc.edu.rest.beckn.model.common;

import lombok.ToString;

import java.util.List;

@ToString
public class Intent {
    private Descriptor descriptor;
    private Provider provider;
    private Fulfillment fulfillment;
    private Payment payment;
    private Category category;
    private Offer offer;
    private Item item;
    private List<TagGroup> tags;

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Fulfillment getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(Fulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<TagGroup> getTags() {
        return tags;
    }

    public void setTags(List<TagGroup> tags) {
        this.tags = tags;
    }
}