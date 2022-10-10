package com.qytp.kaiyuan.rabbitmq.kaiyuanrabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenan.ren
 * @date 2022/9/14 17:15
 * @Description
 */
@RestController
@Component
@RabbitListener(queues = "queue1")
public class RabbitmqConsumer {

    @Autowired
    private ApplicationContext applicationContext;

    @RabbitHandler
    public void receiveMsg(String msg) {
        System.out.println("接收MSG：" + msg);
    }

    @RequestMapping("test")
    private void test() {
        Person person = new Person();
        person.setAge("12");
        person.setName("tom");

        Map<String, Person> map = new HashMap<>();
        map.put("11", person);
        map.clear();

        Person person1 = new Person();
        BeanUtils.copyProperties(person, person1);
        MessageListenerContainer bean = applicationContext.getBean(MessageListenerContainer.class);
        AbstractMessageListenerContainer bean1 = applicationContext.getBean(AbstractMessageListenerContainer.class);
        return;
    }


}
