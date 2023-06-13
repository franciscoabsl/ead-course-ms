package com.ead.course.services.impl;

import com.ead.course.services.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UtilsServiceImpl implements UtilsService {

    private String REQUEST_URI = "http://localhost:8087";

    public String createUrl(UUID courseId, Pageable pageable) {
        return REQUEST_URI +
                "/users?courseId=" + courseId +
                "&page=" + pageable.getPageNumber() +
                "&size=" + pageable.getPageSize() +
                "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");
    }
}
