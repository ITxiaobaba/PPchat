package zd.s8.t1.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.BorderFactory;

import zd.s8.t1.model.Message;

public class MsgList extends JLabel implements ListCellRenderer{
	private Icon icons;
	private Message msg;
	public MsgList() {
		
	}
	public MsgList(Icon icons) {
		this.icons=icons;
	}
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		String s=value.toString();
		setText(s);
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		if(isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setIcon(icons);//…Ë÷√Õº∆¨
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);
		return this;
	}

}
