package net.xdclass.demo2.service.impl;

import net.xdclass.demo2.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;
    @Autowired
    private Queue queue;

    @Override
    public void sendMessage(Destination destination, String message) {
        jmsTemplate.convertAndSend(destination,  message);
    }

    @Override
    public void sendMessage(String message) {

        jmsTemplate.convertAndSend(this.queue,  message);
    }

    //============发布订阅相关代码======================

    @Autowired
    private Topic topic;

    @Override
    public void publish(String msg) {
        jmsTemplate.convertAndSend(topic, msg);
    }
}
