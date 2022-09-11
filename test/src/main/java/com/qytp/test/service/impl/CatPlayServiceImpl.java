package com.qytp.test.service.impl;

import com.qytp.test.service.PlayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author wenan.ren
 * @date 2022/8/31 17:25
 * @Description
 */
@Slf4j
@Service
@Primary
public class CatPlayServiceImpl implements PlayService {
    @Override
    public void play() {
        log.info("cat play");
    }
}
