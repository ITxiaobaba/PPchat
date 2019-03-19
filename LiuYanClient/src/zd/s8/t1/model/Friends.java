package zd.s8.t1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 好友表包括
 * 1.表添加纪录id
 * 2.发送者id
 * 3.接收者id
 * @author DELL
 *
 */
public class Friends implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<User> friendlist =new ArrayList<User>();
	//好友id
	private String friendid;
	//发送者id
	private String sendid;
	//接收者id
	private String receiveid;
	public String getFriendid() {
		return friendid;
	}
	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}
	public String getSendid() {
		return sendid;
	}
	public void setSendid(String sendid) {
		this.sendid = sendid;
	}
	public String getReceiveid() {
		return receiveid;
	}
	public void setReceiveid(String receiveid) {
		this.receiveid = receiveid;
	}
	public List<User> getFriendlist() {
		return friendlist;
	}
	public void addFriendlist(User u) {
		friendlist.add(u);
	}
}
