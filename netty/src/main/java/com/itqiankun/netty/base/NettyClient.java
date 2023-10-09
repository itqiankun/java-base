package com.itqiankun.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author: ma_qiankun
 * @date: 2023/10/9
 **/
public class NettyClient {
	public static void main(String[] args) {
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
							pipeline.addLast(new StringDecoder());
							pipeline.addLast(new StringEncoder());
						}
					});
			System.out.println("客户端启动了");
			ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9090).sync();
			channelFuture.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}

	}
}
