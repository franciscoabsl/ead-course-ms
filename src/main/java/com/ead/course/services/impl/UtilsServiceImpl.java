package com.ead.course.services.impl;

import com.ead.course.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UtilsServiceImpl implements UtilsService {

    public String createUrlGetAllUsersByCourse(UUID courseId, Pageable pageable) {
        return  "/users?courseId=" + courseId +
                "&page=" + pageable.getPageNumber() +
                "&size=" + pageable.getPageSize() +
                "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");
    }
}
