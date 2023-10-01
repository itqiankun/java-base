package com.itqiankun.nio.selector.selectortomanythreadproblem;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j
public class NioServer {
    private static final int SERVER_PORT = 7888;


    public static void main(String[] args) {

        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(SERVER_PORT));
            serverSocketChannel.configureBlocking(false);
            Selector subSelector = Selector.open();
            Selector parentSelector = Selector.open();
            serverSocketChannel.register(subSelector, SelectionKey.OP_ACCEPT);
            log.info("服务器已启动，监听端口：" + SERVER_PORT);
            // 循环处理就绪的事件
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            executorService.submit(new AcceptPool( subSelector, parentSelector));
            executorService.submit(new ServerThread(parentSelector));
            executorService.submit(new ServerThread(parentSelector));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
