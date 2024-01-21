package com.itqiankun.eventobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/9/5
 **/
public class EventSource {
	private List<CustomEventListener> listeners = new ArrayList<>();

	public void addCustomEventListener(CustomEventListener listener) {
		listeners.add(listener);
	}

	public void triggerEvent(CustomEvent event) {
		System.out.println("事件源执行时间");

		for (CustomEventListener listener : listeners) {
			listener.customEventListen(event);
		}
	}
}