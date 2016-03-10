package com.net.udp2;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Chat {

	public static void main(String[] args) throws UnknownHostException, SocketException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("指定端口:");
		int port = sc.nextInt();

		InetAddress laddr = InetAddress.getByName("127.0.0.1");

		// 套接字
		DatagramSocket socket = new DatagramSocket(port, laddr);

		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);

		sender.start();
		receiver.start();

	}

}
