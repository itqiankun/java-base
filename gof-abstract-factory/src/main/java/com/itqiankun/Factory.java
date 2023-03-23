package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public interface Factory {
    // 创建品牌名字
    Brand createBrand();
    // 创建水果种类
    Fruit createFruit();
}
