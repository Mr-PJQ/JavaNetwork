package edu.hbuas.network.t2;

import java.io.FileOutputStream;

public class FileOutputStreamDemo {

	public static void main(String[] args)  throws Exception{
			
		//1.创建一个文件输出流
		
		FileOutputStream  out=new FileOutputStream("files/test.txt");
		String word="hello world";
		out.write(word.getBytes());
		
		out.close();
	}

}
