package com.itqiankun.io.chario.printwriter;

import org.junit.Test;

import java.io.*;

/**
 * @author: ma_qiankun
 * @date: 2023/8/14
 **/
public class PrintWriterDemo {
	@Test
	public void it_qk_print_writer_out_file() throws Exception {
		PrintWriter printWriter = new PrintWriter("it_qk_print_writer_out_file.txt");
		printWriter.write("welcome");
		printWriter.close();
	}
}
