package com.itqiankun.methodparamdemo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author: ma_qiankun
 * @date: 2023/9/22
 **/
public class MethodModifiersDemo {
	public void sayPublic(){
		System.out.println("sayPublic");
	}
	private void sayPrivate(){
		System.out.println("sayPrivate");
	}
	protected void sayProtected(){
		System.out.println("sayProtected");
	}

	public static void main(String[] args) throws Exception {
		Class<MethodModifiersDemo> methodModifiersDemoClass = MethodModifiersDemo.class;
		Method[] methods =
				methodModifiersDemoClass.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if(method.getName().contains("say")){
				if(Modifier.isPublic(method.getModifiers())){
					System.out.println("public修饰:"+method.getName());
					System.out.println(method.getModifiers());
				} else if(Modifier.isPrivate(method.getModifiers())){
					System.out.println("private修饰:"+method.getName());
					System.out.println(method.getModifiers());
				} else if (Modifier.isProtected(method.getModifiers())){
					System.out.println("protected修饰:"+method.getName());
					System.out.println(method.getModifiers());
				}
			}
		}
	}
}
