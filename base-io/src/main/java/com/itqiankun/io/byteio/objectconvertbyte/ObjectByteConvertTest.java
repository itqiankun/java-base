package com.itqiankun.io.byteio.objectconvertbyte;

import org.junit.Test;

import java.io.*;

/**
 * @author: ma_qiankun
 * @date: 2023/9/18
 **/
public class ObjectByteConvertTest {

	@Test
	public void it_qk_object_convert_byte(){
		String str="hello world";
		System.out.println(str);
		byte[] byteArray = objectToByteArray(str);
		System.out.println(byteArray);
		System.out.println(objectToByteArray(byteArray));
	}

	public static byte[] objectToByteArray(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
			oos.close();
			bos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return bytes;
	}

	public static Object objectToByteArray(byte[] bytes) {

		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
