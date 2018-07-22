package net.xdclass.demo2.controller;

import net.xdclass.demo2.domain.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "Hello World";
    }

    @RequestMapping("/test")
    public Map<String, String> testMap(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "xdclass");
        return map;
    }

    @RequestMapping("/testjson")
    public Object testjson(){
        return new User(111, "abc124", "10010000", new Date());
    }

}
