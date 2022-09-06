package com.ny.qingyi.test.contorller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenan.ren
 * @date 2022/9/6 19:56
 * @Description
 */
@RestController
@RequestMapping("test01")
public class Test01Controller {

    @Value("${qingyi.tp.test}")
    private String testString;

    @RequestMapping("/testNacos")
    private String test01() {
        return "success";
    }
}
