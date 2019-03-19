package zd.s8.t1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ���ѱ����
 * 1.����Ӽ�¼id
 * 2.������id
 * 3.������id
 * @author DELL
 *
 */
public class Friends implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<User> friendlist =new ArrayList<User>();
	//����id
	private String friendid;
	//������id
	private String sendid;
	//������id
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
