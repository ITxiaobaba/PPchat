package zd.s8.t1.model;

import java.io.Serializable;

/**
 * Ⱥ��ģ�Ͱ���
 *1.Ⱥ��id
 *2.Ⱥ����
 * @author DELL
 *
 */
public class Group implements Serializable{
	private static final long serialVersionUID = 1L;

	//Ⱥ��id
	private String groupid;
	//Ⱥ����
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
