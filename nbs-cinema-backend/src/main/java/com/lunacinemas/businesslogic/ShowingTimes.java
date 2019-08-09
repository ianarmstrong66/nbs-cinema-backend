package com.lunacinemas.businesslogic;

import java.util.ArrayList;
import java.util.List;

public class ShowingTimes {

	public List<String> getTimes(){ 
	
	List<String> times = new ArrayList<String>();
	times.add("12:00"); 
	times.add("14:00");
	times.add("16:00");
	times.add("18:00");
	times.add("20:00");

	return times;
	};
}