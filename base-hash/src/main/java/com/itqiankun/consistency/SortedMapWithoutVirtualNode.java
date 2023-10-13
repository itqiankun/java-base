package com.itqiankun.consistency;

import lombok.Data;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
@Data
public class SortedMapWithoutVirtualNode implements LoadBalancer {

	private TreeMap<Long, String> treeMapHash;


	@Override
	public void addServerNode(String serverNodeName) {
		Long hash = new KetamaHash().hashKey(serverNodeName);
		treeMapHash.put(hash, serverNodeName);
	}

	@Override
	public String selectServerNode(String requestURL) {
		Long hash = new KetamaHash().hashKey(requestURL);
		Map.Entry<Long, String> subEntry= treeMapHash.ceilingEntry(hash);
		subEntry = subEntry == null ? treeMapHash.firstEntry() : subEntry;
		return subEntry.getValue();
	}

	// 构建 Hash 环
	public SortedMap<Long, String> buildHash(TreeMap<Long, String> treeMap) {
		this.treeMapHash = treeMap;
		return treeMapHash;
	}
}

