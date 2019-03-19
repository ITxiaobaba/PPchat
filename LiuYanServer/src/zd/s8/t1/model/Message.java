package zd.s8.t1.model;
/**
 * msgType=1ʱ����½�ɹ�
 * msgType=2ʱ����½ʧ��
 * msgType=3ʱ��������Ϣ
 * msgType=4ʱ��ע���ʻ�
 * msgType=10ʱ��ע���ʻ�ʧ��
 * msgType=5ʱ����ȡ�����б�
 * msgType=6ʱ���޸�����ɹ�
 * msgType=7ʱ���޸�����ʧ��
 * msgType=8ʱ����ȡ�����б�
 * msgType=9ʱ���޸���������
 * msgType=11ʱ��ͬ����Ӻ���
 */
import java.io.*;
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	//��Ϣid
	private String msgid;
	//��Ϣ�ı�����
	private String msgtext;
	//��Ϣ����
	private String msgType;
	//��Ϣ������
	private String sender;
	//������
	private String receiver;
	//��������
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
