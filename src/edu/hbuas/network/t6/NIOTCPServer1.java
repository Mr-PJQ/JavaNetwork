package edu.hbuas.network.t6;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
public class NIOTCPServer1{
public static void main(String[] args) throws Exception {
	//基于NIO的tcp服务端使用ServerSocketChannel
	
	ServerSocketChannel  server=ServerSocketChannel.open();//打开一个基于nio的tcp的服务端对象
	server.bind(new InetSocketAddress(9999));//给改服务端对象绑定一个tcp通讯端口
	SocketChannel  client=server.accept();//必须开启accpet方法才能接受一个客户端连接
	//因为nio的channel代替了以前的流，所以用nio做通讯的话,必须装数据载入到buffer
	//所以发送数据之前，先将数据载入到buffer
	String message="你好啊，我是新io的服务端!";//定义一句字符串，要发送的数据
	ByteBuffer  data=ByteBuffer.allocate(message.getBytes().length);  //将字符的对应的字节大小获取出来，创建一个可以完全放下这句话的buffer
	data.put(message.getBytes());//将底层字节数组直接存入到我们设计好的buffer对象中
	
	data.flip();//必须将buffer的position指针指向开头才能从开头吧数据写出去
	client.write(data);//当Buffer缓冲区已经放入数据了,就可以使用socket的Channel将数据写入通道
	client.close();
	
//	System.out.println(client.getRemoteAddress());
}

}
