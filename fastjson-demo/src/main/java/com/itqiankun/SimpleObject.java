package com.itqiankun;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ma_qiankun
 * @date: 2023/3/21
 **/
public class SimpleObject {
    private static final Logger logger = LoggerFactory.getLogger(SimpleObject.class);

    @Test
    public void test (){
        Hello hello = new Hello();
        hello.setCc("hello".getBytes());
        logger.info("学IT，找IT乾坤，官网地址： {}", JSONObject.toJSON(hello));
    }
}
