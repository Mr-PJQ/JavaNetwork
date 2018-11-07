package edu.hbuas.network.t2;

import java.io.FileInputStream;

public class FileInputStreamDemo {

	public static void main(String[] args) throws Exception {
		
		//用文件字节输入流从一个文件中读取数据到内存中
		
		//1.创建一个文件输入流对象
		FileInputStream  input=new FileInputStream("files/泰山.m4a");//已经创建好了一个可以读取files/1.txt的字节输入流
		
		//2.用字节流的read方法读取整个文件里面的所有数据
		
		/**一次讀取一個字節的方式讀取文件數據*/
		
		/**
		int byteCode=-1;
		while(             (     byteCode=input.read()   )      !=-1       ) {
			
			System.out.println(new String(new byte[] {(byte)byteCode}));
		}
		**/
		
		/***用read读取数组的方法来从输入流读取数据**/
		byte[] bs=new byte[2];
		int length=-1;
		while(             (     length=input.read(bs)   )      !=-1       ) {
			
			System.out.print(new String(bs));
		}
		
		
		
		

	}

}
