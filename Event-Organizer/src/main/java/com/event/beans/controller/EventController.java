package com.event.beans.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.event.beans.CreateEvent;
import com.event.beans.Event;
import com.event.utility.Validator;

@RestController
public class EventController {

	@RequestMapping(method = RequestMethod.GET, value = "/events")
	@ResponseBody
	public List<Event> getAllEvents() {
		return CreateEvent.getInstance().getEventRecords();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/event/add")
	@ResponseBody
	public String registerEvent(@RequestBody Event event) {
		// We are setting the below value just to reply a message back to the caller
		String validationResponse = Validator.validateFields(event);
		if(!validationResponse.equals("Success"))
			return "{\"error\": \""+validationResponse+"\"}";
		CreateEvent.getInstance().add(event);	
		return "Event added Successfully";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/event/update")
	@ResponseBody
	public String updateEvent(@RequestBody Event event) { 
		String validationResponse = Validator.validateFields(event);
		if(!validationResponse.equals("Success"))
			System.out.println("{\"error\": "+validationResponse+"}");
	    return CreateEvent.getInstance().updateEvent(event);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/event/delete/{regdId}")
	@ResponseBody
	public String deleteEvent(@PathVariable("regdId") long regdId) {   
	    return CreateEvent.getInstance().deleteEvent(regdId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/event/sort/{type}/{order}")
	@ResponseBody
	public String sortEvent(@PathVariable("type") String type, @PathVariable("order") String order) {  
	    return CreateEvent.getInstance().sortEvents(type, order);
	}
}
