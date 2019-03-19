package zd.s8.t1.tools;

import java.net.Socket;

import zd.s8.s1.util.ServerConSql;
import zd.s8.t1.model.Message;
import zd.s8.t1.model.MsgUserDataBag;
import zd.s8.t1.model.User;

import java.io.*;
public class ServerConClientThread extends Thread{
	private ServerConSql scs=new ServerConSql();
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	private Socket s;
	public ServerConClientThread(Socket s,ObjectOutputStream oos,ObjectInputStream ois) {
		this.s=s;
		this.oos=oos;
		this.ois=ois;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(s!=null) {
			try {
				MsgUserDataBag msg=(MsgUserDataBag)ois.readObject();
				//�޸�����
				if(msg.getMsg().getMsgType().equals("9")) {
					System.out.println("jieshoudao����9");
					//
					if(scs.updatePass(msg.getUser(), msg.getMsg())) {
						Message m=new Message();
						m.setMsgType("6");
						MsgUserDataBag mudb=new MsgUserDataBag();
						mudb.setMsg(m);
						oos.writeObject(mudb);
					}
				}
				else if(msg.getMsg().getMsgType().equals("8")) {//��ȡ�����б�����
					System.out.println("���յ��ĺ����б�����");
					MsgUserDataBag mudb=new MsgUserDataBag();
					mudb=scs.getFriendList(msg);
					oos.writeObject(mudb);
					//����MsgUserDataBag getFriendList(MsgUserDataBag mudb)
				}else if(msg.getMsg().getMsgType().equals("3")) {
					System.out.println(msg.getMsg().getMsgtext());
					String id=msg.getMsg().getReceiver();
					SendMsg smg=new SendMsg(ManagerClient.getSocket(id),msg);
					smg.sendMsg(new ObjectOutputStream(ManagerClient.getSocket(id).getOutputStream()), msg);
				}else if(msg.getMsg().getMsgType().equals("5")) {
					System.out.println(msg.getMsg().getMsgtext());
					String id=msg.getMsg().getReceiver();
					SendMsg smg=new SendMsg(ManagerClient.getSocket(id),msg);
					smg.sendMsg(new ObjectOutputStream(ManagerClient.getSocket(id).getOutputStream()), msg);
				}else if(msg.getMsg().getMsgType().equals("11")) {
					//��Ӻ��ѳɹ�
					scs.addFriend(msg);
					String id=msg.getMsg().getSender();
					SendMsg smg=new SendMsg(ManagerClient.getSocket(id),msg);
					smg.sendMsg(new ObjectOutputStream(ManagerClient.getSocket(id).getOutputStream()), msg);
				}else if(msg.getMsg().getMsgType().equals("12")) {
					//��Ӻ���ʧ��
					String id=msg.getMsg().getSender();
					SendMsg smg=new SendMsg(ManagerClient.getSocket(id),msg);
					smg.sendMsg(new ObjectOutputStream(ManagerClient.getSocket(id).getOutputStream()), msg);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
