package zd.s8.t1.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zd.s8.t1.model.User;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFriendUI extends JFrame {

	private JPanel contentPane;

	private String agree="2";
	public void setAgree(String agree) {
		this.agree=agree;
	}
	public String getAgree() {
		return agree;
	}

	/**
	 * Create the frame.
	 */
	public AddFriendUI(User u) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 367, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(u.getId()+" "+u.getName()+"请求添加您为好友");
		
		JButton button = new JButton("\u540C\u610F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAgree("2");
			}
		});
		
		JButton button_1 = new JButton("\u62D2\u7EDD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAgree("3");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addGap(18)
					.addComponent(button_1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
}
