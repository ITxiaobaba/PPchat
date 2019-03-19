package zd.s8.t1.util;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.MsgUserDataBag;
import zd.s8.t1.model.User;
import zd.s8.t1.tools.ManageChatPanel;
import zd.s8.t1.tools.UpdateChat;
import zd.s8.t1.view.AddFriendUI;
import zd.s8.t1.view.ChatPanel;

import java.io.*;
public class ClientConServerThread extends Thread{
	private List<User> mngfriend=new ArrayList<User>();
	private boolean isRunning = true;
	private MsgUserDataBag mudb=new MsgUserDataBag();
	private Socket s;
	private User user;
	private Message msg;
	private boolean isUpSu;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	public ClientConServerThread(Socket s,ObjectOutputStream oos,ObjectInputStream ois) {
		// TODO Auto-generated constructor stub
		this.setS(s);
		this.oos=oos;
		this.ois=ois;
	}
	public void receive(Socket s) {
		try {
			ois=new ObjectInputStream(s.getInputStream());
			mudb=(MsgUserDataBag)ois.readObject();
			if(mudb.getMsg().getMsgType().equals("3")) {
				//��ͨ������Ϣ
				ChatPanel cp=ManageChatPanel.getChatUI(mudb.getMsg().getSender());
				if(cp==null) {
					cp=new ChatPanel(this.getUser(),mudb.getMsg().getSender(),
							mudb.getUser().getName(),s,oos,ois);
					ManageChatPanel.addChatUI(cp);
				}
				else {
					cp.setVisible(true);
				}
				UpdateChat uc=new UpdateChat(cp.getChatArea(),mudb.getMsg());
			}else if(mudb.getMsg().getMsgType().equals("5")) {
				//�Ӻ���
				AddFriendUI afui=new AddFriendUI(getUser());
				if(afui.getAgree().equals("2")) {//trueͬ����Ӻ��ѣ�false�ܾ�
					mudb.getMsg().setMsgType("11");
					SendMsg smgadd=new SendMsg(s,mudb.getUser(),mudb.getMsg());
					smgadd.sendMsg(oos);
				}else if(afui.getAgree().equals("3")){
					mudb.getMsg().setMsgType("12");
					SendMsg smgadd=new SendMsg(s,mudb.getUser(),mudb.getMsg());
					smgadd.sendMsg(oos);
				}
				
			}else if(mudb.getMsg().getMsgType().equals("6")) {
				//�޸�����ɹ�true
				setUpSu(true);
				JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
				System.out.println("�޸ĳɹ�");
			}else if(mudb.getMsg().getMsgType().equals("7")) {
				//�޸�����ʧ��false
				setUpSu(false);
				JOptionPane.showMessageDialog(null,"�޸�ʧ��");
			}else if(mudb.getMsg().getMsgType().equals("8")) {
				//���غ����б�
				this.setMngfriend(mudb.getFriends().getFriendlist());
			}else if(mudb.getMsg().getMsgType().equals("11")) {
				JOptionPane.showMessageDialog(null, "��Ӻ��ѳɹ�");
			}else if(mudb.getMsg().getMsgType().equals("12")) {
				JOptionPane.showMessageDialog(null, "��Ǹ���Է��ܾ������Ϊ����");
			}
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			receive(getS());
		}
	}
	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Message getMsg() {
		return msg;
	}
	public void setMsg(Message msg) {
		this.msg = msg;
	}
	public boolean isUpSu() {
		return isUpSu;
	}
	public void setUpSu(boolean isUpSu) {
		this.isUpSu = isUpSu;
	}
	public List<User> getMngfriend() {
		return mngfriend;
	}
	public void setMngfriend(List<User> mngfriend) {
		this.mngfriend = mngfriend;
	}
}
