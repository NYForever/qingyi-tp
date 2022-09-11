package com.qytp.test.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenan.ren
 * @date 2022/9/6 19:56
 * @Description
 */
@RefreshScope
@RestController
@RequestMapping("test01")
@Slf4j
public class Test01Controller {

    @Value("${qingyi.test}")
    private String testString;

    @RequestMapping("/testNacos")
    private String test01() {
        log.info("testString:{}", testString);
        return "success";
    }
}
