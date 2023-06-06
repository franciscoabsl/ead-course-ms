package com.ead.course.repositories;

import com.ead.course.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import java.util.*;

public interface LessonRepository extends JpaRepository<LessonModel, UUID> {

    @Query(value = "select * from tb_lessons where module_module_id = :moduleId", nativeQuery = true)
    List<LessonModel> findAllLessonsIntoModule(@Param("moduleId") UUID moduleId);
}
