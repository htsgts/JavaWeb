package day10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseClassEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. System
		System.out.println("Current time : " + System.currentTimeMillis());
		
		long point1, point2;
		long elapsedTime;
		
		point1 = System.currentTimeMillis();
		for(int i=0; i<1000000000; i++) {
			;
		}
		point2 = System.currentTimeMillis();
		elapsedTime = point2 - point1;
		System.out.println("for 수행시간(1억번) : " + elapsedTime + "(ms)");
		
		// 2. StringBuffer
		StringBuffer sb = new StringBuffer();
		sb.append("Eriks SteakHouse");
		System.out.println(sb);
		
		sb.insert(6, "Famous ");
		System.out.println(sb);
		try {
			sb.insert(100, "Hahaha");  // 문자열의 총 길이를 넘어가면 예외 발생
		}
		catch(Exception e) {
			System.out.println("아 안들어가네 미안");
		}
		
		sb.delete(1, 10);
		System.out.println(sb);
		sb.delete(3, 100000);
		System.out.println(sb);
		
		// String, StringBuffer Performance Contest
		String app1 = "";
		StringBuffer app2 = new StringBuffer();
		
		final int SAMPLE_CNT = 100000;
		long elapsedTime1, elapsedTime2;
		
		point1 = System.currentTimeMillis();
		for(int i=0; i<SAMPLE_CNT; i++)
			app1 = app1 + i;  // 0 01 012 0123 ...
		point2 = System.currentTimeMillis();
		elapsedTime1 = point2 - point1;
		
		point1 = System.currentTimeMillis();
		for(int i=0; i<SAMPLE_CNT; i++)
			app2.append(i);  // 0 01 012 0123 ...
		point2 = System.currentTimeMillis();
		elapsedTime2 = point2 - point1;
		
		System.out.println("*** Performance Contest Result ***");
		System.out.println("String : " + elapsedTime1);
		System.out.println("StringBuffer : " + elapsedTime2);
		
		// 3. Math
		// getRound라는 메서드를 만든다. getRound(a, b), b >= 0
		// a를 소수점b개 만큼 남기는 메서드
		// Math.round(100.38) => 100을 이용하시오.
		System.out.println("getRound(124.382, 1) = " + getRound(124.382, 1));
		
		// 4. Date & Calendar
		Date d = new Date();
		System.out.println("현재 시간 : " + d);
		
		// format이 맘에 안드는 경우
		SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat f3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		System.out.println("현재 시간 : " + f1.format(d));
		System.out.println("현재 시간 : " + f2.format(d));
		System.out.println("현재 시간 : " + f3.format(d));
		
		Calendar c = Calendar.getInstance();
		
		// get 메서드로 내가 원하는 달력의 값을 얻어낸다.
		System.out.println("오늘의 요일 : " + c.get(Calendar.DAY_OF_WEEK));
		System.out.println("오늘의 연도 : " + c.get(Calendar.YEAR));
		System.out.println("오늘의 월 : " + (c.get(Calendar.MONTH) + 1));
		System.out.println("오늘의 일 : " + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("오늘의 올해의 몇번째 날 : " + c.get(Calendar.DAY_OF_YEAR));
		
		
		
	}
	
	public static double getRound(double a, int b) {
		double result = 0.0;
		result = a;
		
		// 10을 b의 회수만큼 곱한다.
		for(int i=0; i<b; i++) {
			result = result * 10;
		}
		
		// Math.round - 소수점 이하를 버린다.
		result = Math.round(result);
		
		// 10을 b의 회수만큼 나눈다.
		for(int i=0; i<b; i++) {
			result = result / 10;
		}
		
		return result;
	}

}
