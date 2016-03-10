package com.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * �ͷ���
 * @author yinyxn
 *
 */
public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			//��7000�˿ڽ�������
			socket = new Socket("127.0.0.1",7000);
			System.out.println("�ѽ�������");
			
			//���׽��ֻ����
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			//��������
			String data = "hello";
//			Writer writer = new OutputStreamWriter(out)//�ַ���
//			writer.write("hello");
			
			byte[] byteDate  = data.getBytes();//�ֽ���
			out.write(byteDate);
			out.flush();
			System.out.println("���ͳɹ�!");
			
			
			//��������
			byte[] buf = new byte[1024];
			int size = in.read(buf);
			String r = new String(buf, 0, size);
			System.out.println("���գ�"+r);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			if (socket!= null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
