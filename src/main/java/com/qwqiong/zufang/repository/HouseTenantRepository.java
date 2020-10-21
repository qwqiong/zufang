package com.qwqiong.zufang.repository;

import com.qwqiong.zufang.entity.HouseTenant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 租户
 */
@Repository
public interface HouseTenantRepository extends JpaRepository<HouseTenant, Integer> {

	@Query(value = "select h from HouseTenant h where "
			+"(:rentStartDate is null or :rentStartDate = '' or h.rentStartDate >=:rentStartDate )"
			+"and (:rentEndDate is null or :rentEndDate = '' or h.rentEndDate <=:rentEndDate)")
	List<HouseTenant> queryHouseTenantList(@Param("rentStartDate") String rentStartDate, @Param("rentEndDate") String rentEndDate);
	

}
