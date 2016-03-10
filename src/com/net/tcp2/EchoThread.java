package com.net.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;

public class EchoThread extends Thread{
	
	private static HashMap<String,String> map  = new HashMap<String, String>();
	
	static{
		map.put("����", "��ɳ");
		map.put("����", "�人");
		map.put("�ӱ�", "ʯ��ׯ");
		map.put("����", "֣��");
		map.put("�㶫", "����");
		map.put("����", "����");


	}
	
	private Socket socket;
	
	public EchoThread(Socket socket){
		this.socket = socket;

	}
	
	public void run(){
		InputStream in = null;
		OutputStream out = null;
		
		//���տͻ����������
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			byte[] buf = new byte[1024];
			
			int size = in.read(buf);
			String data = new String(buf,0,size);
			System.out.println("�յ���"+data);

			//��ѯ
			String result;
			if(map.containsKey(data)){
				result = map.get(data);
			}else {
				result = "�й���ʱû�����ʡ��";
			}
			//������Ӧ����
			out.write(result.getBytes());
			out.flush();
			System.out.println(Thread.currentThread().getName()+": ��Ӧ���");
			
			
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
