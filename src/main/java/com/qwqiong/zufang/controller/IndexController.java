package com.qwqiong.zufang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
@Slf4j
public class IndexController {
    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }
}
