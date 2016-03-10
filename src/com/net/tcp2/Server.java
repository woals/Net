package com.net.tcp2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		//TCP 服务端
		ServerSocket serverSocket = null;
		try {
			serverSocket  = new ServerSocket(9000);
			System.out.println("服务器启动");
			
			while (true) {
				//接收客服端的请求
				Socket socket = serverSocket.accept();
				
				//建立连接
				InetAddress address = socket.getInetAddress();
				int port = socket.getPort();
				
				System.out.printf("客服端：%s:%d\n",address.getHostAddress(),port);
				
				//启动子线程
				EchoThread echoThread = new EchoThread(socket);
				echoThread.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
