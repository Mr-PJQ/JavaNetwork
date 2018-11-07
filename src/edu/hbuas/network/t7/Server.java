package edu.hbuas.network.t7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket s = new ServerSocket(8899);

		System.out.println("服务端已经开启了");

		Socket client = s.accept();
		System.out.println("已经有一个人链接进来了：" + client.getInetAddress().getHostAddress());
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		new Thread() {
			public void run() {
				while (true) {
					String word;
					try {
						word = consoleReader.readLine();
						writer.write(word);
						writer.newLine();
						writer.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}.start();

		new Thread(){
			public void run(){
				while(true){
					String reciveMessage;
					try {
						reciveMessage = reader.readLine();
						System.out.println("接收到的客户端的消息:" + reciveMessage);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
