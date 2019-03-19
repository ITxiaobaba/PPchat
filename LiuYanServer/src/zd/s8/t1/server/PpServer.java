package zd.s8.t1.server;
import java.io.*;
import zd.s8.s1.util.*;
import java.util.*;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.MsgUserDataBag;
import zd.s8.t1.model.User;
import zd.s8.t1.tools.ManagerClient;
import zd.s8.t1.tools.ServerConClientThread;
import zd.s8.s1.util.*;
import java.sql.*;
import java.io.IOException;
import java.net.*;
public class PpServer {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress host=InetAddress.getLocalHost();
		String ip=host.getHostAddress();
		System.out.println("��ǰIP��ַΪ��"+ip);
		
		try {
			System.out.println("�����������ڶ˿�9961");
			ServerSocket ss=new ServerSocket(9961);
			
			while(true) {
				//�ͻ��˵�һ�γ������ӷ�����
				Socket s=ss.accept();
				ObjectInputStream ois=null;
				DataOutputStream dos=null;
				ObjectOutputStream oos=null;
				System.out.println("we have a new client coming");
				ois=new ObjectInputStream(s.getInputStream());
				Message msg=(Message)ois.readObject();
				User user=(User)ois.readObject();
				System.out.println("���յ���UserPass: "+user.getPass());
				if(msg.getMsgType().equals("1")) {
					String a=isLogin(msg,user);
					System.out.println("�ӿͻ��˽��յ�����Ϣ���� "+msg.getMsgType()+" ���յ����û�����: "+user.getPass());
					dos=new DataOutputStream(s.getOutputStream());
					oos=new ObjectOutputStream(s.getOutputStream());
					dos.writeUTF(a);
					oos.writeObject(getUser(user));
					System.out.println("���ظ��ͻ��� "+a);
					ServerConSql scs=new ServerConSql();
					MsgUserDataBag msgb=new MsgUserDataBag();
					msgb.setMsg(msg);
					msgb.setUser(user);
					MsgUserDataBag mudb=new MsgUserDataBag();
					mudb=scs.getFriendList(msgb);
					oos.writeObject(mudb);
					//����Socket
					ServerConClientThread scct =new ServerConClientThread(s,oos,ois);
					scct.start();
					ManagerClient.addSocket(user, s);
				}
				else if(msg.getMsgType().equals("4")) {
					Message a=isRegster(msg,user);
					oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(a);
					System.out.println("���ظ��ͻ��� ��Ϣ�� "+a.getMsgType()+"���ظ��ͻ����˺�"+a.getReceiver());
					s.close();
				}
			}
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param msg
	 * @param user
	 * @return
	 */
	public static String isLogin(Message msg,User user) {
		String b="2";
		ServerConSql scs=new ServerConSql();
		User u=scs.getUser(user.getId());
		if(msg.getMsgType().equals("1")&&u.getId().equals(user.getId())&&u.getPass().equals(user.getPass())) {
			b="1";
		}
		return b;
	}
	public static Message isRegster(Message msg,User user) {
		Message m=new Message();
		ServerConSql scs=new ServerConSql();
		m.setReceiver(scs.regster(user));
		//m.setReceiver(scs.regster(user));
		System.out.println("ww"+m.getReceiver());
		m.setMsgType("4");
		return m;
	}
	public static User getUser(User user) {
		ServerConSql scs=new ServerConSql();
		User u=scs.getUser(user.getId());
		return u;
	}
}
