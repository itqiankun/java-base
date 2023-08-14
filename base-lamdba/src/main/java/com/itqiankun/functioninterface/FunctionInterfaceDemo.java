package com.itqiankun.functioninterface;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 1; j++) {
                    log.info("value:{}",  i*j);
                }
            }
        };
        new Thread(runnable).start();
    }
}
