package com.itqiankun.advanced;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
public class AbstractMoneyHandler {
	private AbstractMoneyHandler nextHandler;

	public void setNextHandler(AbstractMoneyHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public void processRequest(MoneyRequest request) {
		if (canHandleRequest(request)) {
			handleRequest(request);
		} else if (nextHandler != null) {
			nextHandler.processRequest(request);
		} else {
			System.out.println("No handler available for the request.");
		}
	}

	protected boolean canHandleRequest(MoneyRequest request) {
		return false;
	}

	protected void handleRequest(MoneyRequest request) {

	}
}
