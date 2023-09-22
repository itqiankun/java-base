package com.itqiankun;


import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;

/**
 * @author: ma_qiankun
 * @date: 2023/9/20
 **/
public class PropertyEditorExample {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String nameArg) {
		System.out.println("PropertyDescriptor调用setName(), 入参:"+nameArg);
		this.name = nameArg;
	}

	public static void main(String[] args) throws Exception {
		// 定义一个属性变量名是name的对象，这里`PropertyEditorExample`类里面可以没有`name`属性
		PropertyDescriptor descriptor = new PropertyDescriptor("name", PropertyEditorExample.class);

		PropertyEditor editor = PropertyEditorManager.findEditor(String.class);
		editor.setAsText("John Doe");
		Object value = editor.getValue();
		PropertyEditorExample example = new PropertyEditorExample();
		descriptor.getWriteMethod().invoke(example, value); // 这里就是相当于调用PropertyEditorExample.setName();

		System.out.println(example.getName());
	}
}

