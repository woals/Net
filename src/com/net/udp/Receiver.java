package com.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * ��ϰѭ������
 * @author yinyxn
 *
 */
public class Receiver {
	public static void main(String[] args) {
		
		InetAddress address = null;
		DatagramSocket socket = null;
		try {
//			 address = InetAddress.getByName("127.0.0.1");//��ַ��SenderҪһ��
			 address = InetAddress.getLocalHost();

			// �����׽���
			 socket = new DatagramSocket(9000,address);
			 System.out.println("������������");
			 
			 byte[] buf = new byte[1024];
			 
			 //����һ�����ݰ�
			 DatagramPacket packet = new DatagramPacket(buf, buf.length);
			// ����(����)
			 socket.receive(packet);
			 
			 //�յ�������
			 byte[] data = packet.getData();
			 int size = packet.getLength();
			 String msg = new String(data,0,size,"utf-8");
			 System.out.println("�յ���"+msg);
			 
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
