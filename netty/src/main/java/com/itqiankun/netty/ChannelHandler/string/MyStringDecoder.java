package com.itqiankun.netty.ChannelHandler.string;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/10/19
 **/
@Slf4j
public class MyStringDecoder extends StringDecoder {

	public MyStringDecoder(){
		super();
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		log.info("手动请求:{}", msg);
		super.decode(ctx, msg, out);
	}
}
