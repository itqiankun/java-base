package com.itqiankun.advanced;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void actionActivity(){
        strategy.activity();
    }
}
