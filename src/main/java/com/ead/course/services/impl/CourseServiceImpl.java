package com.ead.course.services.impl;

import com.ead.course.clients.AuthUserClient;
import com.ead.course.models.*;
import com.ead.course.repositories.*;
import com.ead.course.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    CourseUserRepository courseUserRepository;

    @Autowired
    AuthUserClient authUserClient;

    @Transactional
    @Override
    public void delete(CourseModel courseModel) {
        boolean deleteCourseUserInAuthUser = false;

        List<ModuleModel> moduleModelList = moduleRepository.findAllModulesIntoCourse(courseModel.getCourseId());
        if (!moduleModelList.isEmpty()) {

            for (ModuleModel module : moduleModelList) {
                List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(module.getModuleId());

                if (!lessonModelList.isEmpty()) {
                    lessonRepository.deleteAll(lessonModelList);
                }
            }
            moduleRepository.deleteAll(moduleModelList);
        }

        List<CourseUserModel> courseUserModelList = courseUserRepository.findAllCourseUserIntoCourse(courseModel.getCourseId());

        if (!courseUserModelList.isEmpty()) {
            courseUserRepository.deleteAll(courseUserModelList);
            deleteCourseUserInAuthUser = true;
        }

        courseRepository.delete(courseModel);

        if(deleteCourseUserInAuthUser) {
            authUserClient.deleteCourseInAuthUser(courseModel.getCourseId());
        }
    }

    @Override
    public CourseModel save(CourseModel courseModel) {
        return courseRepository.save(courseModel);
    }

    @Override
    public Optional<CourseModel> findById(UUID courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Page<CourseModel> findAll(Specification<CourseModel> spec, Pageable pageable) {
        return courseRepository.findAll(spec, pageable);
    }
}
