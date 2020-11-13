package com.study.jpa.sora.mapper;

import com.study.jpa.sora.domain.entity.User;
import com.study.jpa.sora.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
