package com.qytp.config;

import lombok.Data;

/**
 * @author wenan.ren
 * @date 2022/9/2 10:09
 * @Description
 */
@Data
public class ThreadPoolProterties {

    private String threadPoolName;
    private Integer corePoolSize;
    private Integer maximumPoolSize;
    private String queueType;
    private String rejectedHandlerType;
    private Integer keepAliveTime;
    private String timeUnit;
}
