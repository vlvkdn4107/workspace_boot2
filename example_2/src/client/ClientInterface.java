package client;

public interface ClientInterface {

	void connectServer();
	void runServer(String[] msg);
	void getLog(String msg);
	void network();
	void sendmessage(String msg);
}
