package com.mindinc.edu.integration.mybatis.model;

import java.time.OffsetDateTime;
import java.util.List;

public class Course {
    String title;
    String id;
    String subject;
    List<CourseType> courseType;
    String learningOutcomes;
    String learningObjectives;
    OffsetDateTime postedOn;
    Instructor instructor;
    DifficultyType difficultyType;
    String language;
    String description;
    long fee;
    String enrollProcess;
}
