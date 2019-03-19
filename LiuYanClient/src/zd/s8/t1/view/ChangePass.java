package zd.s8.t1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.User;
import zd.s8.t1.util.SendMsg;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class ChangePass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	private User u=new User();
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u=u;
	}
	private Message m=new Message();
	public void setM(Message m) {
		this.m=m;
	}
	public Message getM() {
		return m;
	}
	
	/**
	 * Create the frame.
	 */
	public ChangePass(User user,Socket s,ObjectOutputStream oos,ObjectInputStream ois) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 434, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		JLabel label = new JLabel("\u65E7\u5BC6\u7801");
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801");
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801");
		
		passwordField_2 = new JPasswordField();
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(String.valueOf(passwordField_1.getPassword()).trim().equals(
						String.valueOf(passwordField_2.getPassword()).trim())) {
					//进行密码修改
					Message msg=new Message();
					msg.setMsgType("9");//9是服务端的修改密码请求
					msg.setSender(String.valueOf(passwordField.getPassword()));
					User n_user=new User();
					n_user.setId(user.getId());
					n_user.setPass(String.valueOf(passwordField_1.getPassword()).trim());
					System.out.println("aa获取到的密码"+n_user.getPass());
					SendMsg smsg=new SendMsg(s,n_user,msg);
					smsg.sendMsg(oos);
					
				}
			}
		});
		button.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(Color.decode("#3BC0C3"));
		button.setForeground(Color.decode("#ffffff"));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(label)
							.addComponent(label_1))
						.addComponent(label_2))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField_2)
						.addComponent(passwordField)
						.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
					.addContainerGap(101, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(335, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setTitle("修改密码");
		setVisible(true);
	}
}
