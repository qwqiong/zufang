package com.qwqiong.zufang.repository;

import com.qwqiong.zufang.entity.DelegateHouse;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 房源
 */
@Repository
public interface DelegateHouseRepository extends JpaRepository<DelegateHouse, Integer> {

	@Query(value = "select h from DelegateHouse h where "
			+"(:rentStartDate is null or :rentStartDate = '' or h.rentStartDate >=:rentStartDate )"
			+"and (:rentEndDate is null or :rentEndDate = '' or h.rentEndDate <=:rentEndDate)")
	List<DelegateHouse> queryDelegateHouseList(@Param("rentStartDate") String rentStartDate, @Param("rentEndDate") String rentEndDate);
}
