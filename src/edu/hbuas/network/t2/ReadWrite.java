package edu.hbuas.network.t2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadWrite {

	public static void main(String[] args) throws Exception {

		//������һ���ļ���д����
		FileInputStream  in=new FileInputStream("files/̩ɽ.m4a");
		
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
