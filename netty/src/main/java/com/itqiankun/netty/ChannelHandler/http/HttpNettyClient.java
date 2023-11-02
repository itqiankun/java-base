package com.itqiankun.netty.ChannelHandler.http;

import com.itqiankun.netty.ChannelHandler.string.MyStringEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.CountDownLatch;

/**
 * @author: ma_qiankun
 * @date: 2023/10/9
 **/
public class HttpNettyClient {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		EventLoopGroup group = new NioEventLoopGroup(1);
		try {
			Bootstrap bootstrap = new Bootstrap();
			//设置参数
			bootstrap.group(group)
					.channel(NioSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO))
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ChannelPipeline pipeline = ch.pipeline();
							//添加编解码器
							pipeline.addLast(new MyStringEncoder());
						}
					});
			System.out.println("客户端启动了");
			ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9090).sync();
			channelFuture.channel().writeAndFlush("hello world !").addListener((ChannelFutureListener) f -> {
				System.out.println(f.isSuccess());
			});
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}

	}
}
