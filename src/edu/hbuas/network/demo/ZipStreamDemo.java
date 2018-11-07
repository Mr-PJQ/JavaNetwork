package edu.hbuas.network.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩一个文件夹下所有文件（完整保存文件和结构）的案例程序
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
					parseDir(c,zipOut,entryPath+"/"+c.getName());//如果有子文件夹，继续回调自己，继续做目录迭代压缩
				}
			}
		}else {
			System.err.println("无法解析目录");
			return ;
		}
		
	}
	
	public static  void compressFile(ZipOutputStream out,String entryName,String filePath)  throws Exception{
		try {
		ZipEntry entry=new ZipEntry(entryName);
		System.out.println("壓縮"+entry.getName()+"文件");
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
		System.out.println("壓縮完成");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		String  sourceDir="C:\\Users\\TengSir\\Downloads/Snowberry_Plugin_1.0.4";
		readyCompressToZip(sourceDir);
		
		
	
	}

}
