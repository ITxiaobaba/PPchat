package zd.s8.t1.model;

import java.io.Serializable;

/**
 * 群组模型包括
 *1.群组id
 *2.群组名
 * @author DELL
 *
 */
public class Group implements Serializable{
	private static final long serialVersionUID = 1L;

	//群组id
	private String groupid;
	//群组名
	private String groupname;
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
}
