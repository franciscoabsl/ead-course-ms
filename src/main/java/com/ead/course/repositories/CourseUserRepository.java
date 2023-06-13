package com.ead.course.repositories;

import com.ead.course.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface CourseUserRepository extends JpaRepository<CourseUserModel, UUID> {

    boolean existsByCourseAndUserId(CourseModel courseModel, UUID userId);
}
