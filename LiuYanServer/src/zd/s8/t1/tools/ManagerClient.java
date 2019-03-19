package zd.s8.t1.tools;
import java.util.*;

import zd.s8.t1.model.User;

import java.net.*;
/**
 * ����socket����
 * ��Socket����HashMap�й���
 * @author DELL
 *
 */
public class ManagerClient {
	private static HashMap<String, Socket> map = new HashMap<String, Socket>();

	public static void addSocket(User user,Socket s) {
		map.put(user.getId(),s);	
	}
	//ͨ��id����socket
	public static Socket getSocket(String id) {
		return map.get(id);
	}
	
	public static HashMap<String, Socket> getMap(){
		return map;
	}
	public static void deleteSocket(String id) {
		if(map.get(id) != null) {
			map.remove(id);
		}
		return;
	}
}
