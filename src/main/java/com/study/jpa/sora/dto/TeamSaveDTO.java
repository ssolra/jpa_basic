package com.study.jpa.sora.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamSaveDTO {
    private String id;
    private String name;
    private Integer score;
}
