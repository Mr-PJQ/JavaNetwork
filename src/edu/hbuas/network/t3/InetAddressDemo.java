package edu.hbuas.network.t3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) {
		
		try {
			InetAddress[]  add=InetAddress.getAllByName("localhost");
			
			for(InetAddress  in:add) {
				System.out.println(in.getHostAddress()+"\t"+in.getHostName());
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
