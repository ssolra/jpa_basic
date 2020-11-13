package com.study.jpa.sora.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private Integer age;
    private String grade;
    private TeamNameDTO team;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
