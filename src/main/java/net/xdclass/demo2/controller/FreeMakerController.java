package net.xdclass.demo2.controller;

import net.xdclass.demo2.domain.ServerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemaker")
public class FreeMakerController {

    @Autowired
    private ServerSetting setting;

    @GetMapping("hello")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("setting", setting);
        return "fm/index";
    }
}
