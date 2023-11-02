package com.itqiankun;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class DemoTest {

    @Test
    public void it_qk() throws Exception {
        AtomicInteger idx = new AtomicInteger();
        List<String> arrayList = Lists.newArrayList();
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("!");

        for (int i = 0; i < 100; i++) {
            System.out.println(arrayList.get(idx.getAndIncrement() % arrayList.size()));
        }
    }

    @Test
    public void it_qk_() {
        AtomicInteger idx = new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            System.out.println(idx.getAndIncrement() % 10);
        }
    }

    @Test
    public void it_qk_1() throws Exception {
        int num = 5;
        int result = num << 2;
        System.out.println(result);  // 输出 20
    }

    @Test
    public void it_qk_2() throws Exception {
        int num = 5;
        int result = num << 3;
        System.out.println(result);  // 输出 5 * 2^3 =40
    }

    @Test
    public void it_qk_3() throws Exception {
        int num = 40;
        int result = num >>> 3;
        System.out.println(result);  // 输出 5
    }
}
