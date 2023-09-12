package com.itqiankun.eventobject;

/**
 * @author: ma_qiankun
 * @date: 2023/9/5
 **/
public class Test {
	public static void main(String[] args) {
		EventSource eventSource = new EventSource();
		CustomEventListener listener = new CustomEventListenerImpl();
		eventSource.addCustomEventListener(listener);
		// 创建事件对象
		CustomEvent event = new CustomEvent(eventSource);
		// 触发事件
		eventSource.triggerEvent(event);
	}
}
