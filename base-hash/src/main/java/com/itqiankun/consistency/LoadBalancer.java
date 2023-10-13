package com.itqiankun.consistency;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
public interface LoadBalancer {

	// 添加服务器节点
	void addServerNode(String serverNodeName);

	// 选择服务器节点
	String selectServerNode(String requestURL);
}