package zd.s8.t1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.layout.Border;
import zd.s8.t1.model.Message;
import zd.s8.t1.util.SendMsg;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import zd.s8.t1.model.*;
import java.awt.Toolkit;

/**
 * 聊天面板
 * @author DELL
 *
 */
public class ChatPanel extends JFrame {

	private String userid;
	private String username;
	private Socket s;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private JPanel contentPane;
	private JButton sendMsg;
	private JScrollPane chatScrollPane;
	private JTextArea chatArea=new JTextArea();

	/**
	 * Create the frame.
	 */
	public ChatPanel(User u,String id,String name,Socket s,ObjectOutputStream oos,ObjectInputStream ois) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Eclipse\\anzhuang\\LiuYanClient\\image\\categories.jpg"));
		this.setUserid(id);
		this.setUsername(name);
		this.setS(s);
		this.setOos(oos);
		this.setOis(ois);
		setTitle("正在和 "+getUserid()+" "+getUsername()+" 聊天");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 70, 563, 484);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		
		sendMsg = new JButton("发送");
		sendMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textPane.getText().equals("")) {
					Message m=new Message();
					m.setMsgtext(textPane.getText().trim());
					m.setMsgType("3");//普通消息包
					m.setSender(u.getId());
					m.setReceiver(id);
					User user=new User();
					user.setId(id);
					user.setName(name);
					SendMsg sm=new SendMsg(getS(),user,m);
					sm.sendMsg(getOos());
					chatArea.append(u.getName()+" :\n"+"  "+m.getMsgtext()+"\n");
				}
			}
		});
		sendMsg.setForeground(Color.decode("#ffffff"));
		sendMsg.setFont(new Font(Font.DIALOG,Font.CENTER_BASELINE,14));
		sendMsg.setBorder(null);
		sendMsg.setFocusPainted(false);
		sendMsg.setBackground(Color.decode("#EECFA1"));
		
		chatScrollPane = new JScrollPane();
		chatScrollPane.setBorder(null);
		chatScrollPane.setViewportView(chatArea);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(chatScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
						.addComponent(sendMsg, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(chatScrollPane, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(sendMsg, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	public JTextArea getChatArea() {
		return chatArea;
	}

	public void setChatArea(JTextArea chatArea) {
		this.chatArea = chatArea;
	}
}
