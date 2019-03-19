package zd.s8.t1.tools;

import java.util.HashMap;


import zd.s8.t1.view.ChatPanel;

public class ManageChatPanel {
	
	private static HashMap<String, ChatPanel> map = new HashMap<String, ChatPanel>();
	
	//��map���桰ע�ᡱ
	public static void addChatUI(ChatPanel chatui) {
		map.put(chatui.getUserid(),chatui);	
	}
	
	//�رմ��ں�Ҫɾ��
	public static void deletChatUI(String id) {
		
		//ɾ��֮ǰ�鿴�Ƿ����������, ��ֹ����
		if(map.get(id) != null) {
			map.remove(id);
		}
		
	}
	
	//ͨ��id���ش���
	public static ChatPanel getChatUI(String id) {
		return map.get(id);
	}
}
