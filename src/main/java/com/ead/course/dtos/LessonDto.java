package com.ead.course.dtos;

import lombok.*;

import javax.validation.constraints.*;

@Data
public class LessonDto {


    @NotBlank
    private String title;
    private String description;
    @NotBlank
    private String videoUrl;
}
