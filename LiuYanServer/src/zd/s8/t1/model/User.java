package zd.s8.t1.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String user_id;	//账号
	public String getId() {
		return user_id;
	}
	public void setId(String id) {
		user_id=id;
	}
	private String user_name;	//用户昵称
	public String getName() {
		return user_name;
	}
	public void setName(String name) {
		user_name=name;
	}
	private String user_sex;	//用户性别
	public String getSex() {
		return user_sex;
	}
	public void setSex(String sex) {
		user_sex=sex;
	}
	private String user_pass;	//密码
	public String getPass() {
		return user_pass;
	}
	public void setPass(String pass) {
		user_pass=pass;
	}
	private boolean user_state=false;	//用户状态，默认为false即不在线
	public boolean getState() {
		return user_state;
	}
	public void setState(boolean state) {
		user_state=state;
	}
	//用户电话号码
	private String user_phone;
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	//用户头像id
	private String headid;
	public String getHeadid() {
		return headid;
	}
	public void setHeadid(String headid) {
		this.headid = headid;
	}
}
