package zd.s8.t1.tools;

import java.util.HashMap;


import zd.s8.t1.view.ChatPanel;

public class ManageChatPanel {
	
	private static HashMap<String, ChatPanel> map = new HashMap<String, ChatPanel>();
	
	//向map里面“注册”
	public static void addChatUI(ChatPanel chatui) {
		map.put(chatui.getUserid(),chatui);	
	}
	
	//关闭窗口后要删除
	public static void deletChatUI(String id) {
		
		//删除之前查看是否有这个窗口, 防止出错
		if(map.get(id) != null) {
			map.remove(id);
		}
		
	}
	
	//通过id返回窗口
	public static ChatPanel getChatUI(String id) {
		return map.get(id);
	}
}
