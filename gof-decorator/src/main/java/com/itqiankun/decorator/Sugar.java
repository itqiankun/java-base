package com.itqiankun.decorator;

/**
 * @author: ma_qiankun
 * @date: 2023/8/31
 **/
public class Sugar extends CoffeeDecorator {
	public Sugar(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double getCost() {
		return coffee.getCost() + 0.3;
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + ", Sugar";
	}
}