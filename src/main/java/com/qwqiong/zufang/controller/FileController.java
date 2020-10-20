package com.qwqiong.zufang.controller;

import com.qwqiong.zufang.entity.ResultData;
import com.qwqiong.zufang.service.FileService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件相关Controller
 */
@RestController
@RequestMapping("/file")
@Slf4j
@Validated
public class FileController {
    @Autowired
    private FileService fileService;
    /**
     * 下载文件
     * @param fileName
     * @return
     */
    @RequestMapping("/downLoad")
    public ResultData fileDownLoad(@NotNull String fileName, @NotNull Integer isOnline, HttpServletRequest request, HttpServletResponse response) {
        try {
            fileService.downLoad(fileName,isOnline,request,response);
        }catch (Exception e){
            log.error("downLoad失败",e);
            return ResultData.fail();
        }
        return ResultData.success();
    }
}
