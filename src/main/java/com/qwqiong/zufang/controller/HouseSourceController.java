package com.qwqiong.zufang.controller;

import com.qwqiong.zufang.entity.HouseSource;
import com.qwqiong.zufang.entity.ResultData;
import com.qwqiong.zufang.service.HouseSourceService;
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
@RequestMapping("/houseSource")
@Slf4j
public class HouseSourceController {
    @Autowired
    private HouseSourceService houseSourceService;
    /**
     * 房源列表
     * @return
     */
    @GetMapping("/list")
    public ModelAndView test(){
        return new ModelAndView("/houseSourceList");
    }
    /**
     * 房源列表
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(HttpServletRequest request, Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        HouseSource houseSource = houseSourceService.detail(id);
        model.addAttribute("houseSource",houseSource);
        return new ModelAndView("/houseSourceDetail");
    }
    /**
     * 删除房源列表
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultData delete(Integer id){
        houseSourceService.delete(id);
        return ResultData.success();
    }
    /**
     * 房源列表
     * @return
     */
    @PostMapping("/items")
    public ModelAndView items(Model model){
        List<HouseSource> items =  houseSourceService.items();
        model.addAttribute("items",items);
        return new ModelAndView("/houseSourceItem");
    }

    /**
     * 房源列表
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultData add(HouseSource house){
        houseSourceService.add(house);
        log.info("============="+house.toString());
        return ResultData.success();
    }
}
