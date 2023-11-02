package com.itqiankun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class UnsafeExample {

    private String str;
    private int num;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Unsafe unsafe = createUnsafe();
        Field field = UnsafeExample.class.getDeclaredField("str");
        Field numField = UnsafeExample.class.getDeclaredField("num");
        long offset = unsafe.objectFieldOffset(field);
        System.out.println(offset);
        long numFieldOffset = unsafe.objectFieldOffset(numField);
        System.out.println(numFieldOffset);
        UnsafeExample example = new UnsafeExample();
        // 这里用的是`putObject()`
        unsafe.putObject(example, offset, "hello");
        // 这里用的是`putInt()`
        unsafe.putInt(example, numFieldOffset, 2);
        System.out.println(example.str);
        System.out.println(example.num);

    }

    public static Unsafe createUnsafe() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            return unsafe;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void it_qk(){
        Unsafe unsafe = createUnsafe();
        System.out.println(unsafe);
    }





}
