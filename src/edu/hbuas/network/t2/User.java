package edu.hbuas.network.t2;

import java.io.Serializable;

//让这个类型实现 Serializable  接口
public class   User  implements Serializable {
	
	@Override
	public String toString() {
		return "User [userild=" + userild + ", username=" + username + ", password=" + password + "]";
	}
	private  int userild;
	private String username;
	private String password;
	public int getUserild() {
		return userild;
	}
	public User(int userild, String username, String password) {
		super();
		this.userild = userild;
		this.username = username;
		this.password = password;
	}
	public void setUserild(int userild) {
		this.userild = userild;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
