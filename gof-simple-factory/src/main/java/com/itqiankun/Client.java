package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class Client {
    public static void main(String[] args) {
        Fruit apple = FruitFactory.generationFruit("apple");
        apple.color();
        Fruit grape = FruitFactory.generationFruit("grape");
        grape.color();

    }
}
