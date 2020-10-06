package com.qwqiong.zufang.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/house")
public class HouseController {
    /**
     * 房源列表
     * @return
     */
    @GetMapping("/list")
    public ModelAndView test(){
        return new ModelAndView("/houseList");
    }
}
