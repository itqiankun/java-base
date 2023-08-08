package com.itqiankun.extend;

/**
 * @author: ma_qiankun
 * @date: 2023/4/26
 **/
public class Sub implements Father{
    public void name(){
        System.out.println("sub");
    }

    public static void main(String[] args) {
        Father sub = new Sub();
        System.out.println(sub instanceof Father); // true
    }
}


