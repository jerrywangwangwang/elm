package com.neuedu.elm_servlet.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
	
	public static String getCurrentDate() {
		Calendar c = Calendar.getInstance();
		return sdf.format(c.getTime());
	}
}
