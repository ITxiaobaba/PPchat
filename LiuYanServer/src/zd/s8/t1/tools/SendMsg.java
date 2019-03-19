package zd.s8.t1.tools;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import zd.s8.t1.model.Message;
import zd.s8.t1.model.MsgUserDataBag;
import zd.s8.t1.model.User;

public class SendMsg {
	private Socket s;
	private MsgUserDataBag mudb;
	public SendMsg(Socket s,MsgUserDataBag mudb) {
		setS(s);
		this.setMudb(mudb);
	}
	public void sendMsg(ObjectOutputStream oos,MsgUserDataBag mudb) {
		try {
			oos.writeObject(mudb);
			System.out.println("此处正确");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
	public MsgUserDataBag getMudb() {
		return mudb;
	}
	public void setMudb(MsgUserDataBag mudb) {
		this.mudb = mudb;
	}
}
