package com.qwqiong.zufang.service;

import com.qwqiong.zufang.entity.HouseSource;
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
    public List<HouseSource> items() {
        List<HouseSource> sources = houseSourceRepository.findAll();
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
}
