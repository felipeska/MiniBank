package com.felipeska.banking.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateUtils {

	private DateUtils() {
	}

	public static String getDateTimeReadable(long mills) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date(mills);
		return dateFormat.format(date);
	}
}
