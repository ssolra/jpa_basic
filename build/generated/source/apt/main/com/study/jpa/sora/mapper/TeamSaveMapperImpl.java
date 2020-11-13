package com.study.jpa.sora.mapper;

import com.study.jpa.sora.domain.entity.Team;
import com.study.jpa.sora.dto.TeamSaveDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-10T15:52:13+0900",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class TeamSaveMapperImpl implements TeamSaveMapper {

    @Override
    public Team toEntity(TeamSaveDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( dto.getId() );
        team.setName( dto.getName() );
        team.setScore( dto.getScore() );

        return team;
    }

    @Override
    public TeamSaveDTO toDto(Team entity) {
        if ( entity == null ) {
            return null;
        }

        TeamSaveDTO teamSaveDTO = new TeamSaveDTO();

        teamSaveDTO.setId( entity.getId() );
        teamSaveDTO.setName( entity.getName() );
        teamSaveDTO.setScore( entity.getScore() );

        return teamSaveDTO;
    }

    @Override
    public List<Team> toEntity(List<TeamSaveDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Team> list = new ArrayList<Team>( dtoList.size() );
        for ( TeamSaveDTO teamSaveDTO : dtoList ) {
            list.add( toEntity( teamSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<TeamSaveDTO> toDto(List<Team> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TeamSaveDTO> list = new ArrayList<TeamSaveDTO>( entityList.size() );
        for ( Team team : entityList ) {
            list.add( toDto( team ) );
        }

        return list;
    }
}
