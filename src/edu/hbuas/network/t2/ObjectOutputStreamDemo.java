package edu.hbuas.network.t2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		
		//���Ҫ��ĳ����Ķ������л���������ø���ʵ��java.io.Seriliazabel�ӿ�
		
		User usr=new User(1001,"jack","rose123");
		
		
		//���л��ͷ����л�������Ϊjava���Լ����ݴ洢���ƣ����л������ڴ��е�java���󴦴��������ļ��У������л������ļ��еĶ����ٴλ�ԭ���ڴ棩
		
		ObjectOutputStream   out=new ObjectOutputStream(new FileOutputStream("C:\\work\\user.abc"));
		
		out.writeObject(usr);
		
		out.close();
		
		//���Ͼ�һ���򵥵����л����루���ڴ��е�usr����д�뵽�����ļ����ˣ�
		
		
		
		

	}

}
