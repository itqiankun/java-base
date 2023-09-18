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
				String price = event.getOrder().getPrice();
				System.out.println(price+" order create listen");
			}

			@Override
			public void listenFinish(OrderEvent event) {
				String price = event.getOrder().getPrice();
				System.out.println(price+" order finish listen ");
			}
		});
		order.setPrice("200元");
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setOrder(order);
		order.create(orderEvent);
		order.finish(orderEvent);
	}
}
