package zd.s8.t1.tools;
/**
 * ¸üÐÂTextArea
 */
import javax.swing.JTextArea;

import zd.s8.t1.model.Message;

public class UpdateChat {
	private JTextArea jta;
	public UpdateChat(JTextArea jta,Message msg) {
		jta.append(msg.getSender()+" :\n"+"  "+msg.getMsgtext()+"\n");
	}
}
