package com.itqiankun;

import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class StringToList {


    @Test
    public void  it_qk(){
        List<String> strings = Splitter.on(",").splitToList("hello,tom,jack");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
