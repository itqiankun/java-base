package com.itqiankun.doubleArray;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/9/18
 **/
public class ByteTest {

	/**
	 * 把一个集合里面的各种类型的每一个数据转成`byte[]`，然后把这个集合的所有数据放到一个`byte[][]`里面
	 */
	@Test
	public void it_qk(){
		List<Object> list = Lists.newArrayList();
		list.add(20);
		list.add("mqk");
		list.add("itqiankun.com");
		list.add(100);
		list.add(true);


		byte[][] rows = new byte[5][]; // 表示存储一行里面的5个数据
		for (int i = 0; i < list.size(); i++) {
			byte[] byteArray = objectToByteArray(list.get(i));
			rows[i] = byteArray;
		}
		for (int i = 0; i < rows.length; i++) {
			System.out.println(objectToByteArray(rows[i]));
		}
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
