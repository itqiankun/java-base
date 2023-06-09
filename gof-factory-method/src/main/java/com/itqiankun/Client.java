package com.itqiankun;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class Client {

    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        GrapeFactory grapeFactory = new GrapeFactory();
        Map<String, FruitFactory> factoryMap = new HashMap<>();
        factoryMap.put("apple", appleFactory);
        factoryMap.put("grape", grapeFactory);

        testFruit("apple", factoryMap);
        testFruit("grape", factoryMap);
    }

    private static void testFruit(String fruitName, Map<String, FruitFactory> factoryMap) {
        FruitFactory factory = factoryMap.get(fruitName);  // 这里返回的是工厂接口
        Fruit fruit = factory.generationFruit(); // 这里返回的是水果接口
        fruit.color();
    }
}
