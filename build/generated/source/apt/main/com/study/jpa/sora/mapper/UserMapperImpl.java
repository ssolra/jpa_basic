package com.study.jpa.sora.mapper;

import com.study.jpa.sora.domain.entity.Team;
import com.study.jpa.sora.domain.entity.User;
import com.study.jpa.sora.dto.TeamNameDTO;
import com.study.jpa.sora.dto.UserDTO;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setCreatedDate( dto.getCreatedDate() );
        user.setModifiedDate( dto.getModifiedDate() );
        user.setId( dto.getId() );
        user.setName( dto.getName() );
        user.setAge( dto.getAge() );
        user.setGrade( dto.getGrade() );
        user.setTeam( teamNameDTOToTeam( dto.getTeam() ) );

        return user;
    }

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( entity.getId() );
        userDTO.setName( entity.getName() );
        userDTO.setAge( entity.getAge() );
        userDTO.setGrade( entity.getGrade() );
        userDTO.setTeam( teamToTeamNameDTO( entity.getTeam() ) );
        userDTO.setCreatedDate( entity.getCreatedDate() );
        userDTO.setModifiedDate( entity.getModifiedDate() );

        return userDTO;
    }

    @Override
    public List<User> toEntity(List<UserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserDTO userDTO : dtoList ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toDto(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    protected Team teamNameDTOToTeam(TeamNameDTO teamNameDTO) {
        if ( teamNameDTO == null ) {
            return null;
        }

        Team team = new Team();

        team.setName( teamNameDTO.getName() );

        return team;
    }

    protected TeamNameDTO teamToTeamNameDTO(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamNameDTO teamNameDTO = new TeamNameDTO();

        teamNameDTO.setName( team.getName() );

        return teamNameDTO;
    }
}
