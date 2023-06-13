package com.ead.course.dtos;

import com.ead.course.enums.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private UUID userId;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private UserStatus userStatus;
    private UserType userType;
    private String phoneNumber;
    private String cpf;
    private String imageUrl;

}
