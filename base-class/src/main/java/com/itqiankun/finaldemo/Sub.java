package com.itqiankun.finaldemo;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/4/26
 **/
@Slf4j
public class Sub implements Father{
    public void name(){
        System.out.println("sub");
    }
    @Deprecated
    public void subMethod1(){
        System.out.println("sub");
    }

    public void subMethodParam(String hello, Integer num, Person person){
        System.out.println("sub");
    }

    @Test
    public void it_qk_class_name() {
        Class<Sub> subClass = Sub.class;
        System.out.println(subClass.getName());
    }

    @Test
    public void it_qk_class_console() {
        Class<Sub> subClass = Sub.class;
        System.out.println(subClass);
        System.out.println(subClass.getName());
    }

    @Test
    public void it_qk_class_instance() {
        Class<Sub> subClass = Sub.class;
        try {
            Sub sub = subClass.newInstance();
            System.out.println(sub);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void it_qk_method_name() {
        Class<Sub> subClass = Sub.class;
        Method[] methods = subClass.getMethods();
        List<Method> list = Arrays.asList(methods);
        for (int i = 0; i < list.size(); i++) {
            Method method = list.get(i);
            System.out.println(method.getName());
        }
    }


    @Test
    public void it_qk_method_getClass() {
        Class<Sub> subClass = Sub.class;
        Method[] methods = subClass.getMethods();
        List<Method> list = Arrays.asList(methods);
        for (int i = 0; i < list.size(); i++) {
            Method method = list.get(i);
            log.info("当前方法:{}, 当前类:{}",method.getName(), method.getDeclaringClass().getName());
        }
    }

    @Test
    public void it_qk_method_annotation() {
        Class<Sub> subClass = Sub.class;
        Method[] methods = subClass.getMethods();
        List<Method> list = Arrays.asList(methods);
        for (int i = 0; i < list.size(); i++) {
            Method method = list.get(i);
            Deprecated annotation = method.getAnnotation(Deprecated.class);
            System.out.println(annotation);
        }

    }



    @Test
    public void it_qk_method_param() {
        Class<Sub> subClass = Sub.class;
        Method[] methods = subClass.getMethods();
        List<Method> list = Arrays.asList(methods);
        for (int i = 0; i < list.size(); i++) {
            Method method = list.get(i);
            Class<?>[] parameterTypes = method.getParameterTypes();
            if(ObjectUtil.isNotEmpty(parameterTypes)){
                List<Class<?>> params = Arrays.asList(parameterTypes);
                for (int y = 0; y < params.size(); y++) {
                    Class<?> aClass = params.get(y);
                    System.out.println(aClass.getName());
                }
            }
        }
    }
}


