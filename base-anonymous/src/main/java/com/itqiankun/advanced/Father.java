package com.itqiankun.advanced;

/**
 * @author: ma_qiankun
 * @date: 2023/4/26
 **/
public class Father {
    public String name() {
        return "default name";
    }

    public String son() {
        return "default son()";
    }

    public static Father createFather(){
        return new Father(){
            @Override
            public String name(){
                return "anonymous name";
            }
        };
    }
}
