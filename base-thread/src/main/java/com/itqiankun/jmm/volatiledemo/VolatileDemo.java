package com.itqiankun.jmm.volatiledemo;

import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/10/26
 **/
public class VolatileDemo {
    int anInt = 0;
    boolean flag = false;

    public void writer(){
        anInt = 42;
        flag = true;
    }


    @Test
    public void it_qk(){
        long a= 900000L,b= 20000000L;
        long x = a+b;
        int c=10,d=15;
        int y = c+d;
    }

}
