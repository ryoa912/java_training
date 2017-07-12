/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch24.ex03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class DateUtilsTest {
	@Test
	public void testPrintStyles_now() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("y/M/d");
        try {
			DateUtils.printStyles(sdf.format(cal.getTime()));
		} catch (ParseException e) {

		}
	}
	@Test
	public void testPrintStyles_e1() throws ParseException {
        DateUtils.printStyles("2017/1/0");
	}
	@Test
	public void testPrintStyles_e2() throws ParseException {
        DateUtils.printStyles("2017/0/0");
	}
	@Test
	public void testPrintStyles_e3() throws ParseException {
        DateUtils.printStyles("0/0/0");
	}
	@Test
	public void testPrintStyles_e4() throws ParseException {
        DateUtils.printStyles("2017/8/32");
	}
}
