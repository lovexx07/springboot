package net.xdclass.demo2.controller;

import net.xdclass.demo2.domain.JsonData;
import net.xdclass.demo2.domain.MyException;
import net.xdclass.demo2.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
public class ExecptionController {

    @RequestMapping(value = "/api/v1/test_ext")
    public Object index(){
        int i = 1/ 0;
        return new User(11, "sdfas", "322", new Date());
    }

    @RequestMapping("/api/v1/myext")
    public Object myexc(){
        throw new MyException("500", "my ext异常");
    }

}
