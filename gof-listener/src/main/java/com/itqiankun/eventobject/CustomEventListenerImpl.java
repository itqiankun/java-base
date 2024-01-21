package com.itqiankun.eventobject;

/**
 * @author: ma_qiankun
 * @date: 2023/9/5
 **/
public class CustomEventListenerImpl implements CustomEventListener {
	@Override
	public void customEventListen(CustomEvent event) {
		// 处理事件逻辑
		System.out.println("CustomEventListenerImpl 执行触发逻辑 customEventListen()");
	}
}
