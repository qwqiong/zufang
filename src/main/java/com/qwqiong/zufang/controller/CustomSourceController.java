package com.qwqiong.zufang.controller;

import com.qwqiong.zufang.entity.CustomSource;
import com.qwqiong.zufang.entity.HouseSource;
import com.qwqiong.zufang.entity.ResultData;
import com.qwqiong.zufang.service.CustomSourceService;
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
@RequestMapping("/customSource")
@Slf4j
public class CustomSourceController {

    @Autowired
    private CustomSourceService customSourceService;
    /**
     * 客源列表
     * @return
     */
    @GetMapping("/list")
    public ModelAndView test(){
        return new ModelAndView("/customSourceList");
    }

    /**
     * 房源列表
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(HttpServletRequest request, Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        CustomSource customSource = customSourceService.detail(id);
        model.addAttribute("customSource",customSource);
        return new ModelAndView("/customSourceDetail");
    }

    /**
     * 增加客源
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultData add(CustomSource house){
        customSourceService.add(house);
        log.info("============="+house.toString());
        return ResultData.success();
    }
    /**
     * 删除客源列表
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultData delete(Integer id){
        customSourceService.delete(id);
        return ResultData.success();
    }
    /**
     * 客源列表
     * @return
     */
    @PostMapping("/items")
    public ModelAndView items(Model model){
        List<CustomSource> items =  customSourceService.items();
        model.addAttribute("items",items);
        return new ModelAndView("/customSourceItem");
    }
}
