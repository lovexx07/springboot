package net.xdclass.demo2.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息队列接收
 */
@Component
public class OrderConsumer {

    @JmsListener(destination = "order.queue")
    public void receiveQueue(String text){
        System.out.println("OrderConsumer接收到的报文为："+text);
    }
}
