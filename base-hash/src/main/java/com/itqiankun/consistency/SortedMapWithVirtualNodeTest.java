package com.itqiankun.consistency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
public class SortedMapWithVirtualNodeTest {

	private static Logger logger = LoggerFactory.getLogger(SortedMapWithVirtualNodeTest.class);

	private static SortedMapWithVirtualNode sortedMapWithVirtualNode = new SortedMapWithVirtualNode();
	// 服务器总数
	private static final int SERVERS_NUM = 100;
	// 每台服务器需要设置的虚拟节点数
	private static final int VIRTUAL_NODES = 10;

	// 待加入 Hash 环的服务器列表
	private static ArrayList<String> serverList = new ArrayList<>();

	private static void init() {
		// 构造服务器数据
		for (int i = 0; i < SERVERS_NUM; i++) {
			String s = new StringBuilder().append("192.168.0.").append(String.valueOf(i)).toString();
			serverList.add(s);
		}
		// 构建 Hash 环
		sortedMapWithVirtualNode.buildHash(new TreeMap<Long, String>());
		// 将服务器的虚拟节点添加到 Hash 环中
		for (String s : serverList) {
			for (int i = 0; i < VIRTUAL_NODES; i++) {
				String VNNode = s + "&&VN" + i;
				sortedMapWithVirtualNode.addServerNode(VNNode);
			}
		}
	}

	public static void main(String[] args) {
		init();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < serverList.size(); i++) {
			map.put(serverList.get(i), 0);
		}
		String[] nodes = new IPAddressGenerate().getIPAddress(10000);
		for (int i = 0; i < nodes.length; i++) {
			String serverIP = sortedMapWithVirtualNode.selectServerNode(nodes[i]);
			map.put(serverIP, map.get(serverIP)+1);
		}

		logger.info("虚拟节点,初始方差: " + Analysis.variance(map.values().stream().collect(Collectors.toList())));
	}



}
