package com.itqiankun;

import com.alibaba.fastjson.JSONObject;
import com.itqiankun.common.Children;
import com.itqiankun.common.GenericArrayType.GenericArrayTypeDemo;
import com.itqiankun.common.TypeVariable.MyClass;
import com.itqiankun.common.TypeVariable.MyClassTextends;
import com.itqiankun.common.ParameterizedType.ParameterizedTypeDemo;
import com.itqiankun.common.WildcardType.WildcardTypeDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class DemoTest {

    @Test
    public void it_qk_class() throws Exception {
        // 获取Children类继承的父类的类型
        Type genericSuperclassType = Children.class.getGenericSuperclass();
        System.out.println(genericSuperclassType);

        // 获取Children类实现的接口的类型
        Type[] genericInterfaces = Children.class.getGenericInterfaces();
        System.out.println(Arrays.toString(genericInterfaces));
    }

    @Test
    public void it_qk_instanceof_ParameterizedType() throws Exception {
        Class<ParameterizedTypeDemo> cls = ParameterizedTypeDemo.class;
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " 是否是泛型：" + (field.getGenericType() instanceof ParameterizedType));
        }
    }

    @Test
    public void it_qk_to_ParameterizedType() throws Exception {
        Class<ParameterizedTypeDemo> cls = ParameterizedTypeDemo.class;
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if(field.getGenericType() instanceof ParameterizedType){
                ParameterizedType type = (ParameterizedType) field.getGenericType();
                log.info("{} 的属性为:{}",field.getName(), type.getTypeName());
                Type[] types = type.getActualTypeArguments();
                for (Type t : types) {
                    log.info("真实的泛型的类型为:{}", t.getTypeName());
                }
            }
        }
    }

    @Test
    public void it_qk_to_ParameterizedType_getTypeName() throws Exception {
        Class<ParameterizedTypeDemo> cls = ParameterizedTypeDemo.class;
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if(field.getGenericType() instanceof ParameterizedType){
                ParameterizedType type = (ParameterizedType) field.getGenericType();
                String typeName = type.getRawType().getTypeName();
                log.info("{} 的属性为:{}",field.getName(), typeName);
            }
        }
    }

    @Test
    public void it_qk_TypeVariable() throws Exception {
        TypeVariable<Class<MyClass>>[] typeVariables = MyClass.class.getTypeParameters();

        for (TypeVariable<Class<MyClass>> typeVariable : typeVariables) {
            // 获取类型变量的名称
            String name = typeVariable.getName();
            log.info("Type variable name: {}", name);

            // 获取类型变量的上界
            Type[] bounds = typeVariable.getBounds();
            log.info("Type variable bounds:{}", JSONObject.toJSON(bounds));
        }
    }

    @Test
    public void it_qk_TypeVariable_extends() throws Exception {
        TypeVariable<Class<MyClassTextends>>[] typeVariables = MyClassTextends.class.getTypeParameters();

        for (TypeVariable<Class<MyClassTextends>> typeVariable : typeVariables) {
            // 获取类型变量的名称
            String name = typeVariable.getName();
            log.info("Type variable name: {}", name);

            // 获取类型变量的上界
            Type[] bounds = typeVariable.getBounds();
            log.info("Type variable bounds:{}", JSONObject.toJSON(bounds));
        }
    }


    @Test
    public void test_GenericArrayType(){
        GenericArrayTypeDemo<String,Float> obj = new GenericArrayTypeDemo();
        Class<?> clazz = obj.getClass();
        try {
            printGenericArrayType(clazz.getField("tArray").getGenericType());
            printGenericArrayType(clazz.getField("listTArray").getGenericType());
            printGenericArrayType(clazz.getField("list").getGenericType());
            printGenericArrayType(clazz.getField("map").getGenericType());
            printGenericArrayType(clazz.getField("t").getGenericType());
            printGenericArrayType(clazz.getField("v").getGenericType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    private void printGenericArrayType(Type t){
        System.out.println("------------------------------");
        if (! (t instanceof GenericArrayType)){
            System.out.println(t.getTypeName() + " is not GenericArrayType");
            return;
        }
        GenericArrayType type   = (GenericArrayType) t;
        String typeName         = type.getTypeName();
        Type componentType      = type.getGenericComponentType();
        System.out.println("typeName      = " + typeName);
        System.out.println("componentType = " + componentType.getTypeName());
    }

    @Test
    public void test_WildcardTypeDemo(){
        WildcardTypeDemo<String, Float> obj = new WildcardTypeDemo();
        Class<?> clazz = obj.getClass();
        try {
            printWildcardType(clazz.getField("demo").getGenericType());
            printWildcardType(clazz.getField("mapWithWildcard").getGenericType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
    private void printWildcardType(Type t){
        System.out.println("------------------------------");
        if (!(t instanceof ParameterizedType)){
            System.out.println(t.getTypeName() + " is not WildcardType");
            return;
        }
        ParameterizedType type  = (ParameterizedType) t;
        String typeName         = type.getTypeName();
        Type[] actual           = type.getActualTypeArguments();

        System.out.println("typeName      = " + typeName);

        if (actual.length > 0){
            for (int i = 0 ; i < actual.length; ++i){
                Type at = actual[i];
                System.out.println("actual[ " + i + " ] = " + at.getTypeName());
                if (!(at instanceof WildcardType)){
                    System.out.println("    it is not WildcardType");
                    continue;
                }
                WildcardType wildcardType = (WildcardType) at;
                Type[] lower              = wildcardType.getLowerBounds();
                Type[] upper              = wildcardType.getUpperBounds();

                if (lower.length > 0){
                    for (int j = 0 ; j < lower.length; ++j){
                        System.out.println("    lower[ " + j + " ] = " + lower[j].getTypeName());
                    }
                }
                if (upper.length > 0){
                    for (int k = 0 ; k < upper.length; ++k){
                        System.out.println("    upper[ " + k + " ] = " + upper[k].getTypeName());
                    }
                }
            }
        }
    }




}
