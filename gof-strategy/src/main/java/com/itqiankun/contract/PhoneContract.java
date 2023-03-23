package com.itqiankun.contract;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class PhoneContract implements Contract{


    @Override
    public void handler() {
        System.out.println("phone订单逻辑");
    }
}