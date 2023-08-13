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
        log.info("info. 学IT，找IT乾坤，官网地址： {}","https://www.itqiankun.com");
    }

    @Test
    public void equalAndEqualityStrAndStringObject(){
        String str ="a";
        String str2 ="a";
        String str1 =new String("a");

        log.info("==符号比较:{}", str==str1);
        log.info("==符号比较:{}", str==str2);
    }

    @Test
    public void equal(){
        String a = "hello2";
        String d = "hello";
        String e = d + 2;
        log.info("==符号比较:{}",(a == e));
        log.info("equals符号比较:{}",(a.equals(e)));
    }
}
