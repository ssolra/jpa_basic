package com.study.jpa.sora.mapper;

import com.study.jpa.sora.domain.entity.Team;
import com.study.jpa.sora.domain.entity.User;
import com.study.jpa.sora.dto.TeamDTO;
import com.study.jpa.sora.dto.UserNameDTO;
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
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Team toEntity(TeamDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Team team = new Team();

        team.setCreatedDate( dto.getCreatedDate() );
        team.setModifiedDate( dto.getModifiedDate() );
        team.setId( dto.getId() );
        team.setName( dto.getName() );
        team.setScore( dto.getScore() );
        team.setUsers( userNameDTOListToUserList( dto.getUsers() ) );

        return team;
    }

    @Override
    public TeamDTO toDto(Team entity) {
        if ( entity == null ) {
            return null;
        }

        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setId( entity.getId() );
        teamDTO.setName( entity.getName() );
        teamDTO.setScore( entity.getScore() );
        teamDTO.setUsers( userListToUserNameDTOList( entity.getUsers() ) );
        teamDTO.setCreatedDate( entity.getCreatedDate() );
        teamDTO.setModifiedDate( entity.getModifiedDate() );

        return teamDTO;
    }

    @Override
    public List<Team> toEntity(List<TeamDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Team> list = new ArrayList<Team>( dtoList.size() );
        for ( TeamDTO teamDTO : dtoList ) {
            list.add( toEntity( teamDTO ) );
        }

        return list;
    }

    @Override
    public List<TeamDTO> toDto(List<Team> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TeamDTO> list = new ArrayList<TeamDTO>( entityList.size() );
        for ( Team team : entityList ) {
            list.add( toDto( team ) );
        }

        return list;
    }

    protected User userNameDTOToUser(UserNameDTO userNameDTO) {
        if ( userNameDTO == null ) {
            return null;
        }

        User user = new User();

        user.setName( userNameDTO.getName() );

        return user;
    }

    protected List<User> userNameDTOListToUserList(List<UserNameDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<User> list1 = new ArrayList<User>( list.size() );
        for ( UserNameDTO userNameDTO : list ) {
            list1.add( userNameDTOToUser( userNameDTO ) );
        }

        return list1;
    }

    protected UserNameDTO userToUserNameDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserNameDTO userNameDTO = new UserNameDTO();

        userNameDTO.setName( user.getName() );

        return userNameDTO;
    }

    protected List<UserNameDTO> userListToUserNameDTOList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserNameDTO> list1 = new ArrayList<UserNameDTO>( list.size() );
        for ( User user : list ) {
            list1.add( userToUserNameDTO( user ) );
        }

        return list1;
    }
}
