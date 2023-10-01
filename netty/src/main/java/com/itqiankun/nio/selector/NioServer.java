package com.itqiankun.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/6/7
 **/
public class NioServer {

    public static void main(String[] args) {
        try {
            openServer(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openServer(int port) throws IOException {
        //打开通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //设置为非阻塞
        ssChannel.configureBlocking(false);
        //绑定端口
        ssChannel.socket().bind(new InetSocketAddress(port));
        //选择器
        Selector selector = Selector.open();
        //把通道接受事件注册到选择器
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //当被选中的通道个数大于0时，进行业务处理
        while (selector.select() > 0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey sk = it.next();
                if(sk.isAcceptable()){
                    //得到发出请求连接的通道
                    ServerSocketChannel channel = (ServerSocketChannel) sk.channel();
                    SocketChannel sChannel = channel.accept();
                    //通道设置非阻塞
                    sChannel.configureBlocking(false);
                    //把通道读事件注册到选择器
                    sChannel.register(selector, SelectionKey.OP_READ);
                }
                else if(sk.isReadable()){
                    // 得到发出读请求的通道
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    // 定义一个缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int len = 0;
                    // len为0时，无数据可读；len为-1时，客户端关闭了socket
                    while ((len = sChannel.read(buffer)) > 0){
                        // 更改缓冲区为读模式
                        buffer.flip();
                        String str = new String(buffer.array(), 0, len);
                        System.out.println(str);
                        // 清空缓冲区
                        buffer.clear();
                    }
                    // 写响应数据
                    buffer.put("server response".getBytes());
                    buffer.flip();
                    sChannel.write(buffer);
                    buffer.clear();

                    if (len == -1){
                        sChannel.close();
                    }
                }
                // 取消
                it.remove();
            }
        }
    }

}