package com.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * TCP������
 * 
 * @author yinyxn
 *
 */
public class Server {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		InputStream in = null;
		OutputStream out = null;
		
		//������׽���
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7000);
			System.out.println("����������!");
			
			//���տͻ�����(����)
			Socket socket = serverSocket.accept();

			//���ա���������
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			//����
			byte[] buf = new byte[1024];
			int size = in.read(buf);
			
			String s = new String (buf,0,size);//��0��size����ȥ��������
			System.out.println("�յ������ݣ�"+s);
			//����
			
			s = "���!\t";//�����\\t��������ǡ���ã�\t��
//			s = s.toUpperCase();//��Client��������helloתΪ��д
			s += new Date().toLocaleString();
			
			//����
			byte[] data = s.getBytes();
			out.write(data);
			out.flush();
			System.out.println("���ͳɹ�");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(serverSocket != null){
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
}
