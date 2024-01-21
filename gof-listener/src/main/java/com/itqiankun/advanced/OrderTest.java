package com.itqiankun.advanced;

import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/9/5
 **/
public class OrderTest {
	@Test
	public void itqiankun(){
		OrderSource order = new OrderSource();
		order.setOrderListener(new OrderListener() {
			@Override
			public void listenCreate(OrderEvent event) {
				String price = event.getPrice();
				System.out.println(price+" order create listen");
			}

			@Override
			public void listenFinish(OrderEvent event) {
				String price = event.getPrice();
				System.out.println(price+" order finish listen ");
			}
		});
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setPrice("200元");
		order.create(orderEvent);
		order.finish(orderEvent);
	}
}
