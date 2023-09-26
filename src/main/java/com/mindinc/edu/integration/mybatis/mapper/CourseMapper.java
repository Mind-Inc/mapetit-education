package com.mindinc.edu.integration.mybatis.mapper;

import com.mindinc.edu.integration.mybatis.model.Course;
import com.mindinc.edu.integration.mybatis.model.Institution;
import com.mindinc.edu.integration.mybatis.model.Instructor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CourseMapper {

    @Insert({
            "INSERT INTO course",
            "(",
            "   title,",
            "   subject,",
            "   course_type,",
            "   learning_outcomes,",
            "   learning_objectives,",
            "   instructor_id,",
            "   posted_on,",
            "   difficulty,",
            "   course_language,",
            "   description,",
            "   fee,",
            "   enroll_process",
            ") ",
            "VALUES",
            "(",
            "   #{title},",
            "   #{subject},",
            "   #{courseType},",
            "   #{learningOutcomes},",
            "   #{learningObjectives},",
            "   #{instructor.id},",
            "   #{postedOn},",
            "   #{difficultyType},",
            "   #{language},",
            "   #{description},",
            "   #{fee},",
            "   #{enrollProcess}",
            ")"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertCourse(Course course);

    @Insert({
            "INSERT INTO instructor",
            "(",
            "   name",
            ") ",
            "VALUES",
            "(",
            "   #{name}",
            ")"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertInstructor(Instructor instructor);

    @Insert({
            "INSERT INTO institution",
            "(",
            "   name",
            ") ",
            "VALUES",
            "(",
            "   #{name}",
            ")"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertInstitution(Institution institution);

    @Insert({
            "INSERT INTO instructor_institution_link",
            "(",
            "   instructor_id,",
            "   institution_id",
            ") ",
            "VALUES",
            "(",
            "   #{instructorId},",
            "   #{institutionId}",
            ")"
    })
    public void insertInstructorInstitutionLink(@Param("instructorId") String instructorId, @Param("institutionId") String institutionId);
}
