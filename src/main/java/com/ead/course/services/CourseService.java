package com.ead.course.services;

import com.ead.course.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.*;

import java.util.*;

public interface CourseService {
    void delete(CourseModel courseModel);

    CourseModel save(CourseModel courseModel);

    Optional<CourseModel> findById(UUID courseId);

    Page<CourseModel> findAll(Specification<CourseModel> spec, Pageable pageable);
}
