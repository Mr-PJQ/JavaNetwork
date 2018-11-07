package edu.hbuas.network.t7;

public class sellWindow extends Thread{
	private Tickets t;

	public sellWindow(Tickets t) {
		this.t = t;
	}

	public void run(){
		while(true){
			t.sellTicket();
			if(t.getTicketNum()>=100){
				break;
			}
		}
	}
	

}
