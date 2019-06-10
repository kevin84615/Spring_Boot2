package com.todo.springboot;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Get {
	public static String time() {
 	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 	String time = sdf.format(timestamp);
 	return time;
	}
}
