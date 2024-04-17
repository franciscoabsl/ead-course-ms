package com.ead.course.repositories;

import com.ead.course.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface CourseUserRepository extends JpaRepository<CourseUserModel, UUID> {

    boolean existsByCourseAndUserId(CourseModel courseModel, UUID userId);

    @Query(value = "select * from tb_courses_users where course_course_id = :courseId", nativeQuery = true)
    List<CourseUserModel> findAllCourseUserIntoCourse(@Param("courseId") UUID courseId);

    boolean existsByUserId(UUID userId);

    void deleteAllByUserId(UUID userId);
}
