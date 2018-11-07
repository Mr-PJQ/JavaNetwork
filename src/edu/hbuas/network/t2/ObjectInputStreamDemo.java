//package edu.hbuas.network.t2;
//
//import java.io.FileInputStream;
//import java.io.ObjectInputStream;
//
//public class ObjectInputStreamDemo {
//
//	public static void main(String[] args) throws Exception{
//		// TODO Auto-generated method stub
//		
//		//反序列化（讲之前存储到磁盘上的一个对象再次读取到内存中）
//		
//		ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\\\work\\\\user.abc"));
//		
//		User user=(User)in.readObject();
//	
//		
//		System.out.println(user);
//
//	}
//
