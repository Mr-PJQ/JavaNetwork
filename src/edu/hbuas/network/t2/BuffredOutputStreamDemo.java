package edu.hbuas.network.t2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class BuffredOutputStreamDemo {

	public static void main(String[] args)  throws Exception{

			//����Buffred����ʾ���������ʹ�û��漼����ʹ���ڴ��������ݴ棩
		
		
//			FileOutputStream   out=new FileOutputStream("files/1.txt");
//			while(true) {
//				
//				out.write((byte)(new Random().nextInt(26)+97));
//				Thread.sleep(1000);
//			}
			
		
		//�������������������writeд�����ݣ�����������ᱻ������ļ��ϣ������Ȼ�����ڴ���
		//ֻ�е���������close����������flush������ʱ��Ž�֮ǰ�Ļ����е�����д�뵽�ļ���
		
		//flushǿ����ջ�������������д���ļ�
		//close�ر���
			BufferedOutputStream  buffOut=new BufferedOutputStream(new FileOutputStream("files/1.txt"));
			
			for(int n=0;n<20;n++) {
				byte  b=(byte)(new Random().nextInt(26)+97);
				System.out.println("д�����ַ�:"+b);
				buffOut.write(b);
				if(n%5==0)buffOut.flush();
				Thread.sleep(500);
			}
			buffOut.close();
			
			
	}

}
