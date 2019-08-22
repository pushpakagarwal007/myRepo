package com.event.utility;

import com.event.beans.Event;

public class Validator {
	
	public static String validateFields(Event event) {
		
		if(event.getId() == null)
			return "Event Id cannot be null";
		
		if(event.getTitle() == null || event.getTitle() == "" || event.getTitle().length() > 50 || event.getTitle().length() == 0)
			return "Either Event Title is Missing/blank or it exceeds the length of 50";
		
		if(event.getDescription() == null || event.getDescription() == "" || event.getDescription().length() > 1000)
			return "Either Event Description is Missing/blank or it exceeds the length of 1000";
		
		if(event.getStartDateTime() == null || event.getStartDateTime() == "")
			return "Either Event Start date Time is Missing or blank";
		
		if(event.getEndDateTime() == null || event.getEndDateTime() == "")
			return "Either Event End date Time is Missing or blank";
		if(event.getCategory() == null || event.getCategory() == "")
			return "Either Event Category is Missing or blank";
		else if(event.getCategory().equals("PERSONAL") || event.getCategory().equals("BUSINESS") || event.getCategory().equals("OTHERS"))
			return "SUCCESS";
		else
			return "No other category is allowed other than PERSONAL/BUSINESS/OTHERS";
		
	}

}
