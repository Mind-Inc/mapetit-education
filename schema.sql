CREATE TABLE course (
     id BIGSERIAL PRIMARY KEY NOT NULL,
     title VARCHAR(100) NOT NULL,
     subject VARCHAR(100) NOT NULL,
     course_type VARCHAR(20),
     learning_outcomes VARCHAR(1000),
     learning_objectives VARCHAR(1000),
     instructor_id BIGSERIAL REFERENCES instructor(id) NOT NULL,
     posted_on timestamp with time zone NOT null default CURRENT_TIMESTAMP,
     difficulty VARCHAR(50),
     course_language VARCHAR(30),
     description VARCHAR(1000),
     fee INTEGER,
     enroll_process VARCHAR(1000)
);

CREATE TABLE instructor (
     id BIGSERIAL PRIMARY KEY NOT NULL,
     name VARCHAR(50)
);

CREATE TABLE institution (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50)
);

CREATE TABLE instructor_institution_link (
    instructor_id BIGSERIAL NOT NULL,
    institution_id BIGSERIAL NOT NULL,
    CONSTRAINT instructor_institution_pk PRIMARY KEY(instructor_id,institution_id)
);