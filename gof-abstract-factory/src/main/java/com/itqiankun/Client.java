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
        AbstractFactory badiGuoYuanFruitFactory = new BadiGuoYuanFruitFactory();
        AbstractFactory xianFengFruitFactory = new XianFengFruitFactory();
        Map<String, AbstractFactory> factoryMap = new HashMap<>();
        factoryMap.put("xianfeng", xianFengFruitFactory);
        factoryMap.put("baiguoyuan", badiGuoYuanFruitFactory);

        test("xianfeng", factoryMap);
        test("baiguoyuan", factoryMap);
    }

    private static void test(String arg, Map<String, AbstractFactory> factoryMap) {
        AbstractFactory abstractFactory = factoryMap.get(arg);
        Brand brand = abstractFactory.createBrand();
        brand.name();

        Fruit fruit = abstractFactory.createFruit();
        fruit.color();
    }

}
