package zd.s8.t1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.User;
import zd.s8.t1.util.UserLoginClient;
import zd.s8.t1.util.UserRegisterId;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Registerui extends JFrame {

	private JPanel contentPane;
	private JTextField nameRe;
	private JPasswordField passRe;
	private JPasswordField passRe2;
	private JTextField phoneNo;
	private JRadioButton manButton;
	private JRadioButton womanButton;

	/**
	 * Create the frame.
	 */
	public Registerui() {
		setTitle("P_P账号注册");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Eclipse\\anzhuang\\LiuYanClient\\image\\namelabel.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(390, 150, 600, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#FFFFFF"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u6635\u79F0",JLabel.CENTER);
		label.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		
		JLabel label_1 = new JLabel("\u6027\u522B",JLabel.CENTER);
		label_1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		
		JLabel label_2 = new JLabel("\u8BBE\u7F6E\u5BC6\u7801",JLabel.CENTER);
		label_2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801",JLabel.CENTER);
		label_3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		nameRe = new JTextField();
		nameRe.setColumns(10);
		
		passRe = new JPasswordField();
		passRe.setColumns(10);
		
		passRe2 = new JPasswordField();
		passRe2.setColumns(10);
		manButton = new JRadioButton("男");
		manButton.setFocusPainted(false);
		manButton.setForeground(Color.DARK_GRAY);
		manButton.setBackground(Color.decode("#ffffff"));
		manButton.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
		
		womanButton = new JRadioButton("女");
		womanButton.setFocusPainted(false);
		womanButton.setForeground(Color.DARK_GRAY);
		womanButton.setBackground(Color.decode("#ffffff"));
		womanButton.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(manButton);
		bg.add(womanButton);
		
		JLabel titleLabel = new JLabel("P _ P",JLabel.CENTER);
		titleLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
		titleLabel.setForeground(Color.decode("#EECFA1"));
		
		JButton regBu = new JButton("注册");
		regBu.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		regBu.setFocusPainted(false);
		regBu.setBorder(null);
		regBu.setBackground(Color.decode("#EECFA1"));
		regBu.setForeground(Color.decode("#ffffff"));
		
		JLabel lblNewLabel = new JLabel("手机号",JLabel.CENTER);
		lblNewLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		
		phoneNo = new JTextField();
		phoneNo.setColumns(10);
		
		//
		regBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((String.valueOf(passRe.getPassword()).trim()).equals(String.valueOf(passRe2.getPassword()).trim())) {
					Message msg=new Message();
					User user=new User();
					msg.setMsgType("4");//发起注册请求
					user.setName(nameRe.getText().trim());
					user.setPass(String.valueOf(passRe2.getPassword()).trim());
					if(manButton.isSelected()) {
						user.setSex("男");
					}else if(womanButton.isSelected()){
						user.setSex("女");
					}
					user.setState(false);
					user.setUser_phone(phoneNo.getText());
					UserRegisterId url=new UserRegisterId(user,msg);
					if(url.isRegister()) {
						dispose();//关闭登录窗口而不关闭客户端
						RegResult rr=new RegResult(url.getA().getReceiver(),user.getName());
						
					}
					else {
						JOptionPane.showMessageDialog(null, "注册失败");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"两次密码不同");
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(264)
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(212))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(170)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(phoneNo, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(manButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(womanButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(passRe, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(passRe2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(nameRe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addGap(143))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(471, Short.MAX_VALUE)
					.addComponent(regBu, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(titleLabel)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(nameRe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(manButton)
						.addComponent(womanButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passRe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(passRe2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(phoneNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(regBu))
		);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
}
