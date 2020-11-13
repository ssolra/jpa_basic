package com.study.jpa.sora.service;

import com.study.jpa.sora.domain.entity.Team;
import com.study.jpa.sora.domain.repository.TeamRepository;
import com.study.jpa.sora.domain.repository.UserRepository;
import com.study.jpa.sora.dto.TeamDTO;
import com.study.jpa.sora.dto.TeamIdDTO;
import com.study.jpa.sora.dto.TeamSaveDTO;
import com.study.jpa.sora.mapper.TeamMapper;
import com.study.jpa.sora.mapper.TeamSaveMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The Class Team service.
 *
 * @author [이소라]
 * @since 2020. 11. 6. 오후 12:22:25
 */
@AllArgsConstructor
@Service
public class TeamService {
    /**
     * The Team repository
     */
    private TeamRepository teamRepository;
    /**
     * The User repository
     */
    private UserRepository userRepository;
    /**
     * The Team mapper
     */
    private TeamMapper teamMapper;
    /**
     * The Team save mapper
     */
    private TeamSaveMapper teamSaveMapper;

    /**
     * Get team list list.
     *
     * @param pageable the pageable
     * @return the list
     * @author [이소라]
     * @implNote [팀 목록 조회]
     * @since 2020. 11. 6. 오후 12:22:25
     */
    public List<TeamDTO> getTeamList(Pageable pageable){
        Team team = new Team();
        team.setDeleteYn("N");
        //검색조건 추가하기
        Example<Team> example = Example.of(team);
        Page<Team> teamEntity = teamRepository.findAll(example, pageable);
        Page<TeamDTO> teamDto = new PageImpl<>(teamMapper.toDto(teamEntity.getContent()), pageable, teamEntity.getTotalElements());
        List<TeamDTO> teamList = teamDto.getContent();

        return teamList;
    }

    /**
     * Get team info team dto.
     *
     * @param teamIdDTO the team id dto
     * @return the team dto
     * @author [이소라]
     * @implNote [팀 상세 정보 조회]
     * @since 2020. 11. 6. 오후 12:22:25
     */
    public TeamDTO getTeamInfo(TeamIdDTO teamIdDTO){
        String id = teamIdDTO.getId();
        TeamDTO teamDto = new TeamDTO();

        if(teamRepository.findByIdAndDeleteYn(id, "N") != null){
            Optional<Team> teamInfo = teamRepository.findById(id);
            Team team = new Team();
            if (teamInfo.isPresent()) {
                team = teamInfo.get();
            }
            teamDto = teamMapper.toDto(team);
        }
        return teamDto;
    }

    /**
     * Save team.
     *
     * @param teamSaveDto the team save dto
     * @author [이소라]
     * @implNote [팀 정보 등록]
     * @since 2020. 11. 6. 오후 12:22:25
     */
    public void saveTeam(TeamSaveDTO teamSaveDto) {
        Team team = teamSaveMapper.toEntity(teamSaveDto);
        teamRepository.save(team);
    }

    /**
     * Apply team.
     *
     * @param teamSaveDto the team save dto
     * @author [이소라]
     * @implNote [팀 정보 수정]
     * @since 2020. 11. 6. 오후 12:22:25
     */
    public void applyTeam(TeamSaveDTO teamSaveDto) {
        String id = teamSaveDto.getId();
        if(teamRepository.findByIdAndDeleteYn(id, "N") != null){
            Team team = teamRepository.getOne(id);
            if(teamSaveDto.getName() != null && !"".equals(teamSaveDto.getName())){
                team.setName(teamSaveDto.getName());
            }
            if(teamSaveDto.getScore() != null && !"".equals(teamSaveDto.getScore())){
                team.setScore(teamSaveDto.getScore());
            }
            teamRepository.save(team);
        }
    }

    /**
     * Delete team.
     *
     * @param teamIdDTO the team id dto
     * @author [이소라]
     * @implNote [팀 정보 삭제]
     * @since 2020. 11. 6. 오후 12:22:25
     */
    public void deleteTeam(TeamIdDTO teamIdDTO){
        String id = teamIdDTO.getId();
        if(userRepository.findByDeleteYn("N").size()>0){
            return;
        }
        if(teamRepository.findByIdAndDeleteYn(id, "N") != null){
            Team team = teamRepository.getOne(id);
            team.setDeleteYn("Y");
            teamRepository.save(team);
        }
    }
}
