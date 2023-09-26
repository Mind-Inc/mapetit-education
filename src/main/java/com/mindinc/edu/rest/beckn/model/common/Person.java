package com.mindinc.edu.rest.beckn.model.common;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String id;
    private String url;
    private String name;
    private Image image;
    private String age;
    private String dob;
    private String gender;
    private List<Credential> creds;
    private List<Language> languages;
    private List<Skill> skills;
    private List<TagGroup> tags;
}
