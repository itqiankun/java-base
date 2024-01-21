package com.itqiankun.functioninterface;

import cn.hutool.core.lang.copier.Copier;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author: ma_qiankun
 * @date: 2023/10/24
 **/
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "hello";
        String s = stringSupplier.get();
        System.out.println(s);
    }

    @Test
    public void it_qk_supper(){
        // 定义一个返回当前时间的 Supplier
        Supplier<String> currentTimeSupplier = () -> {
            // 在 get() 方法中提供当前时间
            return "当前时间：" + System.currentTimeMillis();
        };

        // 调用 get() 方法获取当前时间
        String currentTime = currentTimeSupplier.get();
        System.out.println(currentTime);
    }
    @Test
    public void it_qk_supper_object(){
        Supplier<SupplierPerson> currentTimeSupplier = () -> {
            SupplierPerson supplierPerson = new SupplierPerson();
            supplierPerson.setName("tom");
            return supplierPerson;
        };

        SupplierPerson supplierPerson = currentTimeSupplier.get();
        System.out.println(supplierPerson);
    }
    @Test
    public void it_qk_supper_no_(){
        Supplier<String> stringSupplier = () -> "hello";
        String s = stringSupplier.get();
        System.out.println(s);
    }

    @Test
    public void it_qk_supper_get_method(){
        Supplier<String> stringSupplier = () -> getStrMethod();
        stringSupplier.get();
        stringSupplier.get();
    }

    public String getStrMethod() {
        System.out.println("method");
        return "hello";
    }
}


