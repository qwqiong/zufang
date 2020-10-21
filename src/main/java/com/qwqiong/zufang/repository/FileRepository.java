package com.qwqiong.zufang.repository;

import com.qwqiong.zufang.entity.SiteCFile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 图片
 */
@Repository
public interface FileRepository extends JpaRepository<SiteCFile, Integer> {

	@Query("select f from SiteCFile f where f.objectId = :id and remove =0")
	List<SiteCFile> getSiteCFileByObjectId(@Param("id") String id);

	@Query("delete from SiteCFile f where f.id = :id")
	public void deleteFileById(@Param("id") Integer id);

}
