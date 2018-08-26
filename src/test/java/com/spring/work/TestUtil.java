package com.spring.work;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Test;

import com.spring.util.UtilDate;

public class TestUtil {

	@Test
	public void testRecurrDateCalc() throws Exception {
		
		String today;
		String recurCount;
		ArrayList<String> expectReturn = new ArrayList<String>();
		
		today = "2018-08-26";
		recurCount = "3";
		expectReturn.add("2018-08-26");
		expectReturn.add("2018-09-02");
		expectReturn.add("2018-09-09");
		expectReturn.add("2018-09-16");
		
		assertEquals(4, UtilDate.RecurrDateCalc(today, recurCount).size());
		
		for(int i=0; i<expectReturn.size(); i++){
			assertEquals(expectReturn.get(i), UtilDate.RecurrDateCalc(today, recurCount).get(i));
		}
		
	}
	
	

}
