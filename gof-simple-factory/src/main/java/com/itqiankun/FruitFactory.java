package com.itqiankun;

import java.util.Objects;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class FruitFactory {

    public static Fruit generationFruit(String fruitName){
        if(Objects.equals(fruitName, "apple")){
            return new Apple();
        } else  if(Objects.equals(fruitName, "grape")){
            return new Grape() ;
        }
        return null;
    };
}
