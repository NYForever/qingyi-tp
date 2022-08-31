package com.ny.qingyi.test.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author wenan.ren
 * @date 2022/8/31 17:33
 * @Description
 */
@Component
public class MyTestAware implements ApplicationContextAware {

    private static ApplicationContext application;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        application = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return (T) application.getBean(clazz);
    }
}
