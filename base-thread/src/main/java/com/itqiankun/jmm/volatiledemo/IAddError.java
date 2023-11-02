package com.itqiankun.jmm.volatiledemo;

/**
 * @author: ma_qiankun
 * @date: 2023/10/26
 **/
public class IAddError {

    public static volatile int num = 0;

    public static void addOne(){
        num++;
    }

    public static void main(String[] args) {
        for (int j = 0; j < 20; j++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    addOne();
                }
            });
            thread.start();
        }

        while (Thread.activeCount() > 1){
            Thread.yield();
        }

        System.out.println(num);
    }
}
