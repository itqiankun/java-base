package com.itqiankun.netty.httptonetty;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: ma_qiankun
 * @date: 2023/10/17
 **/
public class EmbedHttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
	private static final Logger logger = LoggerFactory.getLogger(EmbedHttpServerHandler.class);

	private ExecutorService bizThreadPool;

	public EmbedHttpServerHandler() {
		this.bizThreadPool = Executors.newFixedThreadPool(10);
	}

	@Override
	protected void channelRead0(final ChannelHandlerContext ctx, FullHttpRequest httpRequest) throws Exception {
		String requestData = httpRequest.content().toString(CharsetUtil.UTF_8);
		String uri = httpRequest.uri();
		HttpMethod httpMethod = httpRequest.method();
		boolean keepAlive = HttpUtil.isKeepAlive(httpRequest);

		// invoke
		bizThreadPool.execute(() -> {
			// do invoke
			Object responseObj = process(httpMethod, uri, requestData);

			// to json
			String responseJson = JSONObject.toJSONString(responseObj);

			// write response
			writeResponse(ctx, keepAlive, responseJson);
		});
	}

	private Object process(HttpMethod httpMethod, String uri, String requestData) {
		logger.info("httpMethod:{}", httpMethod);
		logger.info("uri:{}", uri);
		logger.info("request:{}", requestData);
		return requestData;
	}

	/**
	 * write response
	 */
	private void writeResponse(ChannelHandlerContext ctx, boolean keepAlive, String responseJson) {
		// write response
		FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer(responseJson, CharsetUtil.UTF_8));   //  Unpooled.wrappedBuffer(responseJson)
		response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");       // HttpHeaderValues.TEXT_PLAIN.toString()
		response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
		if (keepAlive) {
			response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
		}
		ctx.writeAndFlush(response);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
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
