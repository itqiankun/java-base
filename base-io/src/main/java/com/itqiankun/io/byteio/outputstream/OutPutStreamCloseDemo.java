package com.itqiankun.io.byteio.outputstream;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ma_qiankun
 * @date: 2023/8/8
 **/
public class OutPutStreamCloseDemo {

	/**
	 * 相对路径，不带文件夹的文件不存在，自动创建文件
	 * @throws IOException
	 */
	@Test
	public void it_qk2() {
		try(FileOutputStream outputStream = new FileOutputStream("auto_file.txt");) {
			outputStream.write(97);
			outputStream.write(98);
			outputStream.write(99);

		} catch (Exception e){
			e.printStackTrace();
		}


	}


}
