package edu.hbuas.network.t4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerFrame extends JFrame {
	private JScrollPane  s;
	private JTextArea   messages,editMessage;
	private JButton  send,close;
	
	private ServerSocket  server;
	private Socket  client;
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public ServerFrame() {
		try {
			server=new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("聊天软件-server");
		setSize(400, 600);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initCOmpoenent();
		this.paintComponents(this.getGraphics());
		this.paintAll(getGraphics());
		
		try {
			client=	server.accept();
			writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			JOptionPane.showMessageDialog(this, "已经有一个客户端连接成功了!", "温馨提升", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				String reciveMessage=reader.readLine();
				messages.append(reciveMessage+"\r\n\r\n");
				messages.setCaretPosition(messages.getText().length());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void initCOmpoenent() {
		messages=new JTextArea();
		s=new JScrollPane(messages);
		messages.setEditable(false);
		s.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		s.setBounds(10, 10, 370, 260);
		this.add(s);
		
		editMessage=new JTextArea();
		editMessage.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		editMessage.setBounds(10, 280, 370, 200);
		this.add(editMessage);
		
		
		send=new JButton("send");
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message=editMessage.getText();
				try {
					writer.write(message);
					writer.newLine();
					writer.flush();
					editMessage.setText("");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		send.setBounds(200, 500, 80, 20);
		this.add(send);
		close=new JButton("close");
		close.setBounds(300, 500, 80, 20);
		this.add(close);
	}

	public static void main(String[] args) {
		new ServerFrame();
	}
}
