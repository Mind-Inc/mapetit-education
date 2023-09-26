package com.mindinc.edu.integration.mybatis.model;

public enum CourseType {
    WORKSHOP("WORKSHOP"),
    SEMINAR("SEMINAR"),
    WEBINAR("WEBINAR"),
    MOOC("MOOC"),
    LECTURE_SERIES("LECTURE SERIES"),
    BOOTCAMP("BOOTCAMP"),
    RECORDED("RECORDED"),
    LIVE("LIVE");

    private final String value;

    CourseType(String value) {
        this.value = value;
    }
}
