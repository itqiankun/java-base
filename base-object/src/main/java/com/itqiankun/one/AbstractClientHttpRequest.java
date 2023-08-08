package com.itqiankun.one;

import java.io.IOException;

/**
 * @author: ma_qiankun
 * @date: 2023/6/5
 **/
public abstract class AbstractClientHttpRequest implements ClientHttpRequest{

    @Override
    public final void execute()  {
        System.out.println("AbstractClientHttpRequest execute execute().");
        executeInternal();
    }


    protected abstract void executeInternal();
}
