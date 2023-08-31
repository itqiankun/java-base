package com.itqiankun.decorator;

/**
 * @author: ma_qiankun
 * @date: 2023/8/31
 **/
public class Milk extends CoffeeDecorator {
	public Milk(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double getCost() {
		return coffee.getCost() + 0.5;
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + ", Milk";
	}
}