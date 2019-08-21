package com.event.utility;

import com.event.beans.Event;

public class Validator {
	
	public static String validateFields(Event event) {
		
		if(event.getId() == null)
			return "Event Id cannot be null";
		
		if(event.getTitle() == null || event.getTitle().length() > 50)
			return "Either Event Title is null or it exceeds the length of 50";
		
		if(event.getDescription() == null || event.getDescription().length() > 1000)
			return "Either Event Description is null or it exceeds the length of 1000";
		
		if(event.getStartDateTime() == null)
			return "Start date Time cannot be null";
		
		if(event.getEndDateTime() == null)
			return "End date Time cannot be null";
		
		if(event.getCategory().equals("PERSONAL") || event.getCategory().equals("BUSINESS") || event.getCategory().equals("OTHERS"))
			return "Success";
		else
			return "No other category is allowed other than PERSONAL/BUSINESS/OTHERS";
		
	}

}
