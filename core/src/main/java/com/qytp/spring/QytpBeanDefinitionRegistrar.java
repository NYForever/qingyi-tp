package com.qytp.spring;

import com.qytp.config.QingyiTPProterties;
import com.qytp.config.ThreadPoolProterties;
import com.qytp.constant.QytpConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.CollectionUtils;

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
        QingyiTPProterties qingyiTPProterties = new QingyiTPProterties();
        Binder binder = Binder.get(environment);
        ResolvableType resolvableType = ResolvableType.forClass(QingyiTPProterties.class);
        Bindable<Object> target = Bindable.of(resolvableType).withExistingValue(qingyiTPProterties);
        binder.bind(QytpConstant.MAIN_PROPERTITY_PREFIX, target);

        if (CollectionUtils.isEmpty(qingyiTPProterties.getExecutors())) {
            log.warn("qingyi-tp executors is empty");
            return;
        }

        for (ThreadPoolProterties executor : qingyiTPProterties.getExecutors()) {

        }


    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
