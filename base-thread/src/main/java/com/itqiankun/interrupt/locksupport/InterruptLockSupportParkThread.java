package com.itqiankun.interrupt.locksupport;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: ma_qiankun
 * @date: 2023/10/30
 **/
@Slf4j
public class InterruptLockSupportParkThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("before:{}", Thread.currentThread().getName());
            LockSupport.park();
            log.info("after:{}", Thread.currentThread().getName());
        });

        thread.start();

        // 模拟耗时逻辑
        for (int i = 0; i < 900000000; i++) {
            int y=0;
            int j = y++;
            int h = y+j;
        }
        thread.interrupt();

        while (Thread.activeCount() > 1){
            log.info("线程数量:{}",Thread.activeCount());
        }


    }


}
