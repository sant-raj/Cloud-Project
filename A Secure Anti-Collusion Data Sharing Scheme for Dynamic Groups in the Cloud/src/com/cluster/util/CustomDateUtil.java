package com.cluster.util;

/**
 * @ Cluster Info Solution Solution, Author (SHARANABAU)
 */
import java.util.Date;
import java.text.SimpleDateFormat;

public class CustomDateUtil {

	public static String customDate() {

		SimpleDateFormat sdfDate = new SimpleDateFormat("yy/MM/dd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String strTime = sdfTime.format(now);
		String dt = strDate + " " + strTime;
		return dt;

	}

}