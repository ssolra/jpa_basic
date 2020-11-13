package com.study.jpa.sora.mapper;

import com.study.jpa.sora.domain.entity.User;
import com.study.jpa.sora.dto.UserSaveDTO;
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
public class UserSaveMapperImpl implements UserSaveMapper {

    @Override
    public User toEntity(UserSaveDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setName( dto.getName() );
        user.setAge( dto.getAge() );
        user.setGrade( dto.getGrade() );

        return user;
    }

    @Override
    public UserSaveDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserSaveDTO userSaveDTO = new UserSaveDTO();

        userSaveDTO.setId( entity.getId() );
        userSaveDTO.setName( entity.getName() );
        userSaveDTO.setAge( entity.getAge() );
        userSaveDTO.setGrade( entity.getGrade() );

        return userSaveDTO;
    }

    @Override
    public List<User> toEntity(List<UserSaveDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserSaveDTO userSaveDTO : dtoList ) {
            list.add( toEntity( userSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<UserSaveDTO> toDto(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserSaveDTO> list = new ArrayList<UserSaveDTO>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }
}
