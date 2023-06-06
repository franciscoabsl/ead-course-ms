package com.ead.course.services.impl;

import com.ead.course.models.*;
import com.ead.course.repositories.*;
import com.ead.course.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.*;
import java.util.*;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Transactional
    @Override
    public void delete(ModuleModel moduleModel) {
        List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(moduleModel.getModuleId());
        if (!lessonModelList.isEmpty()) {
            lessonRepository.deleteAll(lessonModelList);
        }

        moduleRepository.delete(moduleModel);
    }
}
