package net.xdclass.demo2.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务
 *
 */
@Component
public class TestTaask {

//    @Scheduled(fixedRate = 2000)
    @Scheduled(cron = "/2 * * * *")
    public void sum(){
        System.out.println("当前时间："+new Date());
    }
}
