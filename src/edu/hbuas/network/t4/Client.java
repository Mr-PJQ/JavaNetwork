package edu.hbuas.network.t4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args)  throws Exception{
		
		//��������tcp�Ŀͻ��˴���
		
		//1.ֱ�Ӵ���һ��socket����ָ��Ҫ���ӵķ�������ip�Ͷ˿ڼ���
		
		Socket   client=new Socket("192.168.100.47", 8899);//������
		System.out.println("���ӷ������ɹ�");
		

		//2.����������֮��Ϳ��Ի�ȡio���������ݴ�����
		BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		
		BufferedReader  consoleReader=new BufferedReader(new InputStreamReader(System.in));//�@�e�ǫ@ȡ����̨ݔ����
		while(true) {
			String message=reader.readLine();
			System.out.println("�Է�˵��"+message);
			String  willSendMessage=consoleReader.readLine();//�@���xȡ�ҏĿ���̨ݔ��Ĕ���
			writer.write(willSendMessage);
			writer.newLine();
			writer.flush();
		}
		
	}

}
