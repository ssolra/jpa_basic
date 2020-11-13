package com.study.jpa.sora.service;

import com.study.jpa.sora.domain.entity.Team;
import com.study.jpa.sora.domain.entity.User;
import com.study.jpa.sora.domain.repository.TeamRepository;
import com.study.jpa.sora.domain.repository.UserRepository;
import com.study.jpa.sora.dto.UserDTO;
import com.study.jpa.sora.dto.UserIdDTO;
import com.study.jpa.sora.dto.UserSaveDTO;
import com.study.jpa.sora.mapper.UserMapper;
import com.study.jpa.sora.mapper.UserSaveMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The Class User service.
 *
 * @author [이소라]
 * @since 2020. 11. 6. 오후 12:22:29
 */
@AllArgsConstructor
@Service
public class UserService {
    /**
     * The User repository
     */
    private UserRepository userRepository;
    /**
     * The Team repository
     */
    private TeamRepository teamRepository;
    /**
     * The User mapper
     */
    private UserMapper userMapper;
    /**
     * The User save mapper
     */
    private UserSaveMapper userSaveMapper;

    /**
     * Get user list list.
     *
     * @param pageable the pageable
     * @return the list
     * @author [이소라]
     * @implNote [회원 목록 조회]
     * @since 2020. 11. 6. 오후 12:22:29
     */
    public List<UserDTO> getUserList(Pageable pageable){
        User user = new User();
        user.setDeleteYn("N");
        //검색조건 추가하기
        Example<User> employeeExample = Example.of(user);
        Page<User> userEntity = userRepository.findAll(employeeExample, pageable);
        Page<UserDTO> userDto = new PageImpl<>(userMapper.toDto(userEntity.getContent()), pageable, userEntity.getTotalElements());
        List<UserDTO> userList = userDto.getContent();

        //List<User> userEntity = userRepository.findByDeleteYn("N",pageable);
        //List<UserDTO> userList = userMapper.toDto(userEntity);

        return userList;
    }

    /**
     * Get user info user dto.
     *
     * @param userIdDto the user id dto
     * @return the user dto
     * @author [이소라]
     * @implNote [회원 상세 정보 조회]
     * @since 2020. 11. 6. 오후 12:22:29
     */
    public UserDTO getUserInfo(UserIdDTO userIdDto){
        String id = userIdDto.getId();
        UserDTO userDto = new UserDTO();

        //if(userRepository.existsById(id)) {
        if(userRepository.findByIdAndDeleteYn(id, "N") != null){
            Optional<User> userInfo = userRepository.findById(id);
            User user = new User();
            if (userInfo.isPresent()) {
                user = userInfo.get();
            }
            userDto = userMapper.toDto(user);
        }
        return userDto;
    }

    /**
     * Save user.
     *
     * @param userSaveDto the user save dto
     * @author [이소라]
     * @implNote [회원 정보 등록]
     * @since 2020. 11. 6. 오후 12:22:29
     */
    public void saveUser(UserSaveDTO userSaveDto) {
        User user = userSaveMapper.toEntity(userSaveDto);
        String teamId = userSaveDto.getTeamId();
        if(teamRepository.existsById(teamId)){
            Team team = teamRepository.getOne(teamId);
            user.setTeam(team);
        }

        userRepository.save(user);
    }

    /**
     * Apply user.
     *
     * @param userSaveDto the user save dto
     * @author [이소라]
     * @implNote [회원 정보 수정]
     * @since 2020. 11. 6. 오후 12:22:29
     */
    public void applyUser(UserSaveDTO userSaveDto) {
        String id = userSaveDto.getId();
        //if(userRepository.existsById(id)) {
        if(userRepository.findByIdAndDeleteYn(id, "N") != null){
            User user = userRepository.getOne(id);
            if(userSaveDto.getName() != null && !"".equals(userSaveDto.getName())){
                user.setName(userSaveDto.getName());
            }
            if(userSaveDto.getAge() != null && !"".equals(userSaveDto.getAge())){
                user.setAge(userSaveDto.getAge());
            }
            if(userSaveDto.getGrade() != null && !"".equals(userSaveDto.getGrade())){
                user.setGrade(userSaveDto.getGrade());
            }
            if(userSaveDto.getTeamId() != null && !"".equals(userSaveDto.getTeamId())){
                String teamId = userSaveDto.getTeamId();
                if(teamRepository.existsById(teamId)){
                    Team team = teamRepository.getOne(teamId);
                    user.setTeam(team);
                }
            }
            userRepository.save(user);
        }
    }

    /**
     * Delete user.
     *
     * @param userIdDto the user id dto
     * @author [이소라]
     * @implNote [회원 정보 삭제]
     * @since 2020. 11. 6. 오후 12:22:29
     */
    public void deleteUser(UserIdDTO userIdDto) {
        String id = userIdDto.getId();
        //if(userRepository.existsById(id)) {
        if(userRepository.findByIdAndDeleteYn(id, "N") != null){
            User user = userRepository.getOne(id);
            user.setDeleteYn("Y");
            userRepository.save(user);
        }
    }
}
