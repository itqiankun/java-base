package com.itqiankun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class DemoTest {

    @Test
    public void it_qk_TypeVariable_extends() throws Exception {
        MyClass<Number> numberMyClass = new MyClass<>(new Integer(10));
        log.info(numberMyClass.getValue().toString());
        MyClass<Double> doubleMyClass = new MyClass<>(new Double(10D));
        log.info(doubleMyClass.getValue().toString());
    }




}
