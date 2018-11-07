package edu.hbuas.network.t6;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
public class NIOTCPServer1{
public static void main(String[] args) throws Exception {
	//����NIO��tcp�����ʹ��ServerSocketChannel
	
	ServerSocketChannel  server=ServerSocketChannel.open();//��һ������nio��tcp�ķ���˶���
	server.bind(new InetSocketAddress(9999));//���ķ���˶����һ��tcpͨѶ�˿�
	SocketChannel  client=server.accept();//���뿪��accpet�������ܽ���һ���ͻ�������
	//��Ϊnio��channel��������ǰ������������nio��ͨѶ�Ļ�,����װ�������뵽buffer
	//���Է�������֮ǰ���Ƚ��������뵽buffer
	String message="��ð���������io�ķ����!";//����һ���ַ�����Ҫ���͵�����
	ByteBuffer  data=ByteBuffer.allocate(message.getBytes().length);  //���ַ��Ķ�Ӧ���ֽڴ�С��ȡ����������һ��������ȫ������仰��buffer
	data.put(message.getBytes());//���ײ��ֽ�����ֱ�Ӵ��뵽������ƺõ�buffer������
	
	data.flip();//���뽫buffer��positionָ��ָ��ͷ���ܴӿ�ͷ������д��ȥ
	client.write(data);//��Buffer�������Ѿ�����������,�Ϳ���ʹ��socket��Channel������д��ͨ��
	client.close();
	
//	System.out.println(client.getRemoteAddress());
}

}
