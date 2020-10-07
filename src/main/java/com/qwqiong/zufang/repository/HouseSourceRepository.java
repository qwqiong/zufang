package com.qwqiong.zufang.repository;

import com.qwqiong.zufang.entity.HouseSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 房源
 */
@Repository
public interface HouseSourceRepository extends JpaRepository<HouseSource, Integer> {
}
