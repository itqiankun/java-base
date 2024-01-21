package com.itqiankun;

import javassist.ClassPool;
import javassist.CtClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class JavaAssistDemo {

    @Test
    public void it_qk() throws Exception {
        String classStr = "public class Demo{}";
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass(classStr);
        Class<?> aClass = ctClass.toClass();
        System.out.println(aClass.newInstance());
    }



}
