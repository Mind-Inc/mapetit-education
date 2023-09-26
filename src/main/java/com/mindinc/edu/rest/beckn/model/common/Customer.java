package com.mindinc.edu.rest.beckn.model.common;

public class Customer {
    private Person person;
    private Contact contact;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
