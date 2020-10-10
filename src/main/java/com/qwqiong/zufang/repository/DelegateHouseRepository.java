package com.qwqiong.zufang.repository;

import com.qwqiong.zufang.entity.DelegateHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 房源
 */
@Repository
public interface DelegateHouseRepository extends JpaRepository<DelegateHouse, Integer> {
}
