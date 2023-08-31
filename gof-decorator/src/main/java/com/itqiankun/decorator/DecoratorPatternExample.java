package com.itqiankun.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/8/31
 **/
@Slf4j
public class DecoratorPatternExample {
	public static void main(String[] args) {
		Coffee espresso = new EspressoCoffee(); //浓咖啡
		Coffee espressoWithMilk = new Milk(espresso); // 浓咖啡+牛奶
		Coffee espressoWithMilkAndSugar = new Sugar(espressoWithMilk); // 浓咖啡+牛奶+糖

		log.info("浓咖啡+牛奶+糖 Cost: " + espressoWithMilkAndSugar.getCost());
		log.info("浓咖啡+牛奶+糖 Description: " + espressoWithMilkAndSugar.getDescription());
		log.info("浓咖啡+牛奶 Cost: " + espressoWithMilk.getCost());
		log.info("浓咖啡+牛奶 Description: " + espressoWithMilk.getDescription());
		log.info("浓咖啡 Cost: " + espresso.getCost());
		log.info("浓咖啡 Description: " + espresso.getDescription());
	}

}
