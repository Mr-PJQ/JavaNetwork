package edu.hbuas.network.t6;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOTCPClient1 {
	public static void main(String[] args) throws Exception {

		//����nio��tcp�ͻ���ʹ��socketChannel����
		
		SocketChannel  c=SocketChannel.open();//��һ���ͻ��˵�socket����
		c.connect(new InetSocketAddress("localhost", 9999));//�ͻ���socket���󴴽���Ϻ���Ե���connect���ӷ����
		System.out.println("���ӷ������ɹ�");
		
		ByteBuffer  reciveData=ByteBuffer.allocate(25);//������׼��һ���յ��ֽ�Buffer����������������
		c.read(reciveData);//����ͨ����read����ȡ����ͨ������һ�����ҷ��͵�����
		byte[]  datas=new byte[25];
		reciveData.flip();//���뽫buffer��positionָ��ָ��ͷ���ܶ�ȡ����������
		reciveData.get(datas);
	}

}
