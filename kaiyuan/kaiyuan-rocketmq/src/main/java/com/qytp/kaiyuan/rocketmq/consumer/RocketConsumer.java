package com.qytp.kaiyuan.rocketmq.consumer;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author wenan.ren
 * @date 2022/9/14 17:04
 * @Description
 */
@Component
@RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-1")
public class RocketConsumer implements RocketMQListener<Message> {

    @Override
    public void onMessage(Message message) {

    }

}
