package com.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Sender {
	public static void main(String[] args) {
		
		//UDP
		DatagramSocket socket = null;
		DatagramPacket packet = null;

		try {
			//创建套接字
			socket = new DatagramSocket();
			
			String msg = "hello中文";
			byte[] data = msg.getBytes("utf-8");
			
			//IP地址
			InetAddress address = InetAddress.getLocalHost();
//			address = InetAddress.getByName("www.baidu.com");
//			address = InetAddress.getByName("127.0.0.1");
			System.out.println(address);

			//端口号,如果与Receiver的端口号不一样 ，Receiver则接收不到
			int port = 9000;
			
			//数据包
			packet = new DatagramPacket(data, data.length, address, port);
			
			//UDP发送
			socket.send(packet);
			System.out.println("成功发送");
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}
}
