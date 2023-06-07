package com.ead.course.dtos;

import com.ead.course.enums.*;
import lombok.*;

import javax.validation.constraints.*;
import java.util.*;

@Data
public class CourseDto {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private String imageUrl;
    @NotNull
    private CourseStatus courseStatus;
    @NotNull
    private UUID userInstructor;
    @NotNull
    private CourseLevel courseLevel;
}
