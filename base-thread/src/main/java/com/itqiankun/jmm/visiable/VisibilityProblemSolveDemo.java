package com.itqiankun.jmm.visiable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/10/26
 **/
@Slf4j
public class VisibilityProblemSolveDemo extends Thread{
    public volatile boolean mark = false; //默认false
    public VisibilityProblemSolveDemo(){}
    @Override
    public void run() {
        while (true){
            if(mark){
                log.info("可见性结果");
                break;
            }
        }
    }

    public static void main(String[] args){
        VisibilityProblemSolveDemo visibilityDemo=new VisibilityProblemSolveDemo();
        visibilityDemo.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        visibilityDemo.mark =true;
    }

}
