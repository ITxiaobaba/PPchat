package zd.s8.t1.view;

import java.awt.BorderLayout;
import zd.s8.t1.util.*;
import javax.swing.DefaultListModel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.MsgUserDataBag;
import zd.s8.t1.model.User;
import zd.s8.t1.tools.ManageChatPanel;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;

public class Homepage extends JFrame {
	private ManageChatPanel mcp=new ManageChatPanel();
	
	private Socket s;
	private Icon icon=new ImageIcon("image/Lyicon.jpg");
	private JLabel ownname;
	private JPanel contentPane;
	private JList friendlist;
	/**
	 * 好友滚动面板
	 */
	private JScrollPane friendList=new JScrollPane();
	/**
	 * 群组滚动面板
	 */
	private JScrollPane groupList=new JScrollPane();
	/**
	 * 卡片式布局
	 * 1.消息列表
	 * 2.好友列表
	 * 3.群组列表
	 */
	private final CardLayout c=new CardLayout();
	private JTextField searchuser;
	

	/**
	 * Create the frame.
	 */
	public Homepage(User ownuser,Socket s,ObjectOutputStream oos,ObjectInputStream ois,List<User> mngfriend) {
		this.s=s;
		this.setTitle("P_P");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Eclipse\\anzhuang\\LiuYanClient\\image\\icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 320, 640);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(Color.decode("#ffffff"));
		setContentPane(contentPane);
		
		JPanel backpanel = new JPanel();
		backpanel.setBorder(null);
		//backpanel.setBackground(SystemColor.window);
		backpanel.setBackground(Color.decode("#EECFA1"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		
		JPanel searchpane = new JPanel();
		searchpane.setBackground(Color.decode("#ffffff"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(backpanel, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
				.addComponent(searchpane, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(backpanel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchpane, GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		searchuser = new JTextField();
		searchuser.setColumns(10);
		
		JButton searchuserBu = new JButton("go");
		searchuserBu.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		searchuserBu.setForeground(Color.decode("#ffffff"));
		searchuserBu.setFocusPainted(false);
		searchuserBu.setBorder(null);
		searchuserBu.setBackground(Color.decode("#3BC0C3"));
		
		JButton addfriendBu = new JButton("+");
		addfriendBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//添加好友
				if(searchuser.getText()!="") {
					Message addmsg=new Message();
					addmsg.setMsgType("5");
					addmsg.setSender(ownuser.getId());
					addmsg.setReceiver(searchuser.getText());
					User senduser=new User();
					senduser.setId(ownuser.getId());
					senduser.setName(ownuser.getName());
					SendMsg sm=new SendMsg(s,senduser,addmsg);
					sm.sendMsg(oos);
				}
				
			}
		});
		addfriendBu.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		addfriendBu.setForeground(Color.decode("#ffffff"));
		addfriendBu.setFocusPainted(false);
		addfriendBu.setBorder(null);
		addfriendBu.setBackground(Color.decode("#3BC0C3"));
		GroupLayout gl_searchpane = new GroupLayout(searchpane);
		gl_searchpane.setHorizontalGroup(
			gl_searchpane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchpane.createSequentialGroup()
					.addContainerGap()
					.addComponent(searchuser, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchuserBu, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addfriendBu, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_searchpane.setVerticalGroup(
			gl_searchpane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchpane.createSequentialGroup()
					.addGroup(gl_searchpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchuser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchuserBu, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(addfriendBu, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(3))
		);
		searchpane.setLayout(gl_searchpane);
		panel_1.setLayout(c);
		friendList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		groupList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel_1.add("friendlist",friendList);
		panel_1.add("grouplist",groupList);
		friendList.setBorder(null);
		groupList.setBorder(null);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		//InfoPane
		
		
		
		
		//friendPane
		
		DefaultListModel listmodel=new DefaultListModel();
		for(int i=0;i<mngfriend.size();i++) {
			listmodel.add(i,mngfriend.get(i).getId()+" "+mngfriend.get(i).getName());
		}
		friendlist=new JList(listmodel);
		friendlist.setCellRenderer(new MsgList(icon));
		friendlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		friendList.setViewportView(friendlist);
		
		friendlist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(friendlist.getSelectedIndex()!=-1) {
					if(e.getClickCount()==2) {
						twoClick(friendlist.getSelectedValue());
					}
				}
				
			}
			private void twoClick(Object value) {
				ChatPanel cp=ManageChatPanel.getChatUI(mngfriend.get(friendlist.getSelectedIndex()).getId());
				if(cp==null) {
					cp=new ChatPanel(ownuser,mngfriend.get(friendlist.getSelectedIndex()).getId(),
							mngfriend.get(friendlist.getSelectedIndex()).getName(),s,oos,ois);
					ManageChatPanel.addChatUI(cp);
				}
				else {
					cp.setVisible(true);
				}
			}
		});
		
		
		JButton contactBu = new JButton("联系人");
		contactBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(panel_1,"friendlist");
			}
		});
		panel.add(contactBu);
		contactBu.setBorder(null);
		contactBu.setFocusPainted(false);
		contactBu.setBackground(Color.decode("#ffffff"));
		contactBu.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
		
		JButton groupBu = new JButton("群组");
		groupBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(panel_1, "grouplist");
			}
		});
		panel.add(groupBu);
		groupBu.setBorder(null);
		groupBu.setFocusPainted(false);
		groupBu.setBackground(Color.decode("#ffffff"));
		groupBu.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
		
		JButton headpic = new JButton();
		headpic.setBackground(Color.decode("#ffffff"));
		headpic.setIcon(icon);
		headpic.setBorder(null);
		headpic.setFocusPainted(false);
		
		ownname= new JLabel(ownuser.getName());
		ownname.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		ownname.setForeground(Color.decode("#ffffff"));
		
		JButton button = new JButton("修改密码");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePass cp=new ChangePass(ownuser,s,oos,ois);
			}
		});
		button.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		button.setFocusPainted(false);
		button.setBorder(null);
		button.setBackground(Color.decode("#3BC0C3"));
		button.setForeground(Color.decode("#ffffff"));
		
		JLabel id = new JLabel(ownuser.getId());
		id.setForeground(Color.decode("#ffffff"));
		id.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		
		JButton button_1 = new JButton("\u5B89\u5168\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.close();
					System.exit(JFrame.EXIT_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		button_1.setFocusPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(Color.decode("#3BC0C3"));
		button_1.setForeground(Color.decode("#ffffff"));
		
		GroupLayout gl_panel = new GroupLayout(backpanel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(headpic, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(id)
						.addComponent(ownname))
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(ownname)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(id))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(button_1)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(button))
							.addComponent(headpic, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		backpanel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}


	
}
