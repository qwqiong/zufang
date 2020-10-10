package com.qwqiong.zufang.service;

import com.qwqiong.zufang.entity.DelegateHouse;
import com.qwqiong.zufang.entity.HouseTenant;
import com.qwqiong.zufang.repository.HouseTenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 委托房源
 */
@Slf4j
@Service
public class HouseTenantService {
    @Autowired
    private HouseTenantRepository houseTenantRepository;

    /**
     * 增加客源
     * @param house
     */
    public void add(HouseTenant house) {
        houseTenantRepository.save(house);
    }

    /**
     * 客源列表
     * @return
     */
    public List<HouseTenant> items() {
        return houseTenantRepository.findAll();
    }

    /**
     * 删除客源
     * @param id
     */
    public void delete(Integer id) {
        houseTenantRepository.deleteById(id);
    }

    /**
     * 客源详情
     * @param id
     * @return
     */
    public HouseTenant detail(Integer id) {
        return houseTenantRepository.findById(id).get();
    }
}
