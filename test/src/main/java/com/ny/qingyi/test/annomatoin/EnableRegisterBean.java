package com.ny.qingyi.test.annomatoin;

import com.ny.qingyi.test.config.MyImportBeanDefinition;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wenan.ren
 * @date 2022/9/1 17:02
 * @Description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportBeanDefinition.class)
public @interface EnableRegisterBean {
}
