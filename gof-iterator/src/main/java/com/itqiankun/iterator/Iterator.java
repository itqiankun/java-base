package com.itqiankun.iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/4/4
 **/
public interface Iterator {

    Object next();    //遍历到下一个元素

    boolean hasNext();    //是否已经遍历到尾部
}
