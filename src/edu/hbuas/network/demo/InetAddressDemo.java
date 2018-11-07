package edu.hbuas.network.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) {
		try {
			InetAddress[]  inet=InetAddress.getAllByName("www.jd.com");
			for(InetAddress  as:inet) {
				System.out.println(as.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
