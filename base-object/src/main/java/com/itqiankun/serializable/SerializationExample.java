package com.itqiankun.serializable;

import java.io.*;

/**
 * @author: ma_qiankun
 * @website: itqiankun.com
 * @date: 2023/6/22
 **/
public class SerializationExample {
	public static void main(String[] args) {
		ItQKClass obj = new ItQKClass("itqiankun.com", 10);

		// 序列化对象
		try {
			FileOutputStream fileOut = new FileOutputStream("serializedObject.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			System.out.println("Serialized object saved to serializedObject.ser");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 反序列化对象
		try {
			FileInputStream fileIn = new FileInputStream("serializedObject.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ItQKClass deserializedObj = (ItQKClass) in.readObject();
			System.out.println("Deserialized object: " + deserializedObj);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}