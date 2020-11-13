package com.study.jpa.sora.domain.repository;

import com.study.jpa.sora.domain.entity.Team;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Interface Team repository.
 *
 * @author [이소라]
 * @since 2020. 11. 6. 오전 10:01:37
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

    /**
     * Find by delete yn list.
     *
     * @param deleteYn the delete yn
     * @param pageable the pageable
     * @return the list
     * @author [이소라]
     * @implNote [전체 조회(삭제되지 않은 데이터)]
     * @since 2020. 11. 6. 오전 9:33:46
     */
    List<Team> findByDeleteYn(String deleteYn, Pageable pageable);

    /**
     * Find by delete yn list.
     *
     * @param id       the id
     * @param deleteYn the delete yn
     * @return the list
     * @author [이소라]
     * @implNote [id로 조회(삭제되지 않은 데이터)]
     * @since 2020. 11. 6. 오전 9:33:46
     */
    Team findByIdAndDeleteYn(String id, String deleteYn);
}
