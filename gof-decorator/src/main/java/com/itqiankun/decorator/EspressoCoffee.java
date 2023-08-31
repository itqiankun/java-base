package com.itqiankun.decorator;

/**
 * @author: ma_qiankun
 * @date: 2023/8/31
 **/
// 具体组件
public class EspressoCoffee implements Coffee{
	@Override
	public double getCost() {
		return 1.99;
	}

	@Override
	public String getDescription() {
		return "Espresso";
	}
}
