package net.xdclass.demo2.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CommonConsumer {
    //监听默认消息队列
    @JmsListener(destination = "common.queue")
    public void receiveQueue(String text){
        System.out.println("CommonConsumer接收到的报文为："+text);
    }
}
