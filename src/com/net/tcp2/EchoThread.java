package com.net.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;

public class EchoThread extends Thread{
	
	private static HashMap<String,String> map  = new HashMap<String, String>();
	
	static{
		map.put("湖南", "长沙");
		map.put("湖北", "武汉");
		map.put("河北", "石家庄");
		map.put("河南", "郑州");
		map.put("广东", "广州");
		map.put("广西", "南宁");


	}
	
	private Socket socket;
	
	public EchoThread(Socket socket){
		this.socket = socket;

	}
	
	public void run(){
		InputStream in = null;
		OutputStream out = null;
		
		//接收客户请求的数据
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			byte[] buf = new byte[1024];
			
			int size = in.read(buf);
			String data = new String(buf,0,size);
			System.out.println("收到："+data);

			//查询
			String result;
			if(map.containsKey(data)){
				result = map.get(data);
			}else {
				result = "中国暂时没有这个省！";
			}
			//发送响应数据
			out.write(result.getBytes());
			out.flush();
			System.out.println(Thread.currentThread().getName()+": 响应完毕");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (out!=null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
