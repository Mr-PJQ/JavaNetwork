package edu.hbuas.network.t3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
	
	//网络IO编程
	public static void main(String[] args) throws Exception {
		//URL是java类中提供的一个用来表达网络资源的类型
		
		
		
		URL  url=new URL("https://desktop.githubusercontent.com/releases/1.4.0-da875020/GitHubDesktopSetup.exe");//1.可以自己创建一个URL类的对象来表示一个要解析的网络资源对象
		
		
		//URL用来表示一个互联网资源，而urlConnection负责来链接到这个网络资源并解析
		
		
		
		URLConnection con=url.openConnection();//2.通过url打开一个链接对象来解析数据
		
		InputStream  in=con.getInputStream();//3.通过urlconnection获取连接后得到输入流对象
		
		
		//4.通过输入流对象从网络url资源端读取这个网络资源的数据
		
		int length=-1;
		byte[]  bs=new byte[1024*1024];
		
		
		//5.因为解析的这个url资源对应的是一个图片，所以，我们需要用之前学习的io代码，将这个图片存储到磁盘上的一个文件上，
		
		FileOutputStream out=new FileOutputStream("C:\\work\\1.exe");
		
		while((length=in.read(bs))!=-1) {
			out.write(bs,0,length);
		}
		in.close();
		out.close();
		
		
	}

}
