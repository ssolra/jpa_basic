package com.study.jpa.sora.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamDTO {
    private String id;
    private String name;
    private Integer score;
    private List<UserNameDTO> users;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
