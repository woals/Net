package com.net.tcp2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		//TCP �����
		ServerSocket serverSocket = null;
		try {
			serverSocket  = new ServerSocket(9000);
			System.out.println("����������");
			
			while (true) {
				//���տͷ��˵�����
				Socket socket = serverSocket.accept();
				
				//��������
				InetAddress address = socket.getInetAddress();
				int port = socket.getPort();
				
				System.out.printf("�ͷ��ˣ�%s:%d\n",address.getHostAddress(),port);
				
				//�������߳�
				EchoThread echoThread = new EchoThread(socket);
				echoThread.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
