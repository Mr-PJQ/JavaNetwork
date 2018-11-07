package edu.hbuas.network.t5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendder {

	public static void main(String[] args) throws Exception{
		//1.创建一个udp对象
		DatagramSocket s = new DatagramSocket(9999);

		
		byte[] data="发送一条消息".getBytes();
		InetAddress address = InetAddress.getByName("localhost");
		DatagramPacket dataPacket = new DatagramPacket(data, data.length, address, 8888);
		
		s.send(dataPacket);
		
	}

}
