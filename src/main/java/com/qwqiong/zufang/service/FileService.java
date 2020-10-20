package com.qwqiong.zufang.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;

@Service
public class FileService {
    /**
     * 根路径
     */
    @Value("${fms.baseDir}")
    private String baseDir;
    /**
     * 文件下载
     *  @param fileName
     * @param isOnline
     * @param response
     */
    public void downLoad(String fileName, Integer isOnline, HttpServletRequest request, HttpServletResponse response) throws IOException {
        File f = new File(baseDir+fileName);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;
        response.reset(); // 非常重要
        if (0 == isOnline) { // 在线打开方式
            URL u = new URL("file:///" + fileName);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());

        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }
}
