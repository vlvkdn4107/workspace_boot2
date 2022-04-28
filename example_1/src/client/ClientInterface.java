package client;

public interface ClientInterface {

	void connectServer();
	void runServer();
	String[] getLog(String msg);
	void network();
	void inmessage(String msg);
	void sendmessage(String msg);
}
