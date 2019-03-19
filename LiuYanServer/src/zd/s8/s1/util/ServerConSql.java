package zd.s8.s1.util;
import java.sql.*;
import java.io.*;
import java.util.*;

import zd.s8.t1.model.Friends;
import zd.s8.t1.model.Message;
import zd.s8.t1.model.MsgUserDataBag;
import zd.s8.t1.model.User;

import java.net.*;
public class ServerConSql {

	private Socket s;
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String ConnectionURL="jdbc:mysql://127.0.0.1:3306/";
	private static final String dbName="ppdatabase";//���ݿ�����
	private static final String Connector="?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
	private static final String dbroot="root";
	private static final String dbpass="123456";
	public ServerConSql() {
	}
	/**
	 * ���ڼ���¼
	 * ��ѯ����id��User����Ϣ
	 * @param id
	 * @param password
	 * @return
	 */
	public User getUser(String id) {
		User user=new User();
		String sql="select * from User where user_id='"+id+"'";
		Connection c=null;
		Statement s=null;
		String URL=ConnectionURL+dbName+Connector;
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection(URL,dbroot,dbpass);
			s=c.createStatement();
			ResultSet rs=s.executeQuery(sql);//��ѯ���
			while(rs.next()) {
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPass(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setUser_phone(rs.getString(6));
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(c!=null) {
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(s!=null) {
				try {
					s.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}
	
//	public User addUser() {
//		
//	}
	
	/**
	 * �޸�����
	 * �ɹ�����true
	 * ʧ�ܷ���false
	 * @param user
	 * @param msg
	 * @return
	 */
	public boolean updatePass(User user,Message msg) {
		System.out.println(user.getPass()+" "+user.getId());
		boolean isUp=false;
		String sup="select user_pass from user where user_id='"+user.getId()+"'";
		String sql="update user set user_pass='"+user.getPass()+"' where user_id='"+user.getId()+"'";
		Connection c=null;
		Statement s=null;
		String URL=ConnectionURL+dbName+Connector;
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection(URL,dbroot,dbpass);
			s=c.createStatement();
			ResultSet rs=s.executeQuery(sup);//��ѯ���password
			String u=null;
			while(rs.next()) {
				u=rs.getString(1);
			}
			if(u.equals(msg.getSender())) {
				s.execute(sql);
				isUp=true;
				System.out.println("�޸ĳɹ�");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(c!=null) {
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(s!=null) {
				try {
					s.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isUp;
	}
	/**
	 * ע���˺�
	 * ע��ʱ���������б�user.getId()_friends
	 * �ɹ������û�
	 * @param user
	 * @return
	 */
	public String regster(User user) {
		// TODO Auto-generated method stub
		String u=null;
		String sup="select * from user where user_id=(select max(user_id) from user)";//��ѯ���һ���˺�
		String sql="insert into user(user_name,user_pass,user_sex,user_state,user_phone) values('"
				+user.getName()+"','"+user.getPass()+"','"+user.getSex()+"','"+user.getState()+"','"+user.getUser_phone()+"')";
		
		Connection c=null;
		Statement s=null;
		String URL=ConnectionURL+dbName+Connector;
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection(URL,dbroot,dbpass);
			s=c.createStatement();
			s.execute(sql);
			ResultSet rs=s.executeQuery(sup);
			while(rs.next()) {
				u=rs.getString(1);
			}
			String cref="create table "+u+"_friends( friendid int not null, friendname varchar(255) null)";
			s.execute(cref);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(c!=null) {
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(s!=null) {
				try {
					s.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return u;
	}
	
	//��ȡ�����б�
	public MsgUserDataBag getFriendList(MsgUserDataBag mudb) {
		MsgUserDataBag m=new MsgUserDataBag();
		List<User> ul=new ArrayList<User>();
		String sql="select * from "+mudb.getUser().getId()+"_friends";
		Connection c=null;
		Statement s=null;
		String URL=ConnectionURL+dbName+Connector;
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection(URL,dbroot,dbpass);
			s=c.createStatement();
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getString(1));
				u.setName(rs.getString(2));
				System.out.println("����Id"+u.getId()+"������"+u.getName());
				ul.add(u);
			}
			Friends fri=new Friends();
			fri.setFriendlist(ul);
			m.setFriends(fri);
			Message msg=new Message();
			msg.setMsgType("8");
			msg.setReceiver(mudb.getUser().getId());
			m.setMsg(msg);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(c!=null) {
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(s!=null) {
				try {
					s.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return m;
	}
	
	
	//��Ӻ���
	public void addFriend(MsgUserDataBag mudb) {
		String sql1="insert into "+mudb.getMsg().getSender()+"_friends values('"+mudb.getMsg().getReceiver()+
				"','"+mudb.getMsg().getMsgtext()+"')";
		String sql2="select user_name from user where user_id='"+mudb.getMsg().getReceiver()+"'";
		String sql3="insert into "+mudb.getMsg().getReceiver()+"_friends values('"+mudb.getUser().getId()+
				"','"+mudb.getUser().getName()+"')";
		Connection c=null;
		Statement s=null;
		String URL=ConnectionURL+dbName+Connector;
		
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection(URL,dbroot,dbpass);
			s=c.createStatement();
			ResultSet rs=s.executeQuery(sql2);
			while(rs.next()) {
				mudb.getMsg().setMsgtext(rs.getString(1));
			}
			s.execute(sql1);
			s.execute(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(c!=null) {
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(s!=null) {
				try {
					s.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
