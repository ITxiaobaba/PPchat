package zd.s8.t1.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String user_id;	//�˺�
	public String getId() {
		return user_id;
	}
	public void setId(String id) {
		user_id=id;
	}
	private String user_name;	//�û��ǳ�
	public String getName() {
		return user_name;
	}
	public void setName(String name) {
		user_name=name;
	}
	private String user_sex;	//�û��Ա�
	public String getSex() {
		return user_sex;
	}
	public void setSex(String sex) {
		user_sex=sex;
	}
	private String user_pass;	//����
	public String getPass() {
		return user_pass;
	}
	public void setPass(String pass) {
		user_pass=pass;
	}
	private boolean user_state=false;	//�û�״̬��Ĭ��Ϊfalse��������
	public boolean getState() {
		return user_state;
	}
	public void setState(boolean state) {
		user_state=state;
	}
	//�û��绰����
	private String user_phone;
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	//�û�ͷ��id
	private String headid;
	public String getHeadid() {
		return headid;
	}
	public void setHeadid(String headid) {
		this.headid = headid;
	}
}
