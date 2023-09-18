package com.itqiankun.advanced;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
public class HrHandler extends AbstractMoneyHandler {
	protected boolean canHandleRequest(MoneyRequest request) {
		return request.getAmount() <= 1000;
	}

	protected void handleRequest(MoneyRequest request) {
		System.out.println("HrHandler approved the money request for amount: " + request.getAmount());
	}
}
