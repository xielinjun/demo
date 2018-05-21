package com.xlj;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger LOG = Logger.getLogger(App.class);

    public void start() throws InterruptedException {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(boosGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel)
                            throws Exception {

                        ChannelPipeline pipeline =
                                socketChannel.pipeline();

                        pipeline.addLast(
                                new HttpServerCodec());
                        pipeline.addLast(
                                new HttpObjectAggregator(
                                        64 * 1024));
                        pipeline.addLast(new ChunkedWriteHandler());
                        pipeline.addLast(new HttpHandler());
                    }
                });

        ChannelFuture f = b.bind(8099).sync();
        f.channel().closeFuture().sync();
    }

    public static void main( String[] args )
    {
        try {
            new App().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println( "Hello World!" );
    }
}
