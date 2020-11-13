package com.study.jpa.sora.domain.repository;

import com.study.jpa.sora.domain.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Interface User repository.
 *
 * @author [이소라]
 * @since 2020. 11. 6. 오전 9:33:46
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    /**
     * Find by delete yn list.
     *
     * @param deleteYn the delete yn
     * @return the list
     * @author [이소라]
     * @implNote [전체 조회(삭제되지 않은 데이터)]
     * @since 2020. 11. 6. 오후 12:21:40
     */
    List<User> findByDeleteYn(String deleteYn);

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
    List<User> findByDeleteYn(String deleteYn, Pageable pageable);

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
    User findByIdAndDeleteYn(String id, String deleteYn);
}
