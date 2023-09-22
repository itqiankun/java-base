package com.itqiankun;


import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;

/**
 * @author: ma_qiankun
 * @date: 2023/9/20
 **/
public class PropertyEditorNoFieldExample {

	public String getName() {
		return null;
	}

	public void setName(String cc) {
		System.out.println("PropertyDescriptor调用setName(), 入参:"+cc);
	}

	public static void main(String[] args) throws Exception {
		// 定义一个属性变量名是name的对象，这里`PropertyEditorExample`类里面可以没有`name`属性
		PropertyDescriptor descriptor = new PropertyDescriptor("name", PropertyEditorNoFieldExample.class);

		PropertyEditor editor = PropertyEditorManager.findEditor(String.class);
		editor.setAsText("John Doe");
		Object value = editor.getValue();
		PropertyEditorNoFieldExample example = new PropertyEditorNoFieldExample();
		descriptor.getWriteMethod().invoke(example, value); // 这里就是相当于调用PropertyEditorExample.setName();

		System.out.println(example.getName());
	}
}

