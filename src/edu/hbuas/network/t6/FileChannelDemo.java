package edu.hbuas.network.t6;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class FileChannelDemo {
	public static void main(String[] args) throws Exception{
		FileChannel music = FileChannel.open(Paths.get("D:\\Pictures\\01 ÑÝÊ¾Í¼Æ¬.jpg"));
		
		FileChannel result = FileChannel.open(Paths.get("D:\\tupian.jpg"),EnumSet.of(StandardOpenOption.WRITE));
		
		ByteBuffer data = ByteBuffer.allocate(1024);
		
		while(music.read(data) != -1) {
			data.flip();
			result.write(data);
			data.clear();

		}
	}
}
