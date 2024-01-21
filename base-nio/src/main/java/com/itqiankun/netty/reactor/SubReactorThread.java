package com.itqiankun.netty.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

public class SubReactorThread extends Thread{
    private Selector selector;
    private ExecutorService businessExecutorPool;
    private List<NioTask> taskList = new ArrayList<NioTask>(512);
    private ReentrantLock taskMainLock = new ReentrantLock();
    /**
     * 业务线程池
     * @param businessExecutorPool
     */
    public SubReactorThread(ExecutorService businessExecutorPool) {
        try {
            this.businessExecutorPool = businessExecutorPool;
            this.selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * socket channel
     *
     */
    public void register(NioTask task) {
        if (task != null) {
            try {
                taskMainLock.lock();
                taskList.add(task);
            } finally {
                taskMainLock.unlock();
            }
        }
    }
    /**
     * 此处的reqBuffer处于可写状态
     * @param sc
     * @param reqBuffer
     */
    private void dispatch(SocketChannel sc, ByteBuffer reqBuffer) {
        businessExecutorPool.submit( new Handler(sc, reqBuffer, this)  );
    }



    public void run() {
        while (!Thread.interrupted()) {
            Set<SelectionKey> ops = null;
            try {
                selector.select(1000);
                ops = selector.selectedKeys();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            // 处理相关事件
            for (Iterator<SelectionKey> it = ops.iterator(); it.hasNext();) {
                SelectionKey key = it.next();
                it.remove();
                try {
                    if (key.isWritable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buf = (ByteBuffer) key.attachment();
                        clientChannel.write(buf);
                        System.out.println("服务端向客户端发送数据。。。");
                        // 重新注册读事件
                        clientChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        System.out.println("SubReactorThread服务端接收客户端连接请求。。。");
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        int rc = clientChannel.read(buf);// 解析请求完毕
                        // 这里会封装一个有`write`事件的`NioTask`
                        dispatch(clientChannel, buf);
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                    System.out.println("客户端主动断开连接。。。。。。。");
                }
            }

            // 处理完事件后，我们还需要处理其他任务
            // 1. 一个是处理`accept`线程接受到的`SocketChannel`，注册`read`事件到`Selector`上面
            // 2. 处理业务线程的执行结果处理，然后注册`write`事件到`Selector`上面
            if (!taskList.isEmpty()) {
                try {
                    taskMainLock.lock();
                    for (Iterator<NioTask> it = taskList
                            .iterator(); it.hasNext();) {
                        NioTask task = it.next();
                        try {
                            SocketChannel sc = task.getSc();
                            // 这里会注册`write事件`到`Selector`上面
                            if(task.getData() != null ) {
                                ByteBuffer byteBuffer = (ByteBuffer)task.getData();
                                byteBuffer.flip();
                                int wc = sc.write(byteBuffer);
                                System.out.println("服务端向客户端发送数据。。。");
                                // 说明写缓存区已满，需要注册写事件
                                if(wc < 1 && byteBuffer.hasRemaining()) {
                                    sc.register(selector, task.getOp(), task.getData());
                                    continue;
                                }
                                byteBuffer = null;
                            } else {
                                // 注册`read`事件到`Selector`上面
                                sc.register(selector, task.getOp());
                            }
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }
                        it.remove();
                    }

                } finally {
                    taskMainLock.unlock();
                }
            }

        }
    }






}
