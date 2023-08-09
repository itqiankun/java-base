package com.itqiankun.io.print;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author: ma_qiankun
 * @date: 2023/8/8
 **/
@Slf4j
public class PrintStreamDemo {

	@Test
	public void it_qk() throws FileNotFoundException {
		PrintStream ps = null;
		ps = new PrintStream(new FileOutputStream("it_qk.txt"));
		ps.print("welcome ");
		ps.println("https://itqiankun.com");
		ps.close();
	}


	@Test
	public void it_qk1() throws FileNotFoundException {
		PrintStream ps = null ;
		ps = new PrintStream(new FileOutputStream("it_qk1.txt"));
		String name = "mqk" ;
		int age = 23 ;
		ps.printf("姓名：%s；年龄：%d",name,age) ;
	}

}
