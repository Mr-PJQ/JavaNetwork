package edu.hbuas.network.t8;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Session;

import sun.security.krb5.internal.Authenticator;
import sun.text.normalizer.ICUBinary.Authenticate;

public class Mail {
	public static void main(String[] args) {
		
		
		Properties p = new Properties();
		p.put("mail.smtp.host","smtp.163.com");
		
		Session session=Session.getDefaultInstance(p);
		
	}

}
