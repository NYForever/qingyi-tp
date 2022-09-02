package com.qytp;

import com.alibaba.fastjson.JSONObject;
import com.qytp.config.QytpProterties;
import com.qytp.thread.QytpExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenan.ren
 * @date 2022/9/2 16:29
 * @Description
 */
@Slf4j
public class QytpRegistry {

    public static final Map<String, QytpExecutor> qytpRegister = new HashMap<>();

    public static void refresh(QytpProterties qytpProterties) {
        log.info("refresh threadPoolExecutor qytpProterties:{}", JSONObject.toJSONString(qytpProterties));
    }
}
