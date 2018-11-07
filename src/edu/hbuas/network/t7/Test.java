package edu.hbuas.network.t7;

public class Test {

	public static void main(String[] args) {
		 Tickets t=new  Tickets();
		 sellWindow w1=new sellWindow(t);
		 sellWindow w2=new sellWindow(t);
		 sellWindow w3=new sellWindow(t);
		 sellWindow w4=new sellWindow(t);
		 sellWindow w5=new sellWindow(t);
		 
		 w1.start();
		 w2.start();
		 w3.start();
		 w4.start();
		 w5.start();
	}

}
