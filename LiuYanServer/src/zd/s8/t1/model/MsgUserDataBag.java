package zd.s8.t1.model;

import java.io.Serializable;

public class MsgUserDataBag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Message msg;
	private User user;
	private Friends friends;
	private Group group;
	public Message getMsg() {
		return msg;
	}
	public void setMsg(Message msg) {
		this.msg = msg;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Friends getFriends() {
		return friends;
	}
	public void setFriends(Friends friends) {
		this.friends = friends;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
}
