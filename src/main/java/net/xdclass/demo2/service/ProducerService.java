package net.xdclass.demo2.service;


import javax.jms.Destination;

public interface ProducerService {

    /**
     * 指定消息队列、消息
     * @param destination
     * @param message
     */
     void sendMessage(Destination destination, final  String message);

    /**
     * 使用默认消息队列发送消息
     * @param message
     */
    void sendMessage(final String message);
}
