package com.net.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver extends Thread {

	private DatagramSocket socket;

	// 数据包
	private DatagramPacket packet;

	public Receiver(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		byte[] buf = new byte[1024];

		while (true) {
			packet = new DatagramPacket(buf, buf.length);

			try {
				// 阻塞
				socket.receive(packet);

				// 获得数据包中的数据
				String data = new String(packet.getData(), 0, packet.getLength());
				
				System.out.printf("收到：%s\n", data);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
