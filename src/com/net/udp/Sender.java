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
			//�����׽���
			socket = new DatagramSocket();
			
			String msg = "hello����";
			byte[] data = msg.getBytes("utf-8");
			
			//IP��ַ
			InetAddress address = InetAddress.getLocalHost();
//			address = InetAddress.getByName("www.baidu.com");
//			address = InetAddress.getByName("127.0.0.1");
			System.out.println(address);

			//�˿ں�,�����Receiver�Ķ˿ںŲ�һ�� ��Receiver����ղ���
			int port = 9000;
			
			//���ݰ�
			packet = new DatagramPacket(data, data.length, address, port);
			
			//UDP����
			socket.send(packet);
			System.out.println("�ɹ�����");
			
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
