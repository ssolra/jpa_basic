package com.study.jpa.sora.mapper;

import com.study.jpa.sora.domain.entity.Team;
import com.study.jpa.sora.dto.TeamDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TeamMapper extends EntityMapper<TeamDTO, Team> {
}
