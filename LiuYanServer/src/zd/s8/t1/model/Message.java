package zd.s8.t1.model;
/**
 * msgType=1时，登陆成功
 * msgType=2时，登陆失败
 * msgType=3时，发送消息
 * msgType=4时，注册帐户
 * msgType=10时，注册帐户失败
 * msgType=5时，获取好友列表
 * msgType=6时，修改密码成功
 * msgType=7时，修改密码失败
 * msgType=8时，获取好友列表
 * msgType=9时，修改密码请求
 * msgType=11时，同意添加好友
 */
import java.io.*;
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	//消息id
	private String msgid;
	//消息文本内容
	private String msgtext;
	//消息类型
	private String msgType;
	//消息发送者
	private String sender;
	//接收者
	private String receiver;
	//发送日期
	private String sendDate;
	public String getMsgtext() {
		return msgtext;
	}
	public void setMsgtext(String msgtext) {
		this.msgtext = msgtext;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
}
