package io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用线程池来处理客户端的连接
 * */
public class GreetingServer_PoolDealAccept extends Thread {
	private ServerSocket serverSocket;
	int maxThreads = 10;
	int acceptCount = 100;
	private ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime()
			.availableProcessors(), maxThreads, 120L, TimeUnit.SECONDS,
			new ArrayBlockingQueue<java.lang.Runnable>(acceptCount));
	public GreetingServer_PoolDealAccept(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		//等待客户端连接的超时时间
		serverSocket.setSoTimeout(1000000000);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				//没有客户端连接，服务端阻塞等待点
				Socket server = serverSocket.accept();
				//通过线程池来进行处理
				executor.execute(new SocketDeal(server));
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int port = 9090;
		try {
			Thread t = new GreetingServer_PoolDealAccept(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}