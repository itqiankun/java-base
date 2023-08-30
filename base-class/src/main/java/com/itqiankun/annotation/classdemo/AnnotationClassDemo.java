package com.itqiankun.annotation.classdemo;

import com.alibaba.fastjson.JSONObject;
import com.itqiankun.annotation.MethodAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

/**
 * @author: ma_qiankun
 * @date: 2023/8/22
 **/
@Slf4j
public class AnnotationClassDemo {

	@Test
	public void it_qk_demo() throws NoSuchMethodException {
		MyClass myClass = new MyClass();
		Annotation[] annotations = myClass.getClass().getAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			Annotation annotation = annotations[i];
			log.info("annotation result:{}", JSONObject.toJSON(annotation));
		}
	}
}
