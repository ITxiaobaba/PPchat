package zd.s8.t1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.User;
import zd.s8.t1.util.SendMsg;
import zd.s8.t1.util.UserLoginClient;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logui extends JFrame {

	private JPanel contentPane;

	private JButton logButton;
	private JTextField userName;
	private JPasswordField userPass;
	private JLabel userLabel;
	private JLabel passLabel;
	private JLabel titleLabel;
	private JButton regButton;
	
	/**
	 * Create the frame.
	 */
	public Logui() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Eclipse\\anzhuang\\LiuYanClient\\image\\icon.png"));
		setForeground(Color.CYAN);
		setFont(new Font("Adobe Hebrew", Font.PLAIN, 15));
		setTitle("P _ P");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 160, 580, 360);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(Color.decode("#ffffff"));
		setContentPane(contentPane);
		
		Backpane panel = new Backpane();
		
		logButton = new JButton("Login");
		
		logButton.setFont(new Font("宋体",Font.PLAIN,13));
		logButton.setFocusPainted(false);
		logButton.setBackground(Color.decode("#FFFFFF"));
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//进行登录事件
				//代码
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Message msg=new Message();
							User user=new User();
							msg.setMsgType("1");//发起登录请求
							user.setId(userName.getText().trim());
							user.setPass(String.valueOf(userPass.getPassword()));
							UserLoginClient ulc=new UserLoginClient(msg,user);
							if(ulc.isLogin()) {
								User nuser=ulc.getuser();
								Homepage homepage = new Homepage(nuser,ulc.getS(),ulc.getOOS(),ulc.getOIS(),ulc.getMngfriend());
								dispose();//关闭登录窗口而不关闭客户端
							}
							else {
								System.out.print("密码错误");
							}
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		userName = new JTextField();
		userName.setColumns(10);
		
		userPass = new JPasswordField();
		userPass.setColumns(10);
		
		userLabel = new JLabel("User",JLabel.CENTER);
		userLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
		
		passLabel = new JLabel("Password",JLabel.CENTER);
		passLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
		
		titleLabel = new JLabel("P _ P",JLabel.CENTER);
		titleLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
		titleLabel.setForeground(Color.decode("#EECFA1"));
		
		regButton = new JButton("注册账号");
		
		regButton.setFocusPainted(false);
		regButton.setBackground(Color.decode("#FFFFFF"));
		regButton.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,11));
		regButton.setBorder(null);
		
		JButton forgetbu = new JButton("忘记密码？");
		forgetbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Findpassui find = new Findpassui();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		forgetbu.setBackground(Color.decode("#FFFFFF"));
		forgetbu.setFocusPainted(false);
		forgetbu.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,11));
		forgetbu.setBorder(null);
		
		//注册事件监听
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Registerui register = new Registerui();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(logButton, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(userLabel, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
										.addComponent(passLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(userPass, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
										.addComponent(userName, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(regButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(forgetbu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(53))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(userLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passLabel))
					.addGap(18)
					.addComponent(logButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(regButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(forgetbu)
					.addGap(64))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
