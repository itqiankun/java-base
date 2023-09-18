package com.itqiankun.advanced;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new ChildStrategy());
        context.actionActivity();


//        Context contextTwo = new Context(new WorkerStrategy());
//        contextTwo.actionActivity();
    }
}
