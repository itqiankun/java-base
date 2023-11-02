package com.itqiankun.manysymbol;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/10/24
 **/
@Slf4j
public class ManySymbolDemo {

    @Test
    public void it_qk(){
        Integer num= 10;
        Integer d , f;
        if ((d = num) != 10) {
            log.info("d result:{}", d);
        } else if((f = num) == 10){
            log.info("f result:{}", f);
        }
    }
}
