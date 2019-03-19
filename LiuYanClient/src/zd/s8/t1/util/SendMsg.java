package zd.s8.t1.util;
import java.io.*;
import java.net.*;
import java.util.*;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.MsgUserDataBag;
import zd.s8.t1.model.User;
public class SendMsg {
	private Socket s;
	private User user;
	private Message msg;
	public SendMsg(Socket s,User user,Message msg) {
		setS(s);
		this.setMsg(msg);
		this.setUser(user);
	}
	public void sendMsg(ObjectOutputStream oos) {
		try {
			MsgUserDataBag mudb=new MsgUserDataBag();
			mudb.setUser(user);
			mudb.setMsg(msg);
			oos.writeObject(mudb);
			System.out.println("此处正确");
		}catch(IOException e) {
			e.printStackTrace();
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
}
