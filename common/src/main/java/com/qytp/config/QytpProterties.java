package com.qytp.config;

import com.qytp.constant.QytpConstant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


/**
 * @author wenan.ren
 * @date 2022/9/2 10:15
 * @Description
 */
@Data
@Slf4j
@ConfigurationProperties(prefix = QytpConstant.MAIN_PROPERTITY_PREFIX)
public class QytpProterties {

    private Boolean enable;
    private Nacos nacos;
    private List<ThreadPoolProterties> executors;

    @Data
    class Nacos {
        private String dataId;
        private String group;
    }
}