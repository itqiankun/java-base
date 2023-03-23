package com.itqiankun.contract;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class WinContract implements Contract{



    @Override
    public void handler() {
        System.out.println("win订单逻辑");
    }

}