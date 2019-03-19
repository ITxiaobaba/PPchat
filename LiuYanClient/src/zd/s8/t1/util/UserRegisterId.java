package zd.s8.t1.util;
/**
 * 注册账号
 * 连接服务器
 * 服务器往数据库插入新User数据
 * 断开连接
 */
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.User;

import java.net.*;
public class UserRegisterId {
	private Message a=null;
	public Message getA() {
		return this.a;
	}
	private Socket s;
	private User user;
	
	public UserRegisterId(User user,Message msg) {
		ObjectOutputStream oos=null;
		DataInputStream dis = null;
		ObjectInputStream ois=null;
		try {
			Socket s=new Socket("127.0.0.1",9961);
			oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(msg);
			oos.writeObject(user);
			ois=new ObjectInputStream(s.getInputStream());
			this.a=(Message)ois.readObject();
			System.out.println(a.getMsgType()+a.getReceiver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isRegister() {
		boolean b=false;
		//注册成功
		if(this.a.getMsgType().equals("4")) {
			b=true;
		}
		return b;
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
	
}
