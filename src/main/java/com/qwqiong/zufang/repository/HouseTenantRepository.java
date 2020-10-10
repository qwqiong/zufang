package com.qwqiong.zufang.repository;

import com.qwqiong.zufang.entity.HouseTenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 租户
 */
@Repository
public interface HouseTenantRepository extends JpaRepository<HouseTenant, Integer> {
}
