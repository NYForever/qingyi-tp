package com.ny.qingyi.test.contorller;

import com.ny.qingyi.test.aware.MyTestAware;
import com.ny.qingyi.test.pojo.Person;
import com.ny.qingyi.test.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wenan.ren
 * @date 2022/8/31 17:21
 * @Description
 */
@RestController
public class TestContorller {

    @Autowired
    private PlayService playService;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Map<String,PlayService> map;

    @Autowired
    private Person person;

    @Autowired
    private Person person01;

    @RequestMapping("/testPrimary")
    private String test01(){
        playService.play();
        return "success";
    }

    @RequestMapping("/testAware")
    private String testAware(){
        PlayService dogPlayServiceImpl = map.get("dogPlayServiceImpl");
        dogPlayServiceImpl.play();
        PlayService dogPlayService = applicationContext.getBean("dogPlayServiceImpl", PlayService.class);
        Person beanByClass = MyTestAware.getBean(Person.class);
        PlayService playService = MyTestAware.getBean(PlayService.class);
        return "success";
    }
}