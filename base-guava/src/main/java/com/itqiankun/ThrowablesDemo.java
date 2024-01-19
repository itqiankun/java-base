package com.itqiankun;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author ma_qiankun
 * @date 2024/1/19 13:52
 */
@Slf4j
public class ThrowablesDemo {
    @Test
    public void it_qk() {
        try{
            String str = null;
            System.out.println(str.length());
        } catch (Exception e){
            log.warn("fail exception:{}", Throwables.getStackTraceAsString(e));
            log.error("fail", e);
        }
    }


}
