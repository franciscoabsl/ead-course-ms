package com.ead.course.services.impl;

import com.ead.course.models.CourseModel;
import com.ead.course.repositories.*;
import com.ead.course.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.UUID;

@Service
public class CourserUserServiceImpl implements CourseUserService{

    @Autowired
    CourseUserRepository courseUserRepository;

    @Override
    public boolean existsByCourseAndUserId(CourseModel courseModel, UUID userId) {
        return courseUserRepository.existsByCourseAndUserId(courseModel, userId);
    }
}
