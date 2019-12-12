package com.diyiliu.tcp.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;


/**
 * Description: ChildChannelHandler
 * Author: DIYILIU
 * Update: 2019-12-12 17:16
 */

@Slf4j
public class ChildChannelHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;

        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);

        String str = new String(bytes, "GBK");
        log.info("接收消息: [{}]", str);

        ctx.writeAndFlush(Unpooled.copiedBuffer(bytes));
    }
}
