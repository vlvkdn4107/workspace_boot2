package Review;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HH_CheckDate {

	private Calendar calendar;
	private DateFormat dateFormat;
	
	public HH_CheckDate() {
		initObject();
	}
	private void initObject() {
		calendar = Calendar.getInstance();
		dateFormat = new SimpleDateFormat("yyyy.MM.dd. HH:mm:ss");
	}
	public String checkDate() {
		return dateFormat.format(calendar.getTimeInMillis());
	}
	
	
}
