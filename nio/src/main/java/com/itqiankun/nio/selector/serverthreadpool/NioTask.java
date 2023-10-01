package com.itqiankun.nio.selector.serverthreadpool;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.channels.SocketChannel;

/**
 * @author: ma_qiankun
 * @date: 2023/10/1
 **/
@Data
@AllArgsConstructor
public class NioTask {
	private SocketChannel sc;
}
