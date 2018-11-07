package edu.hbuas.network.t2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		
		//如果要讲某个类的对象序列化，则必须让该类实现java.io.Seriliazabel接口
		
		User usr=new User(1001,"jack","rose123");
		
		
		//序列化和反序列化可以作为java语言简单数据存储机制（序列化：将内存中的java对象处处到磁盘文件中，反序列化：将文件中的对象再次还原到内存）
		
		ObjectOutputStream   out=new ObjectOutputStream(new FileOutputStream("C:\\work\\user.abc"));
		
		out.writeObject(usr);
		
		out.close();
		
		//以上就一个简单的序列化代码（将内存中的usr独享写入到磁盘文件中了）
		
		
		
		

	}

}
