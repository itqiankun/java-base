package com.itqiankun.methodparamdemo;

import java.lang.reflect.Method;

/**
 * @author: ma_qiankun
 * @date: 2023/9/21
 **/
public class FinalMethodDemo {

	public void say(){
		System.out.println("say()");
	}

	public final void sayFinal(){
		System.out.println("sayFinal()");
	}

	public static void main(String[] args) throws Exception {
		Class<FinalMethodDemo> finalMethodDemoClass = FinalMethodDemo.class;
		FinalMethodDemo finalMethodDemo = finalMethodDemoClass.newInstance();
		Method[] methods =
				finalMethodDemoClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if(method.getName().contains("say")){
				method.invoke(finalMethodDemo, null);
			}
		}
	}
}
