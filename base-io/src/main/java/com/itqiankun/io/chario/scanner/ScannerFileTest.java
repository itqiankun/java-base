package com.itqiankun.io.chario.scanner;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author: ma_qiankun
 * @date: 2023/8/12
 **/
@Slf4j
public class ScannerFileTest {

	@Test
	public void it_qk1() throws IOException {
		Scanner scanner = new Scanner(new FileInputStream("abc.txt"));
		String next = scanner.next();
		System.out.println(next);
	}

	@Test
	public void it_qk_nextInt() throws IOException {
		Scanner scanner = new Scanner(new FileInputStream("pom.xml"));
		while (scanner.hasNext()){
			String next = scanner.next();
			System.out.println(next);
		}


	}

}
