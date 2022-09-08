package com.ny.qingyi.examplenacoscloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenan.ren
 * @date 2022/9/8 17:29
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("test")
@RefreshScope
public class TestController {

    @Value("${qingyi.test}")
    private String testString;

    @RequestMapping("001")
    public String test01() {
        log.info("testString:{}", testString);
        return "success";
    }
}
