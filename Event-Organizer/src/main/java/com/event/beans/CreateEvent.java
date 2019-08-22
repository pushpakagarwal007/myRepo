package com.event.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CreateEvent {

	private List<Event> eventRecords;
	private static CreateEvent eventregd = null;

	private CreateEvent(){
		eventRecords = new ArrayList<Event>();
    }

	public static CreateEvent getInstance() {
		if (eventregd == null) {
			eventregd = new CreateEvent();
			return eventregd;
		} else {
			return eventregd;
		}
	}

	public void add(Event std) {
		eventRecords.add(std);
	}

	public String updateEvent(Event event) {
		for (int i = 0; i < eventRecords.size(); i++) {
			Event stdn = eventRecords.get(i);
			if (stdn.getId().equals(event.getId())) {
				eventRecords.set(i, event);// update the new record
				return "SUCCESS";
			}
		}
		return "ERROR";
	}

	public String deleteEvent(long eventId) {
		for (int i = 0; i < eventRecords.size(); i++) {
			Event event = eventRecords.get(i);
			if (event.getId().equals(eventId)) {
				eventRecords.remove(i);// delete the new record
				return "SUCCESS";
			}
		}
		return "ERROR";
	}
	
	public String sortEvents(String type, String order) {
		Collections.sort(eventRecords, new Comparator<Event>() {
			@Override
			public int compare(Event arg0, Event arg1) {
				switch(type.toLowerCase())
				{
				case "title":
					return arg0.getTitle().compareTo(arg1.getTitle());
				case "description":
					return arg0.getDescription().compareTo(arg1.getDescription());
				case "startDateTime":
					try {
						return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").parse(arg0.getStartDateTime()).compareTo(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").parse(arg1.getStartDateTime()));
					} catch (ParseException e) {
					}
				case "endDateTime":
					try {
						return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").parse(arg0.getEndDateTime()).compareTo(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").parse(arg1.getEndDateTime()));
					} catch (ParseException e) {
					}
				case "category":
					return arg0.getCategory().compareTo(arg1.getCategory());
				}
				return 0;
			}
			
		});
		if (order.equalsIgnoreCase("desc"))
			Collections.reverse(eventRecords);
		return "SUCCESS";
	}

	public List<Event> getEventRecords() {
		if(eventRecords.size() == 0)
			return null;
		return eventRecords;
	}

}
