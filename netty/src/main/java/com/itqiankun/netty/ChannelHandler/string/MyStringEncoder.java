package com.itqiankun.netty.ChannelHandler.string;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/10/19
 **/
@Slf4j
public class MyStringEncoder extends StringEncoder {

	public MyStringEncoder(){
		super();
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, CharSequence msg, List<Object> out) throws Exception {
		log.info("request info:{}", msg);
		super.encode(ctx, msg, out);
	}
}
