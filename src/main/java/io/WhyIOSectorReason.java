package io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * sector 产生的原因
 * */
public class WhyIOSectorReason {

	public static void main(String[] args) throws Exception{
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
		serverSocketChannel.configureBlocking(false);
		final List<SocketChannel> socketChannelList = new ArrayList<SocketChannel>();
		new Thread(new Runnable() {
		  @Override
		  public void run() {
		    while (true) {
		      // 处理 每个连接是否可读, 这里的逻辑是 读4个字节后切断连接
		      System.out.println("连接的个数: "+ socketChannelList.size());
		      for (SocketChannel socketChannel : new ArrayList<SocketChannel>(socketChannelList)) {
		        try {
		          ByteBuffer buf = ByteBuffer.allocate(4);
		          //如果一个阻塞了，那么另外的一个连接也会阻塞，因为在这个for循环中，阻塞了，就不会遍历下一个循环
		          int readed = socketChannel.read(buf);
		          System.out.println(readed);
		          System.out.println(Arrays.toString(buf.array()));
		          if (readed > 0 && buf.array()[0] == 'q') {
		            // close
		            socketChannel.close();
		            // remove from list
		            socketChannelList.remove(socketChannel);
		          }
		        } catch (Throwable e) {
		          e.printStackTrace();
		        }
		      }
		      try {
		        Thread.sleep(100);
		      } catch (InterruptedException e) {
		      }
		    }
		  }
		}, "server-handler-thread").start();

		// 等待新连接连进来
		while (true) {
		  SocketChannel socketChannel = serverSocketChannel.accept();
		  if (socketChannel != null) {
		    socketChannelList.add(socketChannel);
		  }
		  Thread.sleep(1000);
		}
	}

}
