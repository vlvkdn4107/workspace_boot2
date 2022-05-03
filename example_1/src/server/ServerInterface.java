package server;

public interface ServerInterface {

	void starNetwork(int port);
	void connect();
	void broadCast(String msg);
	
	void inmessage(String msg);
	
	//방
	void roomBroadcast(String str);
	void addUser();
	void removeRoom();


}
