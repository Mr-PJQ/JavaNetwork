package edu.hbuas.network.t2;

import java.io.FileReader;

public class FileReaderDemo {

	public static void main(String[] args)  throws Exception{
		
		//1.ʹ��fileReader��ȡһ���ı��ļ�
		
		
		FileReader  reader=new FileReader("files/̩ɽ.m4a");
		char[]  cs=new char[100];
		int len=-1;;
		
		while((len=reader.read(cs))!=-1) {
			System.out.print(new String(cs));
		}
		
	}
}
