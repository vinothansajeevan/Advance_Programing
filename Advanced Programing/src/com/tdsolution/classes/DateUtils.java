package com.tdsolution.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static String formatDate(Date date) {
		return formatDate(date, DEFAULT_DATE_FORMAT);
	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static Date parseDate(String dateString) throws ParseException {
		return parseDate(dateString, DEFAULT_DATE_FORMAT);
	}

	public static Date parseDate(String dateString, String format) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(dateString);
	}

	public static Date addDaysToDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public static Date subtractDaysFromDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -days);
		return calendar.getTime();
	}

	public static boolean isDateBefore(Date date1, Date date2) {
		return date1.before(date2);
	}

	public static boolean isDateAfter(Date date1, Date date2) {
		return date1.after(date2);
	}

	public static boolean areDatesEqual(Date date1, Date date2) {
		return date1.equals(date2);
	}

	public static void main(String[] args) {
		// Example usage
		Date currentDate = new Date();
		System.out.println("Current Date: " + formatDate(currentDate));

		try {
			String dateString = "2023-09-01";
			Date parsedDate = parseDate(dateString);
			System.out.println("Parsed Date: " + formatDate(parsedDate));

			Date futureDate = addDaysToDate(currentDate, 7);
			System.out.println("Future Date: " + formatDate(futureDate));

			boolean isBefore = isDateBefore(currentDate, futureDate);
			System.out.println("Is Current Date before Future Date: " + isBefore);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

