package com.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * 练习循环发送
 * @author yinyxn
 *
 */
public class Receiver {
	public static void main(String[] args) {
		
		InetAddress address = null;
		DatagramSocket socket = null;
		try {
//			 address = InetAddress.getByName("127.0.0.1");//地址与Sender要一致
			 address = InetAddress.getLocalHost();

			// 创建套接字
			 socket = new DatagramSocket(9000,address);
			 System.out.println("接收者已启动");
			 
			 byte[] buf = new byte[1024];
			 
			 //创建一个数据包
			 DatagramPacket packet = new DatagramPacket(buf, buf.length);
			// 接收(阻塞)
			 socket.receive(packet);
			 
			 //收到数据了
			 byte[] data = packet.getData();
			 int size = packet.getLength();
			 String msg = new String(data,0,size,"utf-8");
			 System.out.println("收到："+msg);
			 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(socket!=null){
				socket.close();
			}
		}
		
		
	}
}
