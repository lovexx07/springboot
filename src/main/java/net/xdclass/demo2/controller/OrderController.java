package net.xdclass.demo2.controller;

import net.xdclass.demo2.domain.JsonData;
import net.xdclass.demo2.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RestController
@RequestMapping("/aip/v1")
public class OrderController {


    @Autowired
    private ProducerService producerService;

    @GetMapping("order")
    public Object order(String msg){
        //生成消息队列地址
        Destination destination = new ActiveMQQueue("order.queue");

        producerService.sendMessage(destination, msg);
        return JsonData.buildSuccess();
    }

    @GetMapping("common")
    public Object common(String msg){
        producerService.sendMessage(msg);
        return JsonData.buildSuccess();
    }


    //================发布消息生成================
    @GetMapping("topic")
    public Object topic(String msg){
        producerService.publish(msg);
        return JsonData.buildSuccess();
    }
}
