package com.itqiankun.extendsdemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/4/26
 **/
@Slf4j
@Data
public class Sub extends Father {
    public Person person;
    public String name;
    private int age;
}


