package edu.hbuas.network.t2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderDemo {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		//�ַ�������õľ���BUfferedReader��FIleReader
		
		//readLine
		
		BufferedReader  reader=new BufferedReader(new FileReader("files/files.txt"));
		
		BufferedWriter  writer=new BufferedWriter(new FileWriter("files/abc.txt"));

		String message=null;
		while((message=reader.readLine())!=null) {
			System.out.println(message);
			writer.write(message);
			writer.newLine();//���еķ���
			writer.flush();
		}
	}

}
