package com.itqiankun.decorator;

/**
 * @author: ma_qiankun
 * @date: 2023/8/31
 **/
// 抽象装饰器
public class CoffeeDecorator implements Coffee {
	protected Coffee coffee;

	public CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double getCost() {
		return coffee.getCost();
	}

	@Override
	public String getDescription() {
		return coffee.getDescription();
	}
}
