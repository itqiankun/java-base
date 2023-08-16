package com.itqiankun.implementsdemo;

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
public class SubImpl implements FatherInterface {
    public void name(){
        System.out.println("sub");
    }
    private void  privateName(){
        System.out.println("sub");
    }
    @Deprecated
    public void subMethod1(){
        System.out.println("sub");
    }

    @Test
    public void it_qk_class_name() {
        Class<SubImpl> subClass = SubImpl.class;
        System.out.println(subClass.getName());
    }

    @Test
    public void it_qk_class_console() {
        Class<SubImpl> subClass = SubImpl.class;
        System.out.println(subClass);
        System.out.println(subClass.getName());
    }

    @Test
    public void it_qk_class_instance() {
        Class<SubImpl> subClass = SubImpl.class;
        try {
            SubImpl subImpl = subClass.newInstance();
            System.out.println(subImpl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void it_qk_method_name() {
        Class<SubImpl> subClass = SubImpl.class;
        Method[] methods = subClass.getMethods();
        List<Method> list = Arrays.asList(methods);
        for (int i = 0; i < list.size(); i++) {
            Method method = list.get(i);
            log.info("当前方法:{}, 当前类:{}",method.getName(), method.getDeclaringClass().getName());
        }
    }

    @Test
    public void it_qk_getDeclaredMethods_name() {
        Class<SubImpl> subClass = SubImpl.class;
        Method[] methods = subClass.getDeclaredMethods();
        List<Method> list = Arrays.asList(methods);
        for (int i = 0; i < list.size(); i++) {
            Method method = list.get(i);
            log.info("当前方法:{}, 当前类:{}",method.getName(), method.getDeclaringClass().getName());
        }
    }


    @Test
    public void it_qk_method_getClass() {
        Class<SubImpl> subClass = SubImpl.class;
        Method[] methods = subClass.getMethods();
        List<Method> list = Arrays.asList(methods);
        for (int i = 0; i < list.size(); i++) {
            Method method = list.get(i);
            log.info("当前方法:{}, 当前类:{}",method.getName(), method.getDeclaringClass().getName());
        }
    }

    @Test
    public void it_qk_method_annotation() {
        Class<SubImpl> subClass = SubImpl.class;
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
        Class<SubImpl> subClass = SubImpl.class;
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


