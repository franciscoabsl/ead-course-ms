package com.ead.course.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import java.util.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_USERS")
public class UserModel {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

}
