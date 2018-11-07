package edu.hbuas.network.t4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args)  throws Exception{
		//����һ��tcp���Ӱ����ķ���˴���
		
		
		//1.����һ������˵�Serversocket����
		
		ServerSocket  s=new ServerSocket(8899);//����˴�����ʱ��ָ��ͨѶ�˿ھͿ�����  0-65535
		
		System.out.println("������Ѿ�������");
		
		//2.�����������ӵķ���
		
			Socket  client=s.accept();//���ø÷���˵������˿��Խ���һ���ͻ������ӣ������ķ��������û�������ӣ���һֱ�ȴ�����һ�����������������з������ӵĿͻ��˶���
			System.out.println("�Ѿ���һ�������ӽ����ˣ�"+client.getInetAddress().getHostAddress());
			
			
			//3.������һ�������ɹ���ʣ�µĶ���io�Ĵ�����(IO)
			//���Ҫ���Է�������ݣ����ȡ�����
			
			BufferedWriter  writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			//socket�ײ�ֻ�ṩ�˻������ֽ�����Ϊ�˸�����Ĵ����ַ��������ǽ��ײ�����װ���ַ���
			
			
			//�����Ҫ�����������ı���Ϣ������Ҫ����System.in����ȡ����̨������
			//��java�ṩ�ĵײ��ֽ����������ӿ���̨��ȡ���ݵ�������װ��������Ҫ���ַ���
			BufferedReader  consoleReader=new BufferedReader(new InputStreamReader(System.in));
			
			
			//���Ҫ����������һ�������ݣ���ʱ��Ҫ��װ���������������
			BufferedReader  reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			while(true) {
				String   word=consoleReader.readLine();//���ַ�����ȡ����̨�����һ������
				
			//����̨��������ȡ�û��ӿ���̨�����һ�д���֮������ʹ��socket�������������д����������һ��
				
				writer.write(word);
				writer.newLine();
				writer.flush();
				String reciveMessage=reader.readLine();
				System.out.println("���յ��Ŀͻ��˵���Ϣ:"+reciveMessage);
			}
		//	writer.close();
	}

}
