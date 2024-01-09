package com.itqiankun.optional;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

@Slf4j
public class OptionalDemo {


    @Test
    public void it_qk(){
        String str = null;
        Optional<String> optionalS =  Optional.ofNullable(str);
        System.out.println(optionalS.isPresent());
        String strHello = "hello";
        Optional<String> optional =  Optional.ofNullable(strHello);
        System.out.println(optional.isPresent());
    }
}
