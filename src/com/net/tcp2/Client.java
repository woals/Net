package com.net.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	
	public static void main(String[] args) {
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket("127.0.0.1",9000);
			System.out.println("已建立连接");
			in = socket.getInputStream();
			out = socket.getOutputStream();
			System.out.println("请输入要查询的信息：");
			String input = sc.nextLine();
			sc.close();
			//发送
			out.write(input.getBytes());
			out.flush();
			System.out.println("已发送");
			
			//接收
			byte[] buf = new byte[1024];
			int size = in.read(buf);
			String data = new String(buf,0,size);
			System.out.println("收到的数据："+data);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (socket!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
