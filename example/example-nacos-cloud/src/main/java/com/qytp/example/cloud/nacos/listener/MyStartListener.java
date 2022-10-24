package com.qytp.example.cloud.nacos.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * @author wenan.ren
 * @date 2022/10/17 14:26
 * @Description
 */
@Slf4j
@Component
public class MyStartListener {

    @EventListener
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("启动事件");
    }

    @EventListener
    public void onListener(RequestHandledEvent evevt){
        log.info("请求数据：" + evevt.getSource());
    }
}
