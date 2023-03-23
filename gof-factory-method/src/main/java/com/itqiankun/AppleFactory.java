package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class AppleFactory implements FruitFactory{
    @Override
    public Fruit generationFruit() {
        return new Apple();
    }
}
