package com.ead.course.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import java.util.*;
import javax.persistence.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_COURSES_USERS")
public class CourseUserModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CourseModel course;
    @Column(nullable = false)
    private UUID userId;

}
