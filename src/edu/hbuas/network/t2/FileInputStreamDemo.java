package edu.hbuas.network.t2;

import java.io.FileInputStream;

public class FileInputStreamDemo {

	public static void main(String[] args) throws Exception {
		
		//���ļ��ֽ���������һ���ļ��ж�ȡ���ݵ��ڴ���
		
		//1.����һ���ļ�����������
		FileInputStream  input=new FileInputStream("files/̩ɽ.m4a");//�Ѿ���������һ�����Զ�ȡfiles/1.txt���ֽ�������
		
		//2.���ֽ�����read������ȡ�����ļ��������������
		
		/**һ���xȡһ���ֹ��ķ�ʽ�xȡ�ļ�����*/
		
		/**
		int byteCode=-1;
		while(             (     byteCode=input.read()   )      !=-1       ) {
			
			System.out.println(new String(new byte[] {(byte)byteCode}));
		}
		**/
		
		/***��read��ȡ����ķ���������������ȡ����**/
		byte[] bs=new byte[2];
		int length=-1;
		while(             (     length=input.read(bs)   )      !=-1       ) {
			
			System.out.print(new String(bs));
		}
		
		
		
		

	}

}
