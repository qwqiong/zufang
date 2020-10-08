package com.qwqiong.zufang.controller;

import com.qwqiong.zufang.entity.ResultData;
import com.qwqiong.zufang.entity.User;
import com.qwqiong.zufang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/loginPage")
    public ModelAndView test(){
        return new ModelAndView("/loginPage");
    }
    /**
     * 登录
     */
    @RequestMapping("/login")
    public ResultData login(HttpServletResponse response, HttpServletRequest request, String username, String password) throws IOException {
        User user = userService.findUser(username,password);
        if(Objects.isNull(user)){
            response.sendRedirect("/");
        }else {
            log.info("login===============");
            request.getSession().setAttribute("userName",username);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/index/index");
        }
        return null;
    }

}
