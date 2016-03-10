package com.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * TCP服务器
 * 
 * @author yinyxn
 *
 */
public class Server {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		InputStream in = null;
		OutputStream out = null;
		
		//服务端套接字
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7000);
			System.out.println("服务器启动!");
			
			//接收客户请求(阻塞)
			Socket socket = serverSocket.accept();

			//接收、发送数据
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			//接收
			byte[] buf = new byte[1024];
			int size = in.read(buf);
			
			String s = new String (buf,0,size);//加0，size可以去除脏数据
			System.out.println("收到的数据："+s);
			//处理
			
			s = "你好!\t";//如果是\\t则输出的是“你好！\t”
//			s = s.toUpperCase();//把Client发送来的hello转为大写
			s += new Date().toLocaleString();
			
			//发送
			byte[] data = s.getBytes();
			out.write(data);
			out.flush();
			System.out.println("发送成功");
			
			
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
