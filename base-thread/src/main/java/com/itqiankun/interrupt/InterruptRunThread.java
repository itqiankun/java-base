package com.itqiankun.interrupt;

/**
 * @author: ma_qiankun
 * @date: 2023/10/30
 **/
public class InterruptRunThread {


    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello");
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
