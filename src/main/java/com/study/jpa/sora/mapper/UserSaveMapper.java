package com.study.jpa.sora.mapper;

import com.study.jpa.sora.domain.entity.User;
import com.study.jpa.sora.dto.UserSaveDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserSaveMapper extends EntityMapper<UserSaveDTO, User> {
}
