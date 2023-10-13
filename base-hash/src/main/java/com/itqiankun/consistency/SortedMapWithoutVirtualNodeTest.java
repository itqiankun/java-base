package com.itqiankun.consistency;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
public class SortedMapWithoutVirtualNodeTest {

	private static Logger logger = LoggerFactory.getLogger(SortedMapWithoutVirtualNodeTest.class);

	private static SortedMapWithoutVirtualNode sortedMapWithoutVirtualNode = new SortedMapWithoutVirtualNode();

	// Hash 环
	// 服务器总数
	private static final int SERVERS_NUM = 100;

	// 待加入 Hash 环的服务器列表
	private static ArrayList<String> servers = new ArrayList<>();

	private static void init() {
		// 构造服务器数据
		for (int i = 0; i < SERVERS_NUM; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			servers.add(stringBuilder.append("192.168.0.").append(i).toString());
		}
		// 构建 Hash 环
		sortedMapWithoutVirtualNode.buildHash(new TreeMap<>());
		// 将服务器添加到 Hash 环中
		for (int i = 0; i < SERVERS_NUM; i++) {
			sortedMapWithoutVirtualNode.addServerNode(servers.get(i));
		}
	}

	@Test
	public void it_qk(){
		init();
		String[] nodes = new IPAddressGenerate().getIPAddress(10000);
		// <服务器信息，请求命中次数>
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < servers.size(); i++) {
			map.put(servers.get(i), 0);
		}

		for (int i = 0; i < nodes.length; i++) {
			String serverIP = sortedMapWithoutVirtualNode.selectServerNode(nodes[i]);
			// 记录各个服务器上面命中的次数
			map.put(serverIP, map.get(serverIP)+1);
		}

		double analysis = Analysis.variance(map.values().stream().collect(Collectors.toList()));
		logger.info("初始方差: " + analysis);
	}
}