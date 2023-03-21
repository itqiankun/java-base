package com.itqiankun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ma_qiankun
 * @date: 2023/3/21
 **/
@Slf4j
public class SimpleAnnotation {

    @Test
    public void test (){
        log.debug("debug. 学IT，找IT乾坤，官网地址： {}","https://www.itqiankun.com");
        log.info("info. 学IT，找IT乾坤，官网地址： {}","https://www.itqiankun.com");
    }
}
