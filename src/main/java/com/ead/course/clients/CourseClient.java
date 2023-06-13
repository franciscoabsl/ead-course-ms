package com.ead.course.clients;

import com.ead.course.configs.*;
import com.ead.course.dtos.*;
import com.ead.course.services.*;
import lombok.extern.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;

@Log4j2
@Component
public class CourseClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UtilsService utilsService;

    @Value("${ead.api.url.authuser}")
    String REQUEST_URL_AUTHUSER;

    public Page<UserDto> getAllUsersByCourse(UUID courseId, Pageable pageable) {
        List<UserDto> searchResult = null;
        ResponseEntity<ResponsePageDto<UserDto>> result = null;

        String url = REQUEST_URL_AUTHUSER + utilsService.createUrlGetAllUsersByCourse(courseId, pageable);

        log.debug("REQUEST URL: {} ", url);
        log.info("REQUEST URL: {} ", url);

        try {
            ParameterizedTypeReference<ResponsePageDto<UserDto>> responseType = new ParameterizedTypeReference<ResponsePageDto<UserDto>>() {};
            result = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
            searchResult = result.getBody().getContent();
            log.debug("Response Number of Elements: {} ", searchResult.size());

        } catch (HttpStatusCodeException e) {

            log.error("Error request /users {} ", e);
        }

        log.debug("Ending request /users courseId {} ", courseId);

        return result.getBody();
    }

}
