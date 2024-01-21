package com.itqiankun.advanced;

import lombok.Data;

/**
 * @author: ma_qiankun
 * @date: 2023/9/5
 **/
@Data
public class OrderSource {


	private OrderListener orderListener;

	public void create(OrderEvent orderEvent){
		System.out.println(orderEvent.getPrice()+" order create");
		orderListener.listenCreate(orderEvent);
	}

	public void finish(OrderEvent orderEvent){
		System.out.println(orderEvent.getPrice()+" order finish");
		orderListener.listenFinish(orderEvent);
	}

	public void setOrderListener(OrderListener orderListener) {
		this.orderListener = orderListener;
	}
}
