package com.banking.spring.web.utils;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class DateTime {

	/*
	 * // create a java calendar instance Calendar calendar =
	 * Calendar.getInstance();
	 * 
	 * // get a java date (java.util.Date) from the Calendar instance. // this
	 * java date will represent the current date, or "now". java.util.Date
	 * currentDate = calendar.getTime();
	 * 
	 * // now, create a java.sql.Date from the java.util.Date java.sql.Date date
	 * = new java.sql.Date(currentDate.getTime());
	 */
	public Date getCurrentDate() {
		return new java.sql.Date(Calendar.getInstance().getTime().getTime());
	}

	public Time getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		java.sql.Time now = java.sql.Time.valueOf(cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE) + ":"
				+ cal.get(Calendar.SECOND));

		return now;
	}

	public Date getDateAfter(int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, months);

		return new java.sql.Date(calendar.getTime().getTime());
	}
}
