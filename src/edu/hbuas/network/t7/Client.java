package edu.hbuas.network.t7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {

		Socket client = new Socket("localhost", 8899);
		System.out.println("链接服务器成功");
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		new Thread() {
			public void run() {
				while (true) {
					String message;
					try {
						message = reader.readLine();
						System.out.println("服务器说：" + message);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}.start();

		
		new Thread(){
			public void run(){
				while(true){
					try {
						String willSendMessage = consoleReader.readLine();
						writer.write(willSendMessage);
						writer.newLine();
						writer.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		}.start();
	}

}
