/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch24.ex03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	public static void printStyles(String dateStr) throws ParseException {
		Locale japan = new Locale("ja", "JP");
		Date date = DateFormat.getDateInstance(DateFormat.SHORT, japan).parse(dateStr);
		System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(date));
		System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(date));
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(date));
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL).format(date));
	}

	public static void main(String[] args) throws ParseException {
		printStyles("2017/05/23");
	}
}
