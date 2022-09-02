package com.qytp.spring;

import com.qytp.QytpRegistry;
import com.qytp.thread.QytpExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wenan.ren
 * @date 2022/9/2 16:26
 * @Description
 */
@Slf4j
public class QytpPostProcess implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!(bean instanceof ThreadPoolExecutor)) {
            return bean;
        }
        if (bean instanceof QytpExecutor) {
            QytpExecutor qytpExecutor = (QytpExecutor) bean;
            QytpRegistry.qytpRegister.put(qytpExecutor.getThreadPoolName(), qytpExecutor);
            return qytpExecutor;
        }

        return bean;
    }
}
