package com.itqiankun.io.scanner;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author: ma_qiankun
 * @date: 2023/8/12
 **/
@Slf4j
public class ScannerDemoTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("请输入一个整数：");
		int number = scanner.nextInt();
		System.out.println("你输入的整数是：" + number);

		System.out.print("请输入一个字符串：");
		String text = scanner.next();
		System.out.println("你输入的字符串是：" + text);

		scanner.close();
	}
}
