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
		System.out.println("当前IP地址为："+ip);
		
		try {
			System.out.println("服务器监听在端口9961");
			ServerSocket ss=new ServerSocket(9961);
			
			while(true) {
				//客户端第一次尝试连接服务器
				Socket s=ss.accept();
				ObjectInputStream ois=null;
				DataOutputStream dos=null;
				ObjectOutputStream oos=null;
				System.out.println("we have a new client coming");
				ois=new ObjectInputStream(s.getInputStream());
				Message msg=(Message)ois.readObject();
				User user=(User)ois.readObject();
				System.out.println("接收到的UserPass: "+user.getPass());
				if(msg.getMsgType().equals("1")) {
					String a=isLogin(msg,user);
					System.out.println("从客户端接收道德消息类型 "+msg.getMsgType()+" 接收到的用户密码: "+user.getPass());
					dos=new DataOutputStream(s.getOutputStream());
					oos=new ObjectOutputStream(s.getOutputStream());
					dos.writeUTF(a);
					oos.writeObject(getUser(user));
					System.out.println("返回给客户端 "+a);
					ServerConSql scs=new ServerConSql();
					MsgUserDataBag msgb=new MsgUserDataBag();
					msgb.setMsg(msg);
					msgb.setUser(user);
					MsgUserDataBag mudb=new MsgUserDataBag();
					mudb=scs.getFriendList(msgb);
					oos.writeObject(mudb);
					//管理Socket
					ServerConClientThread scct =new ServerConClientThread(s,oos,ois);
					scct.start();
					ManagerClient.addSocket(user, s);
				}
				else if(msg.getMsgType().equals("4")) {
					Message a=isRegster(msg,user);
					oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(a);
					System.out.println("返回给客户端 消息类 "+a.getMsgType()+"返回个客户端账号"+a.getReceiver());
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
