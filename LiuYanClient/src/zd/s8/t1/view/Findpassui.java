package zd.s8.t1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
/**
 * 找回密码
 * @author DELL
 *
 */
public class Findpassui extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JTextField username;
	private JTextField userphone;

	
	/**
	 * Create the frame.
	 */
	public Findpassui() {
		setTitle("P_P找回密码");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Eclipse\\anzhuang\\LiuYanClient\\image\\namelabel.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(390, 150, 600, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#ffffff"));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#EECFA1"));
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		
		JLabel label_1 = new JLabel("\u6635\u79F0");
		label_1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));

		JLabel label_2 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		label_2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));

		userid = new JTextField();
		userid.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		
		userphone = new JTextField();
		userphone.setColumns(10);
		
		JButton ok = new JButton("验证信息");
		//提交验证信息
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repass repass=new Repass();
				dispose();
			}
		});
		ok.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		ok.setFocusPainted(false);
		ok.setBorder(null);
		ok.setBackground(Color.decode("#EECFA1"));
		ok.setForeground(Color.decode("#ffffff"));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(168)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(userphone, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(username)
						.addComponent(userid, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(167, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(484, Short.MAX_VALUE)
					.addComponent(ok, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(userphone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addComponent(ok)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(182, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(138))
		);
		
		JLabel label_3 = new JLabel("\u5FD8\u8BB0\u5BC6\u7801\uFF1F\u4E0D\u7528\u62C5\u5FC3");
		label_3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		label_3.setForeground(Color.decode("#ffffff"));
		
		
		JLabel label_4 = new JLabel("\u6CE8\u518C\u7684\u4FE1\u606F\u5373\u53EF\u627E\u56DE\u5BC6\u7801");
		label_4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		label_4.setForeground(Color.decode("#ffffff"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(208, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addGap(184))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addGap(200))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(47)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_4)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
		
		
	}

}
