package zd.s8.t1.view;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class MessageList extends JList{
	private Icon icon=new ImageIcon("image/Lyicon.jpg");

	public MessageList(String senderid,String getterid) {
		JList msglist;
		DefaultListModel listmodel=new DefaultListModel();
		for(int i=0;i<20;i++) {
			listmodel.add(i,"gougou");
		}
		msglist=new JList(listmodel);
		msglist.setCellRenderer(new MsgList(icon));
		msglist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
