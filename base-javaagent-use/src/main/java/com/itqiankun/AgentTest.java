package com.itqiankun;

import java.util.concurrent.TimeUnit;

/**
 * author: ma_qiankun
 * date:  2023/12/31
 **/
public class AgentTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main()");
		AgentTest agentTest = new AgentTest();
		agentTest.say();
	}

	public  void say() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
	}

}
