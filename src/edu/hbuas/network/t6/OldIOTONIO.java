package edu.hbuas.network.t6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class OldIOTONIO {

	public static void main(String[] args)  throws Exception{
		//从传统io直接转向到新io
		FileInputStream  in=new FileInputStream("D:\\Pictures\\01 演示图片.jpg");
		FileChannel  c=	in.getChannel();//由传统的io流一部转化为新的文件通道
		
		FileOutputStream  out=new FileOutputStream("D:\\tupian.jpg");
		
		FileChannel  d=out.getChannel();
		
		d.transferFrom(c, 0, c.size());
	}

}
