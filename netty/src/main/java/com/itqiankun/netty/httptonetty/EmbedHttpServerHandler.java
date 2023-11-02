package com.itqiankun.netty.httptonetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ma_qiankun
 * @date: 2023/10/17
 **/
public class EmbedHttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
	private static final Logger logger = LoggerFactory.getLogger(EmbedHttpServerHandler.class);


	public EmbedHttpServerHandler() {
	}

	@Override
	protected void channelRead0(final ChannelHandlerContext ctx, FullHttpRequest httpRequest) throws Exception {
		String requestData = httpRequest.content().toString(CharsetUtil.UTF_8);
		String uri = httpRequest.uri();
		HttpMethod httpMethod = httpRequest.method();
		logger.info("httpMethod:{}", httpMethod);
		logger.info("uri:{}", uri);
		logger.info("request:{}", requestData);
	}


	@Override
	public void channelReadComplete(ChannelHandlerContext ctx)  {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		logger.error(">>>>>>>>>>> xxl-job provider netty_http server caught exception", cause);
		ctx.close();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			ctx.channel().close();      // beat 3N, close if idle
			logger.debug(">>>>>>>>>>> xxl-job provider netty_http server close an idle channel.");
		} else {
			super.userEventTriggered(ctx, evt);
		}
	}
}
