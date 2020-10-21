package com.qwqiong.zufang.repository;

import com.qwqiong.zufang.entity.HouseSource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 房源
 */
@Repository
public interface HouseSourceRepository extends JpaRepository<HouseSource, Integer> {

	 /**
     * 查询房源列表信息
     * @param role
     * @param id
     * @return
     */
	@Query(value = "select h from HouseSource h where "
			+"(:village is null or :village = '' or h.village like concat('%',:village,'%'))"
			+"and (:zoneCount is null or :zoneCount = '' or h.zoneCount like concat('%',:zoneCount,'%'))"
			+"and (:buildingNo is null or :buildingNo = '' or h.buildingNo like concat('%',:buildingNo,'%'))")
	List<HouseSource> queryHouseSourceList(@Param("village") String village,@Param("zoneCount") String zoneCount,@Param("buildingNo") String buildingNo);
}