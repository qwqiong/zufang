package com.qwqiong.zufang.controller;


import com.qwqiong.zufang.entity.CustomSource;
import com.qwqiong.zufang.entity.DelegateHouse;
import com.qwqiong.zufang.entity.ResultData;
import com.qwqiong.zufang.service.CustomSourceService;
import com.qwqiong.zufang.service.DelegateHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/delegateHouse")
@Slf4j
public class DelegateHouseController {
    @Autowired
    private DelegateHouseService delegateHouseService;
    /**
     * 客源列表
     * @return
     */
    @GetMapping("/list")
    public ModelAndView test(){
        return new ModelAndView("/delegateHouseList");
    }

    /**
     * 房源列表
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(HttpServletRequest request, Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        DelegateHouse delegateHouse = delegateHouseService.detail(id);
        model.addAttribute("delegateHouse",delegateHouse);
        return new ModelAndView("/delegateHouseDetail");
    }

    /**
     * 增加客源
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultData add(DelegateHouse delegateHouse){
        delegateHouseService.add(delegateHouse);
        return ResultData.success();
    }
    /**
     * 删除客源列表
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultData delete(Integer id){
        delegateHouseService.delete(id);
        return ResultData.success();
    }
    /**
     * 客源列表
     * @return
     */
    @PostMapping("/items")
    public ModelAndView items(Model model){
        List<DelegateHouse> items =  delegateHouseService.items();
        model.addAttribute("items",items);
        return new ModelAndView("/delegateHouseItem");
    }
}
