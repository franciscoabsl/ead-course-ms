package com.ead.course.services;

import org.springframework.data.domain.*;

import java.util.*;

public interface UtilsService {

    public String createUrlGetAllUsersByCourse(UUID courseId, Pageable pageable);
}
