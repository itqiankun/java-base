package com.itqiankun.debug;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/3/21
 **/
@Slf4j
public class SimpleAnnotationTwo {

    @Test
    public void test (){
        log.debug("debug. 学IT，找IT乾坤，官网地址： {}","https://www.itqiankun.com");
    }
}
