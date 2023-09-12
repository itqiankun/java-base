package com.itqiankun.AnnotatedElement;

/**
 * @author: ma_qiankun
 * @date: 2023/9/5
 **/
public interface OrderListener {
	public void listenCreate(OrderEvent event);
	public void listenFinish(OrderEvent event);
}