package net.xdclass.demo2.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息订阅着
 * 一个发布多个订阅
 */
@Component
public class TopicSub {
    @JmsListener(destination = "video.topic")
    public void receive1(String text){
        System.out.println("TopicConsumer1 video.topic接收到的报文为："+text);
    }

    /**
     * 重复订阅
     * @param text
     */
    @JmsListener(destination = "video.topic")
    public void receive2(String text){
        System.out.println("TopicConsumer2 video.topic接收到的报文为："+text);
    }
}
