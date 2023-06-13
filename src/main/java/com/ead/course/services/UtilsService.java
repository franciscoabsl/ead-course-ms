package com.ead.course.services;

import org.springframework.data.domain.*;

import java.util.*;

public interface UtilsService {

    public String createUrl(UUID courseId, Pageable pageable);
}
