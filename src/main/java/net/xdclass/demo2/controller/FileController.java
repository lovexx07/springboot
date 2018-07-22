package net.xdclass.demo2.controller;

import net.xdclass.demo2.domain.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping(value = "/api/v1/gopage")
    public Object index(){
        return "index";
    }

    private static final String filepath = "D:/springworkspace/demo2/src/main/resources/static/images/";

    @RequestMapping(value = "/upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img")MultipartFile file, HttpServletRequest request){
//        file.isEmpty()  图片为空
//        file.getSize()   大小

        String name = request.getParameter("name");
        System.out.println("用户名："+name);

        String fileName = file.getOriginalFilename();
        System.out.println("上传的图片文件名："+fileName);

        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的图片后缀名："+suffixName);

        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filepath+fileName);

        try {
            file.transferTo(dest);
            return new JsonData(0, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonData(-1, "上传失败");
    }
}
