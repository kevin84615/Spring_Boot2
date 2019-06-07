package com.todo.springboot;

import java.util.ArrayList;
import java.util.Calendar;

public class DateConvert {
	public static ArrayList<String> Date(Iterable<TodoData> list,ArrayList<String> Convert_Date) {
		for(TodoData s : list){

			String upload_date = s.getUploadDate();
			upload_date = upload_date.replaceFirst("(?i)(-)", "年");
			upload_date = upload_date.replaceFirst("(?i)(-)", "月");
			upload_date = upload_date.replaceFirst("(?i)( )", "日");
			upload_date = upload_date.substring(0, 16);

			int YEAR = Integer.parseInt(upload_date.substring(0, 4));
			int MONTH = Integer.parseInt(upload_date.substring(5, 7));
			int DATE = Integer.parseInt(upload_date.substring(8, 10));
			MONTH = MONTH - 1;
			DATE = DATE - 1;

			String[] week = new String[7];
			week[0] = "日";
			week[1] = "月";
			week[2] = "火";
			week[3] = "水";
			week[4] = "木";
			week[5] = "金";
			week[6] = "土";

			Calendar YEAR_MONTH_DATE = Calendar.getInstance();
			YEAR_MONTH_DATE.set(Calendar.YEAR, YEAR);
			YEAR_MONTH_DATE.set(Calendar.MONTH, MONTH);
			YEAR_MONTH_DATE.set(Calendar.DAY_OF_MONTH, DATE);
			int DAY_OF_WEEK = YEAR_MONTH_DATE.get(Calendar.DAY_OF_WEEK);

			upload_date = upload_date.substring(5, 11) + "(" + week[DAY_OF_WEEK] + ")" + upload_date.substring(11, 16);

			Convert_Date.add(upload_date);
		}
		return Convert_Date;
	}
}
