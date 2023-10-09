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
}
