package com.qytp.starter.cloud.nacos.refresh;

import com.qytp.QytpRegistry;
import com.qytp.config.QytpProterties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

import javax.annotation.Resource;

/**
 * @author wenan.ren
 * @date 2022/9/2 16:38
 * @Description
 */
@Slf4j
public class CloudNacosRefresh implements SmartApplicationListener {

    @Resource
    private QytpProterties qytpProterties;

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        if (RefreshScopeRefreshedEvent.class.equals(eventType)) {
            return true;
        }
        return false;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof RefreshScopeRefreshedEvent){
            QytpRegistry.refresh(qytpProterties);
        }
    }

}
