package com.itqiankun;

import com.itqiankun.baiguoyuan.BadiGuoYuanFruitFactory;
import com.itqiankun.xianfeng.XianFengFruitFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class Client {
    public static void main(String[] args) {
        Factory badiGuoYuanFruitFactory = new BadiGuoYuanFruitFactory();
        Factory xianFengFruitFactory = new XianFengFruitFactory();
        Map<String, Factory> factoryMap = new HashMap<>();
        factoryMap.put("xianfeng", xianFengFruitFactory);
        factoryMap.put("baiguoyuan", badiGuoYuanFruitFactory);

        test("xianfeng", factoryMap);
        System.out.println("-----");
        test("baiguoyuan", factoryMap);
    }

    private static void test(String arg, Map<String, Factory> factoryMap) {
        Factory factory = factoryMap.get(arg);
        Brand brand = factory.createBrand();
        brand.name();

        Fruit fruit = factory.createFruit();
        fruit.color();
    }

}
