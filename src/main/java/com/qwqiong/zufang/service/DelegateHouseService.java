package com.qwqiong.zufang.service;

import com.qwqiong.zufang.entity.DelegateHouse;
import com.qwqiong.zufang.repository.DelegateHouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 委托房源
 */
@Slf4j
@Service
public class DelegateHouseService {
    @Autowired
    private DelegateHouseRepository delegateHouseRepository;

    /**
     * 增加客源
     * @param house
     */
    public void add(DelegateHouse house) {
        delegateHouseRepository.save(house);
    }

    /**
     * 客源列表
     * @return
     */
    public List<DelegateHouse> items() {
        return delegateHouseRepository.findAll();
    }

    /**
     * 删除客源
     * @param id
     */
    public void delete(Integer id) {
        delegateHouseRepository.deleteById(id);
    }

    /**
     * 客源详情
     * @param id
     * @return
     */
    public DelegateHouse detail(Integer id) {
        return delegateHouseRepository.findById(id).get();
    }
}
