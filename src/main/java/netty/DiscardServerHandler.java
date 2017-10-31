package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

  // 在基础的实现类上面进行扩展
  // DiscardServerHandler extends ChannelInboundHandlerAdapter,
  // which is an implementation of ChannelInboundHandler.
  // ChannelInboundHandler provides various event handler methods that you can
  // override.
  // For now, it is just enough to extend ChannelInboundHandlerAdapter
  // rather than to implement the handler interface by yourself.

  @Override
  public void channelActive(final ChannelHandlerContext ctx) { // (1)
    final ByteBuf time = ctx.alloc().buffer(4); // (2)
    time.writeInt(10);
    // time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

    final ChannelFuture f = ctx.writeAndFlush(time); // (3)
    f.addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture future) {
        assert f == future;
        // ctx.close();
      }
    }); // (4)
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)

    // 接受的数据类型，需要判断，这个需要协议进行处理吗？
    // We override the channelRead() event handler method here.
    // This method is called with the received message, whenever new data is
    // received from a client.
    // In this example, the type of the received message is ByteBuf.
    try {
      ByteBuf in = (ByteBuf) msg;
      String re = in.toString(io.netty.util.CharsetUtil.UTF_8);
      System.out.println(re);
      ctx.writeAndFlush(msg);
    } finally {
//      ReferenceCountUtil.release(msg);
    }
    /*
     * 
     * try {
     * while (in.isReadable()) { // (1)
     * System.out.print((char) in.readByte());
     * System.out.flush();
     * }
     * } finally {
     * ReferenceCountUtil.release(msg); // (2)
     * // reference-counted object 需要手动的释放
     * // ByteBuf is a reference-counted object which has to be released
     * // **explicitly** via the release() method.
     * // Please keep in mind that：
     * // it is the handler's responsibility to release any reference-counted
     * // object
     * // passed to the handler.
     * // Usually, channelRead() handler method is implemented like the
     * // following:
     * }
     */
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
    // 异常的处理
    // Close the connection when an exception is raised.
    // The exceptionCaught() event handler method is called with a
    // Throwable when an exception was raised by Netty due to an I/O
    // error or by a handler implementation due to the exception thrown while
    // processing events.
    // In most cases, the caught exception should be logged and its associated
    // channel should be
    // closed here, although the implementation of this method can be different
    // depending on
    // what you want to do to deal with an exceptional situation. For example,
    // you might want to
    // send a response message with an error code before closing the connection.

    cause.printStackTrace();
    ctx.close();
  }
}