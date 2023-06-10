package com.ead.course.services;

import com.ead.course.models.*;
import com.ead.course.specifications.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.*;

import java.util.*;

public interface LessonService {
    LessonModel save(LessonModel lessonModel);

    Optional<LessonModel> findLessonIntoModule(UUID moduleId, UUID lessonId);

    void delete(LessonModel lessonModel);

    List<LessonModel> findAllByModule(UUID moduleId);

    Page<LessonModel> findAllByModule(Specification<LessonModel> spec, Pageable pageable);
}
