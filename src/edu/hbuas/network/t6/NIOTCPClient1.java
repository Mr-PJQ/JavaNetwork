package edu.hbuas.network.t6;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOTCPClient1 {
	public static void main(String[] args) throws Exception {

		//基于nio的tcp客户端使用socketChannel类型
		
		SocketChannel  c=SocketChannel.open();//打开一个客户端的socket对象
		c.connect(new InetSocketAddress("localhost", 9999));//客户端socket对象创建完毕后可以调用connect连接服务端
		System.out.println("连接服务器成功");
		
		ByteBuffer  reciveData=ByteBuffer.allocate(25);//这里是准备一个空的字节Buffer对象用来接收数据
		c.read(reciveData);//调用通道的read，读取网络通道另外一方给我发送的数据
		byte[]  datas=new byte[25];
		reciveData.flip();//必须将buffer的position指针指向开头才能读取完整的数组
		reciveData.get(datas);
	}

}
