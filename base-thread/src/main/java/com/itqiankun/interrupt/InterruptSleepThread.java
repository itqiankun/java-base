package com.itqiankun.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/10/30
 **/
public class InterruptSleepThread {


    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        thread.start();

        thread.interrupt();

        while (Thread.activeCount() > 1){
            System.out.println(Thread.activeCount());
            Thread.yield();
        }


    }


}
