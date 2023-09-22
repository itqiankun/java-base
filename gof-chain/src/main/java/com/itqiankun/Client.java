package com.itqiankun;

import com.itqiankun.advanced.*;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
public class Client {
	public static void main(String[] args) {
		AbstractMoneyHandler hrHandler = new HrHandler();
		AbstractMoneyHandler managerHandler = new ManagerHandler();
		AbstractMoneyHandler ceoHandler = new CeoHandler();

		hrHandler.setNextHandler(managerHandler);
		managerHandler.setNextHandler(ceoHandler);

		MoneyRequest request1 = new MoneyRequest(500);
		MoneyRequest request2 = new MoneyRequest(2500);
		MoneyRequest request3 = new MoneyRequest(15000);

		hrHandler.processRequest(request1);
		hrHandler.processRequest(request2);
		hrHandler.processRequest(request3);
	}
}
