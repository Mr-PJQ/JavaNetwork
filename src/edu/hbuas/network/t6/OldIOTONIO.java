package edu.hbuas.network.t6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class OldIOTONIO {

	public static void main(String[] args)  throws Exception{
		//�Ӵ�ͳioֱ��ת����io
		FileInputStream  in=new FileInputStream("D:\\Pictures\\01 ��ʾͼƬ.jpg");
		FileChannel  c=	in.getChannel();//�ɴ�ͳ��io��һ��ת��Ϊ�µ��ļ�ͨ��
		
		FileOutputStream  out=new FileOutputStream("D:\\tupian.jpg");
		
		FileChannel  d=out.getChannel();
		
		d.transferFrom(c, 0, c.size());
	}

}
