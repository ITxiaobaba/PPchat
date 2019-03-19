package zd.s8.t1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegResult extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public RegResult(String id,String name) {//id获取注册的账号，name获取注册昵称
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Eclipse\\anzhuang\\LiuYanClient\\image\\inithead.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(410, 170, 381, 270);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#ffffff"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblpp = new JLabel("\u60A8\u597D\uFF0C\u8FD9\u662F\u60A8\u6CE8\u518C\u7684PP\u8D26\u53F7\uFF0C\u8BF7\u60A8\u8BB0\u4F4F\u6CE8\u518C\u7684\u4FE1\u606F\u53CA\u5BC6\u7801");
		lblpp.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		
		JLabel ppid = new JLabel(id);
		ppid.setForeground(Color.RED);
		ppid.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		
		JLabel label = new JLabel("\u8FD9\u662F\u60A8\u7684\u6635\u79F0");
		label.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		
		JLabel ppname = new JLabel(name);
		ppname.setForeground(Color.RED);
		ppname.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				dispose();
			}
		});
		button.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(Color.decode("#EECFA1"));
		button.setForeground(Color.decode("#ffffff"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblpp)
						.addComponent(ppid)
						.addComponent(label)
						.addComponent(ppname))
					.addContainerGap(45, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(264, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblpp, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ppid)
					.addGap(18)
					.addComponent(label)
					.addGap(18)
					.addComponent(ppname)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
}
