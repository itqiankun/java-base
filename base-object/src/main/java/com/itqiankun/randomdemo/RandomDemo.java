package com.itqiankun.randomdemo;

import org.junit.Test;

import java.util.Random;

/**
 * @author: ma_qiankun
 * @date: 2023/11/1
 **/
public class RandomDemo {
	@Test
	public void it_qk(){
		Random random = new Random();
		System.out.println(random.nextInt());
		System.out.println(random.nextInt());
		System.out.println(random.nextInt());
	}
}
