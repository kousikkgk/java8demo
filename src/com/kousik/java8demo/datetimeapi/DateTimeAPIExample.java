package com.kousik.java8demo.datetimeapi;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class DateTimeAPIExample {

	public static void main(String[] args) {
		// Date problem upto 1.7
		//1. Date format is for Java and Databases
		//eg:java.util and java.sql packages
		//same class in two packages
		
		//2.Formatting issue import java.text;
		
		//3.Not thread Safe
		
		//java.time package
		LocalDate date=LocalDate.now();//currentdate shows only date not a time
		LocalDate date1=LocalDate.of(1992, 05, 23);
		LocalDate date2=LocalDate.of(1992,Month.MAY,23);
		//LocalDate date3=LocalDate.of(1993, Month.FEBRUARY, 29);// Invalid date 'February 29' as '1993' is not a leap year
		//System.out.println(date3);
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date);
		
		//System Timing------Human Readable
		LocalTime time1=LocalTime.now();//Current time
		System.out.println(time1);
		
		LocalTime time2=LocalTime.of(2, 30);//We will mention time
		System.out.println(time2);
		
		LocalTime time3=LocalTime.now(ZoneId.of("Asia/Singapore"));//Mention the Zone ids
		System.out.println(time3);
		
		//Available Zone Ids
		for(String i:ZoneId.getAvailableZoneIds()) {
			System.out.println(i);
		}
		
		//GMT Timing------Machine readable or machine timing
		Instant i =Instant.now();
		System.out.println(i);
	}

}
