package edu.hbuas.network.t7;

/**
 * ƱԴ��,����洢�������˻𳵵�����ƱԴ����
 * @author ASUS
 *
 */
public class Tickets {
	private int ticketNum=1;

	public int getTicketNum() {
		return ticketNum;
	}
	
	/**
	 * �������̶߳�Ҫ������һ�������ĳ������,�����������Ҫ�໥�ų⣨����֤����һ���ԣ�
	 * ������������ͬ������,����������ϼ���ؼ��֣�synchronized��
	 */
	public synchronized void sellTicket(){
		if(ticketNum<=100){
			System.out.println("�����˺���Ϊ��"+ticketNum+"����Ʊ");
			ticketNum++;
		}
	}

}
