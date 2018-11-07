package edu.hbuas.network.t4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args)  throws Exception{
		
		//创建基于tcp的客户端代码
		
		//1.直接创建一个socket对象，指订要链接的服务器的ip和端口即可
		
		Socket   client=new Socket("192.168.100.47", 8899);//阻塞的
		System.out.println("链接服务器成功");
		

		//2.当建立链接之后就可以获取io来进行数据传输了
		BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		
		BufferedReader  consoleReader=new BufferedReader(new InputStreamReader(System.in));//這裡是獲取控制台輸入流
		while(true) {
			String message=reader.readLine();
			System.out.println("对方说："+message);
			String  willSendMessage=consoleReader.readLine();//這是讀取我從控制台輸入的數據
			writer.write(willSendMessage);
			writer.newLine();
			writer.flush();
		}
		
	}

}
