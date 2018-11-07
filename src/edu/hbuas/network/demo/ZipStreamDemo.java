package edu.hbuas.network.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ѹ��һ���ļ����������ļ������������ļ��ͽṹ���İ�������
 * @author TengSir
 *
 */
public class ZipStreamDemo {
	
	public static void readyCompressToZip(String parentPath)  throws Exception{
		
		File  f=new File(parentPath);
		ZipOutputStream  zipOut=new ZipOutputStream(new FileOutputStream(f.getAbsolutePath()+".zip"));
		parseDir(f,zipOut,f.getName());
		zipOut.close();
	
	}
	public static void parseDir(File  f,ZipOutputStream  zipOut,String entryPath) {
		if(f.isDirectory()&&f.exists()) {
			File[]  fs=f.listFiles();
			for(File c:fs) {
				if(!c.isDirectory()) {
					String entryName=entryPath+"/"+c.getName();
					System.out.println(entryName);
					try {
						compressFile(zipOut,entryName,c.getAbsolutePath());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					parseDir(c,zipOut,entryPath+"/"+c.getName());//��������ļ��У������ص��Լ���������Ŀ¼����ѹ��
				}
			}
		}else {
			System.err.println("�޷�����Ŀ¼");
			return ;
		}
		
	}
	
	public static  void compressFile(ZipOutputStream out,String entryName,String filePath)  throws Exception{
		try {
		ZipEntry entry=new ZipEntry(entryName);
		System.out.println("���s"+entry.getName()+"�ļ�");
		out.putNextEntry(entry);
		FileInputStream  in=new FileInputStream(filePath);
		byte[] bs=new byte[1024];
		int len=-1;
		while((len=in.read(bs))!=-1) {
			out.write(bs,0,len);
			out.flush();
		}
		in.close();
		out.closeEntry();
		System.out.println("���s���");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		String  sourceDir="C:\\Users\\TengSir\\Downloads/Snowberry_Plugin_1.0.4";
		readyCompressToZip(sourceDir);
		
		
	
	}

}
