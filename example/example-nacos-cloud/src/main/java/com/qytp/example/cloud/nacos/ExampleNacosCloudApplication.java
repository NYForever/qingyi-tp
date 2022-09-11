package com.qytp.example.cloud.nacos;

import com.qytp.core.annomation.EnableQingyiTP;
import com.qytp.common.config.QytpProterties;
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
