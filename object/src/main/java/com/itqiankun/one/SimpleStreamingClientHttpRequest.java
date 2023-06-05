package com.itqiankun.one;

/**
 * @author: ma_qiankun
 * @date: 2023/6/5
 **/
public class SimpleStreamingClientHttpRequest extends AbstractClientHttpRequest{
    @Override
    protected void executeInternal() {
        System.out.println("SimpleStreamingClientHttpRequest execute executeInternal().");
    }


    public static void main(String[] args) {
        ClientHttpRequest simpleStreamingClientHttpRequest = new SimpleStreamingClientHttpRequest();
        simpleStreamingClientHttpRequest.execute();
    }
}
