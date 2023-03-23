package com.itqiankun.baiguoyuan;

import com.itqiankun.Factory;
import com.itqiankun.Brand;
import com.itqiankun.Fruit;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class BadiGuoYuanFruitFactory implements Factory {

    @Override
    public Brand createBrand() {
        return new BaiGuoYuanBrand();
    }

    @Override
    public Fruit createFruit() {
        return new BaiGuoYuanGrape();
    }
}
