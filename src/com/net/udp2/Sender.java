package com.net.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Sender extends Thread {

	private DatagramSocket socket;

	private DatagramPacket packet;

	public Sender(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		InetAddress address = null;
		try {
			address = InetAddress.getByName("127.0.0.1");

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("端口：");
			int port = Integer.parseInt(scanner.nextLine());
			System.out.print("数据：");
			String input = scanner.nextLine();
			byte[] data = input.getBytes();

			packet = new DatagramPacket(data, data.length, address, port);

			try {
				socket.send(packet);

				System.out.println("已发送");

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
