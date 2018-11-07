package edu.hbuas.network.t2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class BuffredOutputStreamDemo {

	public static void main(String[] args)  throws Exception{

			//带有Buffred都表示这个流可以使用缓存技术（使用内存做数据暂存）
		
		
//			FileOutputStream   out=new FileOutputStream("files/1.txt");
//			while(true) {
//				
//				out.write((byte)(new Random().nextInt(26)+97));
//				Thread.sleep(1000);
//			}
			
		
		//待缓冲区的流如果调用write写入数据，并不是立马会被输出到文件上，它是先缓存的内存中
		//只有调用了流的close方法，或者flush方法的时候才将之前的缓存中的数据写入到文件中
		
		//flush强制清空缓冲区，将数据写入文件
		//close关闭流
			BufferedOutputStream  buffOut=new BufferedOutputStream(new FileOutputStream("files/1.txt"));
			
			for(int n=0;n<20;n++) {
				byte  b=(byte)(new Random().nextInt(26)+97);
				System.out.println("写入了字符:"+b);
				buffOut.write(b);
				if(n%5==0)buffOut.flush();
				Thread.sleep(500);
			}
			buffOut.close();
			
			
	}

}
