package com.itqiankun.eventobject;

import java.util.EventObject;

/**
 * @author: ma_qiankun
 * @date: 2023/9/5
 **/
public class CustomEvent extends EventObject {

	public CustomEvent(Object source) {
		super(source);
	}

}