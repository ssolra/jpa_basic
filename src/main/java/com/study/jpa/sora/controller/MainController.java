package com.study.jpa.sora.controller;

import com.study.jpa.sora.dto.*;
import com.study.jpa.sora.service.TeamService;
import com.study.jpa.sora.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Class Main controller.
 *
 * @author [이소라]
 * @since 2020. 11. 3. 오후 6:12:21
 */
@RestController
@AllArgsConstructor
public class MainController {
    /**
     * The User service
     */
    private UserService userService;

    /**
     * The Team service
     */
    private TeamService teamService;

    /**
     * Home page string.
     *
     * @return the string
     * @author [이소라]
     * @implNote [method 설명]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @RequestMapping(value = "/")
    public String homePage() {

        return "JPA TEST 중 입니다!";
    }

    /**
     * Gets user list.
     *
     * @param pageable the pageable
     * @return the user list
     * @throws Exception the exception
     * @author [이소라]
     * @implNote [회원 목록 조회]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @GetMapping(value="/user/list", produces="application/json")
    public List<UserDTO> getUserList(Pageable pageable) {
        List<UserDTO> userList = userService.getUserList(pageable);
        return userList;
    }

    /**
     * Gets user info.
     *
     * @param userIdDTO the user id dto
     * @return the user info
     * @author [이소라]
     * @implNote [회원 상세 정보 조회]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @GetMapping(value="/user/detail/{id}", produces="application/json")
    public UserDTO getUserInfo(UserIdDTO userIdDTO) {
        UserDTO userInfo = userService.getUserInfo(userIdDTO);
        return userInfo;
    }

    /**
     * Save user.
     *
     * @param userSaveDTO the user save dto
     * @return the string
     * @author [이소라]
     * @implNote [회원 정보 등록]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @PostMapping("/user/create")
    public String saveUser(UserSaveDTO userSaveDTO) {
        userService.saveUser(userSaveDTO);
        return "저장되었습니다.";
    }

    /**
     * Apply user.
     *
     * @param userSaveDTO the user save dto
     * @return the string
     * @author [이소라]
     * @implNote [회원 정보 수정]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @RequestMapping(value="/user/modify/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String applyUser(UserSaveDTO userSaveDTO) {
        userService.applyUser(userSaveDTO);
        return "수정되었습니다.";
    }

    /**
     * Delete user.
     *
     * @param userIdDTO the user id dto
     * @return the string
     * @author [이소라]
     * @implNote [회원 정보 삭제]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @PostMapping("/user/remove/{id}")
    public String deleteUser(UserIdDTO userIdDTO) {
        userService.deleteUser(userIdDTO);
        return "삭제되었습니다.";
    }

    /**
     * Gets team list.
     *
     * @param pageable the pageable
     * @return the team list
     * @throws Exception the exception
     * @author [이소라]
     * @implNote [팀 목록 조회]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @GetMapping(value="/team/list", produces="application/json")
    public List<TeamDTO> getTeamList(Pageable pageable) {
        List<TeamDTO> teamList = teamService.getTeamList(pageable);
        return teamList;
    }

    /**
     * Gets team info.
     *
     * @param teamIdDTO the team id dto
     * @return the team info
     * @author [이소라]
     * @implNote [팀 상세 정보 조회]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @GetMapping(value="/team/detail/{id}", produces="application/json")
    public TeamDTO getTeamInfo(TeamIdDTO teamIdDTO) {
        TeamDTO teamInfo = teamService.getTeamInfo(teamIdDTO);
        return teamInfo;
    }

    /**
     * Save team.
     *
     * @param teamSaveDTO the team save dto
     * @return the string
     * @author [이소라]
     * @implNote [팀 정보 등록]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @PostMapping("/team/create")
    public String saveTeam(TeamSaveDTO teamSaveDTO) {
        teamService.saveTeam(teamSaveDTO);
        return "저장되었습니다.";
    }

    /**
     * Apply team.
     *
     * @param teamSaveDTO the team save dto
     * @return the string
     * @author [이소라]
     * @implNote [팀 정보 수정]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @RequestMapping(value="/team/modify/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String applyTeam(@PathVariable("id") TeamSaveDTO teamSaveDTO) {
        teamService.applyTeam(teamSaveDTO);
        return "수정되었습니다.";
    }

    /**
     * Delete team.
     *
     * @param teamIdDTO the team id dto
     * @return the string
     * @throws Exception the exception
     * @author [이소라]
     * @implNote [팀 정보 삭제]
     * @since 2020. 11. 3. 오후 6:12:21
     */
    @PostMapping("/team/remove/{id}")
    public String deleteTeam(TeamIdDTO teamIdDTO) throws Exception{
        teamService.deleteTeam(teamIdDTO);
        return "삭제되었습니다.";
    }
}
