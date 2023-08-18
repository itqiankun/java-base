package com.itqiankun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: ma_qiankun
 * @date: 2023/8/18
 **/
@Slf4j
public class ExceptionDemo {


	@Test
	public void it_qk_runtime_exception(){
		String string = null;
		log.info("runtime exception :{}", string.length());
	}


	@Test
	public void it_qk_not_runtime_exception() throws FileNotFoundException, IOException {
		FileInputStream inputStream = new FileInputStream("it_qk.txt");
		log.info("runtime exception :{}", inputStream.read());
	}
}
