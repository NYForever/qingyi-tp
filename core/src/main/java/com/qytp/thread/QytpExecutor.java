package com.qytp.thread;

import lombok.Data;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wenan.ren
 * @date 2022/9/2 11:40
 * @Description
 */
@Data
public class QytpExecutor extends ThreadPoolExecutor {

    private String threadPoolName;

    public QytpExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }
}
