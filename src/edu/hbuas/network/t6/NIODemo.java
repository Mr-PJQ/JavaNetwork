package edu.hbuas.network.t6;

import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class NIODemo {

	public static void main(String[] args) throws Exception {
		//NIO文件操作类就是FIleChannel
		FileChannel   source=FileChannel.open(Paths.get("D:\\Pictures\\01 演示图片.jpg"));
		
		FileChannel  dest=FileChannel.open(Paths.get("D:\\tupian.jpg"), EnumSet.of(StandardOpenOption.WRITE));
		
		source.transferTo(0, source.size(), dest);//新IO提供的高级读写封装方法
		
	}

}
