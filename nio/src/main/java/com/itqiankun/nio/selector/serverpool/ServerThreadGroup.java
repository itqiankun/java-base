package com.itqiankun.nio.selector.serverpool;

import lombok.Data;

/**
 * @author: ma_qiankun
 * @date: 2023/10/1
 **/
@Data
public class ServerThreadGroup {

	private  ServerThread[] serverThreads = new ServerThread[10];


	public ServerThreadGroup(){
		for (int i = 0; i < serverThreads.length; i++) {
			ServerThread serverThread = new ServerThread();
			new Thread(serverThread).start();
			serverThreads[i] = serverThread;
		}
	}




}
