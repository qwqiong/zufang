package com.qwqiong.zufang.service;

import com.qwqiong.zufang.entity.CustomSource;
import com.qwqiong.zufang.repository.CustomSourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客源
 */
@Slf4j
@Service
public class CustomSourceService {
    @Autowired
    private CustomSourceRepository customSourceRepository;

    /**
     * 增加客源
     * @param house
     */
    public void add(CustomSource house) {
        customSourceRepository.save(house);
    }

    /**
     * 客源列表
     * @return
     */
    public List<CustomSource> items() {
        return customSourceRepository.findAll();
    }

    /**
     * 删除客源
     * @param id
     */
    public void delete(Integer id) {
        customSourceRepository.deleteById(id);
    }

    /**
     * 客源详情
     * @param id
     * @return
     */
    public CustomSource detail(Integer id) {
        return customSourceRepository.findById(id).get();
    }
}
