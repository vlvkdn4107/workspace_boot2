package ch02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarMainTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTimeInMillis());
		//현재시간 1000분에1초를 나타낸다 -->영어권,아시아,유럽 나라마다 시간이 달라서
		//보여주는 방식은 알아서 각자 알아서 구현해 라고 설계를 해둔거다
		//보기불편한 형식을 편하게 변환해서 사용하는 방법을 알아보자!
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");//다형성   y = 년도 M = 월 d = 일
		String date = dateFormat.format(calendar.getTimeInMillis());// 카렌다의 1000분의 1을 "yyyy.MM.dd HH:mm:ss" 형식으로 바꿔서 String date에 담아라
		System.out.println(date);
		
	}

}
