package com.ny.qingyi.test;

import com.qytp.annomation.EnableQingyiTP;
import com.qytp.config.QytpProterties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author wenan.ren
 * @date 2022/8/31 16:54
 * @Description
 */
@EnableConfigurationProperties(QytpProterties.class)
@EnableQingyiTP
@SpringBootApplication
public class QingyiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(QingyiTestApplication.class, args);
    }

}
