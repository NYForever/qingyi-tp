package com.ny.qingyi.test.service.impl;

import com.ny.qingyi.test.service.PlayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wenan.ren
 * @date 2022/8/31 17:25
 * @Description
 */
@Slf4j
@Service
public class DogPlayServiceImpl implements PlayService {
    @Override
    public void play() {
        log.info("dag play");
    }
}
