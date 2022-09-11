package com.qytp.core.spring;

import com.qytp.common.config.QytpProterties;
import com.qytp.common.config.ThreadPoolProterties;
import com.qytp.common.constant.QytpConstant;
import com.qytp.core.thread.QytpExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author wenan.ren
 * @date 2022/9/2 10:23
 * @Description
 */
@Slf4j
public class QytpBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //从environment对象中获取threadPoolExecutor相关配置
        QytpProterties qingyiTPProterties = new QytpProterties();
        Binder binder = Binder.get(environment);
        ResolvableType resolvableType = ResolvableType.forClass(QytpProterties.class);
        Bindable<Object> target = Bindable.of(resolvableType).withExistingValue(qingyiTPProterties);
        binder.bind(QytpConstant.MAIN_PROPERTITY_PREFIX, target);

        if (CollectionUtils.isEmpty(qingyiTPProterties.getExecutors())) {
            log.warn("qingyi-tp executors is empty");
            return;
        }

        //解析配置为BeanDifinition信息，通过BeanDefinitionRegistry注册到spring容器中
        for (ThreadPoolProterties executor : qingyiTPProterties.getExecutors()) {
            if (registry.containsBeanDefinition(executor.getThreadPoolName())) {
                log.error("has alread exist executorName:{}", executor.getThreadPoolName());
                continue;
            }

            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(QytpExecutor.class);

            //构建线程池参数
            Object[] args = {
                    executor.getCorePoolSize(),
                    executor.getMaximumPoolSize(),
                    executor.getKeepAliveTime(),
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(1000),
                    (ThreadFactory) r -> new Thread(QytpConstant.MAIN_PROPERTITY_PREFIX)
            };
            for (Object arg : args) {
                builder.addConstructorArgValue(arg);
            }

            //绑定配置文件中的属性
            Map<String, Object> propertiesMap = new HashMap() {{
                put(QytpConstant.THREAD_POOL_NAME, executor.getThreadPoolName());
            }};
            propertiesMap.forEach(builder::addPropertyValue);

            //注册到spring容器中
            registry.registerBeanDefinition(executor.getThreadPoolName(), builder.getBeanDefinition());
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
