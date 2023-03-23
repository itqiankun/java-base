package com.itqiankun.base;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class ChildStrategy implements Strategy{
    @Override
    public void activity() {
        System.out.println("儿童节活动");
    }
}
