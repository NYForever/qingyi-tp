package com.qytp.starter.cloud.nacos.autoconfigure;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.qytp.QytpRegistry;
import com.qytp.config.QytpProterties;
import com.qytp.spring.QytpPostProcess;
import com.qytp.starter.cloud.nacos.refresh.CloudNacosRefresh;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wenan.ren
 * @date 2022/9/2 16:36
 * @Description
 */
@Slf4j
@Configuration
@ConditionalOnBean(NacosConfigProperties.class)
@EnableConfigurationProperties(QytpProterties.class)
public class QytpAutoConfiguration {

    @Bean
    public QytpPostProcess qytpPostProcess(){
        return new QytpPostProcess();
    }

    @Bean
    @ConditionalOnMissingBean
    public QytpRegistry qytpRegistry(){
        return new QytpRegistry();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(NacosConfigManager.class)
    public CloudNacosRefresh cloudNacosRefresh(){
        return new CloudNacosRefresh();
    }
}
