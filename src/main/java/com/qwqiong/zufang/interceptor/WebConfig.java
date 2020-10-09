package com.qwqiong.zufang.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author qiaowenqiong
 * @Date 2019/3/8 下午3:02
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/houseSource/**")
                .addPathPatterns("/customSource/**")
                .addPathPatterns("/index/**")
                .addPathPatterns("");
    }
}
