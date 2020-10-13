package com.qwqiong.zufang.repository;

import com.qwqiong.zufang.entity.CustomSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 房源
 */
@Repository
public interface CustomSourceRepository extends JpaRepository<CustomSource, Integer> {

    /**
     * 查询客户信息列表
     * @param role
     * @param id
     * @return
     */
    @Query("select c from CustomSource c where 'boss' = :role or c.agentId = :id")
    List<CustomSource> findCustomSource(@Param("role") String role, @Param("id") Integer id);
}
