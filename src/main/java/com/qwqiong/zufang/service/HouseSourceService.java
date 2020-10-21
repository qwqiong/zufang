package com.qwqiong.zufang.service;

import com.qwqiong.zufang.entity.HouseSource;
import com.qwqiong.zufang.entity.SiteCFile;
import com.qwqiong.zufang.repository.FileRepository;
import com.qwqiong.zufang.repository.HouseSourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 房源
 */
@Slf4j
@Service
public class HouseSourceService {
    @Autowired
    private HouseSourceRepository houseSourceRepository;
    @Autowired
    private FileRepository fileRepository;

    /**
     * 新增房源
     * @param house
     */
    public void add(HouseSource house) {
        houseSourceRepository.save(house);
    }

    /**
     * 房源列表
     */
    public List<HouseSource> items(HouseSource houseSource) {
        List<HouseSource> sources = houseSourceRepository.queryHouseSourceList(houseSource.getVillage(),houseSource.getZoneCount(),houseSource.getBuildingNo());
        return sources;
    }

    /**
     * 删除房源
     * @param id
     */
    public void delete(Integer id) {
        houseSourceRepository.deleteById(id);
    }

    /**
     * 房源详情
     * @param id
     * @return
     */
    public HouseSource detail(Integer id) {
       return houseSourceRepository.findById(id).get();
    }

    /**
     * 保存附件
    * <p>Title: HouseSourceService.java</p>  
    * <p>Description: </p>  
    * @param 
    * @return 
    * @author liuchen 
    * @date 2020年10月15日
     */
	public void saveFile(SiteCFile sitefile) {
		fileRepository.save(sitefile);
	}
	
	/**
     * 房源详情
     * @param id
     * @return
     */
    public SiteCFile getFileDetail(Integer id) {
       return fileRepository.findById(id).get();
    }
    
    /**
     * 附件列表
     */
    public List<SiteCFile> getSiteCFileByObjectId(String id) {
        List<SiteCFile> fileList = fileRepository.getSiteCFileByObjectId(id);
        return fileList;
    }

	public void deleteFileById(Integer id) {
		this.fileRepository.deleteById(id);
	}
	

}
