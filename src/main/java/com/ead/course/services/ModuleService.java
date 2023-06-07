package com.ead.course.services;

import com.ead.course.models.*;

import java.util.*;

public interface ModuleService {

    void delete(ModuleModel moduleModel);

    ModuleModel save(ModuleModel moduleModel);

    Optional<ModuleModel> findModuleIntoCourse(UUID courseId, UUID moduleId);

    List<ModuleModel> findAllByCourse(UUID courseId);
}
