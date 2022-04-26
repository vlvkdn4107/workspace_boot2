package Client;

public interface ClientInterface {

	void connectServer();
	void network();
	void inmessage(String str);
	void sendmessage(String msg);
}
