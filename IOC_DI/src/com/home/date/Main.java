package com.home.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
		
		String date = "yyyyMMdd";
		Scanner scan = new Scanner(System.in);

		
		System.out.println("시작날짜 : ");
		String start_date = scan.next();

		System.out.println("종료날짜 : ");
		String end_date = scan.next();
		
		SimpleDateFormat simpleD = new SimpleDateFormat(date);
		
		Date start = simpleD.parse(start_date);
		Date end = simpleD.parse(end_date);
		
		ArrayList<String> date_list = new ArrayList<String>();
			
		Date currentDate = start;
		
		while(currentDate.compareTo(end) <= 0) {
			
			date_list.add(simpleD.format(currentDate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentDate);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			currentDate = cal.getTime();
			System.out.println(currentDate);
		}
		System.out.println("======================================");
		for(String res : date_list) {
			
			System.out.println(res);
		}

	}
}
