package com.spring.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class UtilDate {

	public static List<String> RecurrDateCalc(String date, String cnt) throws ParseException{
		List<String> reserveDateList = new ArrayList<String>();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = new GregorianCalendar(Locale.KOREA);
		
		reserveDateList.add(date);

		if(!"".equals(cnt)){
			int recurrCnt = Integer.parseInt(cnt);
			Date tmpDate = fmt.parse(date);
			cal.setTime(tmpDate);
			
			for(int i=1; i<=recurrCnt; i++){
				cal.add(Calendar.DAY_OF_YEAR, 7);
				
				String rtnDate = fmt.format(cal.getTime());
				reserveDateList.add(rtnDate);
			}
			
		}
		
		return reserveDateList;
	}
	
	
	
}
