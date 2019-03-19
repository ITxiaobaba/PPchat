package zd.s8.t1.util;
/**
 * .��¼����
 * 1.����ͼ�㴫������
 * 2.���������͸�������
 * 3.���ܷ������ش�������
 * 4.�ж������Ƿ���ϵ�¼����
 */
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.MsgUserDataBag;
import zd.s8.t1.model.User;

import java.net.*;
public class UserLoginClient {
	private List<User> mngfriend=new ArrayList<User>();
	private String a;
	private Socket s;
	private User user;
	private ObjectOutputStream oos=null;
	public ObjectOutputStream getOOS() {
		return oos;
	}
	private DataInputStream dis = null;
	public ObjectInputStream getOIS() {
		return ois;
	}
	private ObjectInputStream ois=null;
	public UserLoginClient(Message msg,User user) {
		
		try {
			Socket s=new Socket("127.0.0.1",9961);
			setS(s);
			oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(msg);
			oos.writeObject(user);
			dis=new DataInputStream(s.getInputStream());
			ois=new ObjectInputStream(s.getInputStream());
			this.a=(String)dis.readUTF();
			this.user=(User)ois.readObject();
			mngfriend=((MsgUserDataBag)ois.readObject()).getFriends().getFriendlist();
			if(isLogin()) {
				//Ϊ�ͻ��˵���һ���߳��������ͨ��
				ClientConServerThread ccst=new ClientConServerThread(s,oos,ois);
				ccst.start();
			}else {
				JOptionPane.showMessageDialog(null,"��½ʧ�ܣ��˺Ż��������");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isLogin() {
		boolean b=false;
		if(this.a.equals("1")) {
			b=true;
		}
		return b;
	}
	public void sendgetfriend(Socket s,User u,Message m,ObjectOutputStream oos) {
		MsgUserDataBag mudb=new MsgUserDataBag();
		mudb.setUser(u);
		mudb.setMsg(m);
		try {
			oos.writeObject(mudb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User getuser() {
		return this.user;
	}
	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
	public List<User> getMngfriend() {
		return mngfriend;
	}
	public void setMngfriend(List<User> mngfriend) {
		this.mngfriend = mngfriend;
	}

}
