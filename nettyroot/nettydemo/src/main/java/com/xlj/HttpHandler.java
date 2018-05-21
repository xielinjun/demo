package com.xlj;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;

import java.io.RandomAccessFile;

public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                FullHttpRequest fullHttpRequest)
            throws Exception {
        HttpResponse httpResponse = new DefaultHttpResponse(
                fullHttpRequest.getProtocolVersion(),
                HttpResponseStatus.OK);

        String uri = fullHttpRequest.getUri();
        RandomAccessFile file = null;

        String page = uri.equals("/") ? "chat.html" : uri;

//        file = new RandomAccessFile()

        httpResponse.headers().set(
                HttpHeaders.Names.CONTENT_TYPE,
                "text/html;charset=utf-8;");

        if(HttpHeaders.isKeepAlive(fullHttpRequest))
        {

            httpResponse.headers().set(
                    HttpHeaders.Names.CONTENT_LENGTH,
                    "hellow".getBytes().length);
            httpResponse.headers().set(
                    HttpHeaders.Names.CONNECTION,
                    HttpHeaders.Values.KEEP_ALIVE);
        }

//        httpResponse.wr

        channelHandlerContext.write(httpResponse);
        channelHandlerContext.write("hellow");

        ChannelFuture channelFuture =
                channelHandlerContext.writeAndFlush(
                        LastHttpContent.EMPTY_LAST_CONTENT);

        if(HttpHeaders.isKeepAlive(fullHttpRequest))
        {
            channelFuture.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel client = ctx.channel();
        cause.printStackTrace();
        ctx.close();
    }
}
