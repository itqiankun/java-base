package com.itqiankun.nio.selector.serverthreadpool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioPoolServer {
    private static final int SERVER_PORT = 7888;



    public static void main(String[] args) {


        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(SERVER_PORT));
            serverSocketChannel.configureBlocking(false);
            Selector subSelector = Selector.open();
            serverSocketChannel.register(subSelector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器已启动，监听端口：" + SERVER_PORT);

            // 循环处理就绪的事件
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            ReadOrWriteThread command = new ReadOrWriteThread();
            executorService.submit(new AcceptThreadPool(command, subSelector));
            executorService.execute(command);
//            executorService.execute(new ReadOrWriteThreadPool(parentSelector));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
