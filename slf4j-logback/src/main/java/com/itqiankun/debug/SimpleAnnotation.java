package com.itqiankun.debug;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ma_qiankun
 * @date: 2023/3/21
 **/
public class SimpleAnnotation {

    private static Logger logger = LoggerFactory.getLogger(SimpleAnnotation.class);

    @Test
    public void test (){
        logger.info("info. 学IT，找IT乾坤，官网地址： {}","https://www.itqiankun.com");
    }

    @Test
    public void equalAndEqualityStrAndStringObject(){
        String str ="a";
        String str2 ="a";
        String str1 =new String("a");

        logger.info("==符号比较:{}", str==str1);
        logger.info("==符号比较:{}", str==str2);
    }

    @Test
    public void equal(){
        String a = "hello2";
        String d = "hello";
        String e = d + 2;
        logger.info("==符号比较:{}",(a == e));
        logger.info("equals符号比较:{}",(a.equals(e)));
    }
}
