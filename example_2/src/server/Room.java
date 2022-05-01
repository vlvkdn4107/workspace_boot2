package server;

import java.util.Vector;

import lombok.Getter;
import view.ServerView;

@Getter
public class Room {
 
	private ServerView mContext;
	private String roomName;
	
	Vector<UserSocket> roomUser = new Vector<UserSocket>();
	
	
	public Room(String roomName, ServerView mContext) {
		this.roomName = roomName;
		this.mContext = mContext;
		
		
		mContext.getServerService().getRoomVc().add(this);
	}
}

