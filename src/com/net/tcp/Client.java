package com.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 客服端
 * @author yinyxn
 *
 */
public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			//和7000端口建立连接
			socket = new Socket("127.0.0.1",7000);
			System.out.println("已建立连接");
			
			//从套接字获得流
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			//发送数据
			String data = "hello";
//			Writer writer = new OutputStreamWriter(out)//字符流
//			writer.write("hello");
			
			byte[] byteDate  = data.getBytes();//字节流
			out.write(byteDate);
			out.flush();
			System.out.println("发送成功!");
			
			
			//接收数据
			byte[] buf = new byte[1024];
			int size = in.read(buf);
			String r = new String(buf, 0, size);
			System.out.println("接收："+r);
			
			
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
