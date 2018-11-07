package edu.hbuas.network.t2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadWrite {

	public static void main(String[] args) throws Exception {

		//完整的一个文件读写案例
		FileInputStream  in=new FileInputStream("files/泰山.m4a");
		
		FileOutputStream  out=new FileOutputStream("c:\\work\\test.mp3");
		int byteCode=-1;
		while((byteCode=in.read())!=-1)
		{
				out.write(byteCode);
					
		}
		out.close();
		in.close();
	}

}
