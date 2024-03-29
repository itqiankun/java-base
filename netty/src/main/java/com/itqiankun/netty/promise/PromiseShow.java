package com.itqiankun.netty.promise;

/**
 * @author: ma_qiankun
 * @date: 2023/6/5
 **/

import io.netty.util.concurrent.*;

public class PromiseShow {
    public static void main(String[] args) {

        // 构造线程池
        EventExecutor executor = new DefaultEventExecutor();

        // 创建 DefaultPromise 实例
        Promise promise = new DefaultPromise(executor);

        // 下面给这个 promise 添加两个 listener
        promise.addListener((GenericFutureListener<Future<Integer>>) future -> {
            if (future.isSuccess()) {
                System.out.println("任务结束，结果：" + future.get());
            } else {
                System.out.println("任务失败，异常：" + future.cause());
            }
        }).addListener((GenericFutureListener<Future<Integer>>) future -> System.out.println("任务结束，balabala..."));

        // 提交任务到线程池，五秒后执行结束，设置执行 promise 的结果
        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                }
                // 设置 promise 的结果
                promise.setSuccess(123456);
            }
        });

        // main 线程阻塞等待执行结果
        try {
            promise.sync();
        } catch (Exception e) {

        }
    }
}

