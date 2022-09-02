package com.qytp.config;

import lombok.Data;

import java.util.List;

/**
 * @author wenan.ren
 * @date 2022/9/2 10:15
 * @Description
 */
@Data
public class QingyiTPProterties {

    private Boolean enable;
    private Nacos nacos;
    private List<ThreadPoolProterties> executors;

    @Data
    class Nacos{
        private String dataId;
        private String group;
    }
}
