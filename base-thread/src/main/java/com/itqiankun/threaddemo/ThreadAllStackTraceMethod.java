package com.itqiankun.threaddemo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ma_qiankun
 * @date: 2023/10/26
 **/
@Slf4j
public class ThreadAllStackTraceMethod {
    public static void main(String[] args) {

        AtomicInteger num= new AtomicInteger();
        for (int j = 0; j < 20; j++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    num.getAndIncrement();
                }

            });
            thread.start();
        }

        while (Thread.activeCount() > 1){
            Map<Thread, StackTraceElement[]> allStackTraces =
                    Thread.getAllStackTraces();
            allStackTraces.keySet().stream().forEach(x->{
                String name = x.getName();
                StackTraceElement[] stackTraceElements = allStackTraces.get(x);
                log.info("thread name:{}, result:{}", name, JSONObject.toJSONString(stackTraceElements));
            });
            Thread.yield();
        }
    }
}
