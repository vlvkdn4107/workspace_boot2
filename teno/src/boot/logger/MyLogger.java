package boot.logger;

import java.util.logging.Logger;

public class MyLogger {

	public static void printLog(String str) {
		Logger logger = Logger.getLogger("myCustomLog");
		logger.warning(str);//추가적으로 넣을수있게 String변수를 넣는다
	}
	
	
	
}
