package edu.hbuas.network.t2;

import java.io.FileReader;

public class FileReaderDemo {

	public static void main(String[] args)  throws Exception{
		
		//1.使用fileReader读取一个文本文件
		
		
		FileReader  reader=new FileReader("files/泰山.m4a");
		char[]  cs=new char[100];
		int len=-1;;
		
		while((len=reader.read(cs))!=-1) {
			System.out.print(new String(cs));
		}
		
	}
}
