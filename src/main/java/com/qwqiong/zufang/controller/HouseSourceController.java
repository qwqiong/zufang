package com.qwqiong.zufang.controller;

import com.qwqiong.zufang.entity.HouseSource;
import com.qwqiong.zufang.entity.ResultData;
import com.qwqiong.zufang.entity.SiteCFile;
import com.qwqiong.zufang.entity.User;
import com.qwqiong.zufang.repository.FileRepository;
import com.qwqiong.zufang.service.HouseSourceService;
import com.qwqiong.zufang.util.UploadUtils;

import lombok.extern.slf4j.Slf4j;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

@Controller
@RequestMapping("/houseSource")
@Slf4j
public class HouseSourceController {
    @Autowired
    private HouseSourceService houseSourceService;
    @Autowired
    private FileRepository fileRepository;
    
    /**
     * 房源列表
     * @return
     */
    @GetMapping("/list")
    public ModelAndView test(HttpServletRequest request,Model model,HouseSource houseSource){
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
        String fileIds = "";
        List<SiteCFile> fileList = houseSourceService.getSiteCFileByObjectId(id.toString());
        if(fileList !=null && fileList.size()>0){
        	for (SiteCFile siteCFile : fileList) {
        		fileIds+=siteCFile.getId()+",";
			}
        }
        if(StringUtils.hasText(fileIds)){
        	fileIds = fileIds.substring(0,fileIds.length()-1);
        }
        model.addAttribute("houseSource",houseSource);
        model.addAttribute("fileList",fileList);
        model.addAttribute("fileIds",fileIds);
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
    public ModelAndView items(HttpServletRequest request,Model model,HouseSource houseSource){
    	User user = (User) request.getSession().getAttribute("user");
        List<HouseSource> items =  houseSourceService.items(houseSource);
        model.addAttribute("items",items);
        model.addAttribute("user",user);
        return new ModelAndView("/houseSourceItem");
    }

    /**
     * 房源列表
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultData add(HttpServletRequest request,HouseSource house){
    	String fileIds = request.getParameter("fileIds");
        houseSourceService.add(house);
        List<SiteCFile> fileList = houseSourceService.getSiteCFileByObjectId(house.getId().toString());
        for (SiteCFile siteCFile : fileList) {
        	String flag = "false";
        	if(StringUtils.hasText(fileIds)){
        		String[] ids = fileIds.split(",");
        		for (String id : ids) {
        			if(siteCFile.getId().toString().equals(id)){
        				flag = "true";
        			}
        		}
        	}
        	if("false".equals(flag)){
        		houseSourceService.deleteFileById(siteCFile.getId());
        	}
		}
        if(StringUtils.hasText(fileIds)){
        	String[] ids = fileIds.split(",");
        	for (String id : ids) {
        		SiteCFile siteCFile = houseSourceService.getFileDetail(Integer.parseInt(id));
        		siteCFile.setObjectId(house.getId().toString());
        		siteCFile.setIsTemp("Y");
        		fileRepository.saveAndFlush(siteCFile);
			}
        }
        return ResultData.success();
    }
    
    /**
     * 
    * <p>Title: HouseSourceController.java</p>  
    * <p>Description:获取文件配置路径 </p>  
    * @param 
    * @return 
    * @author liuchen 
    * @date 2020年10月21日
     */
    public static String getProjectConfig(String key) {
        Properties pros = new Properties();
        String value = "";
        try {
            pros.load(new InputStreamReader(PropertiesUtil.class.getResourceAsStream("/application.yml"), "UTF-8"));
            value = pros.getProperty(key);
        } catch (Exception e) {
        return e.getMessage();
        }
        return value;
    }

    
    @RequestMapping(value = "/saveFile")
	@ResponseBody
	public HashMap<String, Object> saveFile(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("id");
		HashMap<String, Object> map =  new HashMap<String, Object>();
		// 文件保存目录URL
		String saveUrl = "/upload/";
		String savePath = getProjectConfig("filePath");
		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		// 最大文件大小
		long maxSize = 2000000000;
		String dirName = "image";
		// 创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		String fileName = file.getOriginalFilename();
		String newFileName = "";
		if (file !=null) {
			// 检查文件大小
			if (file.getSize() > maxSize) {
				map.put("msg", "上传文件大小超过限制。");
				map.put("code", "1");
				return map;
			}
			// 检查扩展名
			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
             try {
            	 Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt);
			} catch (Exception e) {
				System.out.println(e);
			}
			if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
				map.put("msg", "上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
				map.put("code", "1");
					return map;
			}
 
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000)+"." + fileExt;
			try {
				File uploadedFile = new File(savePath, newFileName);
				file.transferTo(uploadedFile);
				//保存 上传的文件 
				String filename = uploadedFile.getName();
				SiteCFile sitefile = new SiteCFile();
				if(StringUtils.hasText(id)){
					sitefile.setObjectId(id);
				}else{
					sitefile.setObjectId(null);
				}
				sitefile.setIsTemp("N");
				sitefile.setFileUrl(uploadedFile.toString());
				houseSourceService.saveFile(sitefile);
				map.put("src",uploadedFile.toString());
				map.put("id",sitefile.getId());
				map.put("msg", "上传文件成功。");
				map.put("code", "0");
			} catch (Exception e) {
				System.out.println(e);
				map.put("msg", "上传文件失败。");
				map.put("code", "1");
				return map;
			}
		}else{
			map.put("msg", "上传文件失败。");
			map.put("code", "1");
			return map;
		}
		return map;
    }
    
    /**
     * 文件下载
     *  @param fileName
     * @param isOnline
     * @param response
     */
    @RequestMapping(value = "/downLoadFile")
   	@ResponseBody
    public void downLoad(String id, Integer isOnline, HttpServletRequest request, HttpServletResponse response) throws IOException {
    	SiteCFile file = houseSourceService.getFileDetail(Integer.parseInt(id));
    	String url = file.getFileUrl();
    	isOnline = 0;
    	File f = new File(url);//图片url路径
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;
        response.reset(); // 非常重要
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }
    
}
