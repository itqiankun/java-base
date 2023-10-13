package com.itqiankun.consistency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
public class SortedMapWithVirtualNode implements LoadBalancer {

	private static Logger logger = LoggerFactory.getLogger(SortedMapWithVirtualNode.class);

	private TreeMap<Long, String> treeMapHash;

	@Override
	public void addServerNode(String serverNodeName) {
		long l = new KetamaHash().hashKey(serverNodeName);
		treeMapHash.put(l, serverNodeName);
	}

	@Override
	public String selectServerNode(String requestURL) {
		long hash = new KetamaHash().hashKey(requestURL);
		Map.Entry<Long, String> subEntry = treeMapHash.ceilingEntry(hash);
		subEntry = subEntry == null ? treeMapHash.firstEntry() : subEntry;
		String node = subEntry.getValue();
		// 这里直接切割，因为所有的节点都是带了`&&`
		return node.substring(0, node.indexOf("&&"));
	}

	// 构建 Hash 环
	public SortedMap<Long, String> buildHash(TreeMap<Long, String> treeMap) {
		this.treeMapHash = treeMap;
		return treeMapHash;
	}
}