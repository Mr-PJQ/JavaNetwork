package edu.hbuas.network.t3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
	
	//����IO���
	public static void main(String[] args) throws Exception {
		//URL��java�����ṩ��һ���������������Դ������
		
		
		
		URL  url=new URL("https://desktop.githubusercontent.com/releases/1.4.0-da875020/GitHubDesktopSetup.exe");//1.�����Լ�����һ��URL��Ķ�������ʾһ��Ҫ������������Դ����
		
		
		//URL������ʾһ����������Դ����urlConnection���������ӵ����������Դ������
		
		
		
		URLConnection con=url.openConnection();//2.ͨ��url��һ�����Ӷ�������������
		
		InputStream  in=con.getInputStream();//3.ͨ��urlconnection��ȡ���Ӻ�õ�����������
		
		
		//4.ͨ�����������������url��Դ�˶�ȡ���������Դ������
		
		int length=-1;
		byte[]  bs=new byte[1024*1024];
		
		
		//5.��Ϊ���������url��Դ��Ӧ����һ��ͼƬ�����ԣ�������Ҫ��֮ǰѧϰ��io���룬�����ͼƬ�洢�������ϵ�һ���ļ��ϣ�
		
		FileOutputStream out=new FileOutputStream("C:\\work\\1.exe");
		
		while((length=in.read(bs))!=-1) {
			out.write(bs,0,length);
		}
		in.close();
		out.close();
		
		
	}

}
