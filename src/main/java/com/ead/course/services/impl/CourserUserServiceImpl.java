package com.ead.course.services.impl;

import com.ead.course.repositories.*;
import com.ead.course.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class CourserUserServiceImpl implements CourseUserService{

    @Autowired
    CourseUserRepository courseUserRepository;
}
