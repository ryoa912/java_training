/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock.components;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock {
	public static String getTime() {
		Date date = new Date();
		return date.toString().substring(11, 19);
	}
	public static String getTimeTalk() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("a hh時mm分");
        return sdf.format(cal.getTime());
	}
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("y/MM/dd");
        return sdf.format(cal.getTime());
	}
	public static String getDateTalk() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("y年MM月dd日");
        return sdf.format(cal.getTime());
	}
	public static boolean justMinuteTime() {
		Date date = new Date();
		String sec = date.toString().substring(17, 19);
		if (sec.compareTo("00") == 0) {
			return true;
		}
		return false;
	}
}
