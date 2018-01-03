package io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @date 2014年2月16日
 * @version 1.0
 */
public class AsyncTimeServerHandler implements Runnable {

    private int port;

    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncTimeServerHandler(int port) {
	this.setPort(port);
	try {
	    asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
	    asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
	    System.out.println("The time server is start in port : " + port);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
	latch = new CountDownLatch(1);
	doAccept();
	try {
//	    在本例程中，我们让线程在此阻塞，防止服务端执行完成退出。在实际项目应用中，
//		不需要启动独立的线程来处理AsynchronousServerSocketChannel，这里仅仅是个demo演示。
	    latch.await();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    public void doAccept() {
	asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
//	用于接收客户端的连接，由于是异步操作，我们可以传递一个
//	CompletionHandler<AsynchronousSocketChannel,?super A>类型的handler实例
//	接收accept操作成功的通知消息。在本例程中我们通过AcceptCompletionHandler实例作为
//	handler来接收通知消息，下面继续对AcceptCompletionHandler进行分析。
    }

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
