package com.itqiankun.xianfeng;

import com.itqiankun.Factory;
import com.itqiankun.Brand;
import com.itqiankun.Fruit;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class XianFengFruitFactory implements Factory {

    @Override
    public Brand createBrand() {
        return new XianFengBrand();
    }

    @Override
    public Fruit createFruit() {
        return new XianFengApple();
    }
}
