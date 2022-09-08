package com.ny.qingyi.examplenacoscloud;

import com.qytp.annomation.EnableQingyiTP;
import com.qytp.config.QytpProterties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(QytpProterties.class)
@EnableQingyiTP
@SpringBootApplication
public class ExampleNacosCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleNacosCloudApplication.class, args);
    }
}
