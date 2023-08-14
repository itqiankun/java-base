package com.itqiankun.io.chario.scanner;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author: ma_qiankun
 * @date: 2023/8/12
 **/
@Slf4j
public class ScannerNextTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		System.out.println(next);
	}
}
