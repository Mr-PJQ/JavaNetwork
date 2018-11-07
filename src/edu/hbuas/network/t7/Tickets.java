package edu.hbuas.network.t7;

/**
 * 票源类,里面存储的是整趟火车的所有票源数据
 * @author ASUS
 *
 */
public class Tickets {
	private int ticketNum=1;

	public int getTicketNum() {
		return ticketNum;
	}
	
	/**
	 * 如果多个线程都要访问这一个对象的某个方法,而这个方法需要相互排斥（来保证数据一致性）
	 * 必须给这个方法同步起来,在这个方法上加入关键字（synchronized）
	 */
	public synchronized void sellTicket(){
		if(ticketNum<=100){
			System.out.println("卖出了号码为："+ticketNum+"这张票");
			ticketNum++;
		}
	}

}
