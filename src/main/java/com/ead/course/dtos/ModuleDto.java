package com.ead.course.dtos;

import lombok.*;

import javax.validation.constraints.*;

@Data
public class ModuleDto {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
