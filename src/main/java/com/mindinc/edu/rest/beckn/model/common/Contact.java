package com.mindinc.edu.rest.beckn.model.common;

public class Contact {
    private String phone;
    private String email;
    private Object jcard;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getJcard() {
        return jcard;
    }

    public void setJcard(Object jcard) {
        this.jcard = jcard;
    }
}