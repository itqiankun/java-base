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
    public void it_qk() throws Exception {
        {
            int result =0;
            log.info("result:{}", result);
        }

        {
            int result =0;
            log.info("result:{}", result);
        }
    }

    @Test
    public void it_qk_many_(){
        Integer num= 10;
        Integer d , f;
        d=num;
        f=num;
        log.info("d result:{}, f result:{}", d, f);
    }


    @Test
    public void it_qk_many_left_part(){
        for (int j = 1; j <= 31; j++) {
            log.info("1 << {} result:{}", j, 1 << j);
        }
        System.out.println(1 << 31);
    }


}
