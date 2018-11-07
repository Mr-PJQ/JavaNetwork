package edu.hbuas.network.t5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReciver {

	public static void main(String[] args) throws Exception{
		
		DatagramSocket s = new DatagramSocket(9999);
		byte[] data = new byte[100];
		DatagramPacket dataPacket = new DatagramPacket(data, data.length);
		
		s.receive(dataPacket);
		
		//»¹Ô­³É×Ö·û´®
		System.out.println(new String(data));

	}

}
