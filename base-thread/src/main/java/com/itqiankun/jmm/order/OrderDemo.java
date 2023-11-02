package com.itqiankun.jmm.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/10/26
 **/
@Slf4j
public class OrderDemo {

    @Test
    public void it_qk(){
        int i=10;  // 1
        int b=15;  // 2
        int c = i+b; // 3
    }
}
