package com.qwqiong.zufang.controller;

import com.qwqiong.zufang.entity.HouseTenant;
import com.qwqiong.zufang.entity.ResultData;
import com.qwqiong.zufang.service.HouseTenantService;
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
@RequestMapping("/houseTenant")
@Slf4j
public class HouseTenantController {
    @Autowired
    private HouseTenantService houseTenantService;
    /**
     * 租户信息
     * @return
     */
    @GetMapping("/list")
    public ModelAndView test(){
        return new ModelAndView("/houseTenantList");
    }

    /**
     * 租户列表
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(HttpServletRequest request, Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        HouseTenant houseTenant = houseTenantService.detail(id);
        model.addAttribute("houseTenant",houseTenant);
        return new ModelAndView("/houseTenantDetail");
    }

    /**
     * 增加租户
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultData add(HouseTenant houseTenant){
        houseTenantService.add(houseTenant);
        return ResultData.success();
    }
    /**
     * 删除租户
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultData delete(Integer id){
        houseTenantService.delete(id);
        return ResultData.success();
    }
    /**
     * 租户列表
     * @return
     */
    @PostMapping("/items")
    public ModelAndView items(Model model,HouseTenant houseTenant){
        List<HouseTenant> items =  houseTenantService.items(houseTenant);
        model.addAttribute("items",items);
        return new ModelAndView("/houseTenantItem");
    }
}
