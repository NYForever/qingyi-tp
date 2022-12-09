package com.qytp.core.annomation;

import com.qytp.core.spring.QytpBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wenan.ren
 * @date 2022/9/2 10:20
 * @Description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(QytpBeanDefinitionRegistrar.class)
public @interface EnableQingyiTP {
    // just Git test, ignore
}
