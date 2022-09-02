package com.ny.qingyi.test.config;

import com.ny.qingyi.test.pojo.Person;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenan.ren
 * @date 2022/9/1 16:56
 * @Description
 */
public class MyImportBeanDefinition implements ImportBeanDefinitionRegistrar , EnvironmentAware {

    private Environment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Map<String, Object> properties = new HashMap<>();
        properties.put("age",12);
        properties.put("name","xiaoA");
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
        properties.forEach(builder::addPropertyValue);
        registry.registerBeanDefinition("person", builder.getBeanDefinition());

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Person.class);
        beanDefinition.getPropertyValues().add("age",23);
        beanDefinition.getPropertyValues().add("name","xiaoB");
        registry.registerBeanDefinition("person01", beanDefinition);

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
