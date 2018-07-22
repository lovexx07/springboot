package net.xdclass.demo2.controller;


import net.xdclass.demo2.domain.JsonData;
import net.xdclass.demo2.domain.User;
import net.xdclass.demo2.service.UserService;
import net.xdclass.demo2.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("add")
    public Object add(String msg){

        User user = new User();
        user.setAge(21);
        user.setCreateTIme(new Date());
        user.setName("xdclass1");
        user.setPhone("10230110000");
        int id = userService.add(user);

        return JsonData.buildSuccess(id);
    }

    @GetMapping("addaccount")
    public Object addAccount(){
        return userService.addaccount();
    }

    @GetMapping("add_account")
    public Object addaccount(){
        return userService.addaccount();
    }

    @GetMapping("getall")
    public Object getAll(String msg){


        return userService.getAll();
    }
    @GetMapping("findid")
    public Object findById(String id){

        Long ID = Long.parseLong(id);
        return userService.findById(ID);
    }

    @Autowired
    private AsyncTask task;

    @GetMapping("async_task")
    public JsonData exeTask() throws InterruptedException {

        long begin = System.currentTimeMillis();

//        task.task1();
//        task.task2();
//        task.task3();

        Future<String> task4 = task.task4();
        Future<String> task5 = task.task5();
        for(;;){
            if (task4.isDone() && task5.isDone()){
                break;
            }
        }


        long end = System.currentTimeMillis();

        System.out.println("执行总耗时："+(end - begin));

        return JsonData.buildSuccess();
    }
}
