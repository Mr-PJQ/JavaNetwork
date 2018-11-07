package edu.hbuas.network.t4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args)  throws Exception{
		//创建一个tcp链接案例的服务端代码
		
		
		//1.创建一个服务端的Serversocket对象
		
		ServerSocket  s=new ServerSocket(8899);//服务端创建的时候指定通讯端口就可以了  0-65535
		
		System.out.println("服务端已经开启了");
		
		//2.开启接受链接的方法
		
			Socket  client=s.accept();//调用该方法说明服务端可以接受一个客户端链接（阻塞的方法，如果没有人链接，则一直等待，有一个人链接则立马运行返回链接的客户端对象）
			System.out.println("已经有一个人链接进来了："+client.getInetAddress().getHostAddress());
			
			
			//3.当链接一旦建立成功，剩下的都是io的代码了(IO)
			//如果要给对方输出数据，则获取输出流
			
			BufferedWriter  writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			//socket底层只提供了基础的字节流，为了更方便的处理字符串，我们将底层流包装成字符流
			
			
			//如果想要由人来输入文本消息，则需要调用System.in来读取控制台的内容
			//将java提供的底层字节输入流（从控制台读取数据的流）封装成我们需要的字符流
			BufferedReader  consoleReader=new BufferedReader(new InputStreamReader(System.in));
			
			
			//如果要对网络另外一方的数据，此时还要封装基于网络的输入流
			BufferedReader  reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			while(true) {
				String   word=consoleReader.readLine();//用字符流读取控制台输入的一行内容
				
			//控制台输入流读取用户从控制台输入的一行代码之后立马使用socket的输出流将数据写给网络另外一方
				
				writer.write(word);
				writer.newLine();
				writer.flush();
				String reciveMessage=reader.readLine();
				System.out.println("接收到的客户端的消息:"+reciveMessage);
			}
		//	writer.close();
	}

}
