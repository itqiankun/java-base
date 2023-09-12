package com.itqiankun.AnnotatedElement;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class WorkerStrategy implements Strategy{
    @Override
    public void activity() {
        System.out.println("劳动节活动");
    }
}
