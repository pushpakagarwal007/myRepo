package com.event.beans.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@SuppressWarnings({"unchecked","rawtypes"})
public class EventController<T> {

	@RequestMapping(method = RequestMethod.GET, value = "/events")
	@ResponseBody
	public ResponseEntity<T> getAllEvents() {
		if(CreateEvent.getInstance().getEventRecords() == null)
			return (ResponseEntity<T>) new ResponseEntity("{\"error\": \"List is Empty, No events Found\"}", HttpStatus.NOT_ACCEPTABLE);
		return (ResponseEntity<T>) new ResponseEntity(CreateEvent.getInstance().getEventRecords(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/event/add")
	@ResponseBody
	public ResponseEntity<T> registerEvent(@RequestBody Event event) {
		// We are setting the below value just to reply a message back to the caller
		String validationResponse = Validator.validateFields(event);
		if(!validationResponse.equals("SUCCESS"))
			return (ResponseEntity<T>) new ResponseEntity("{\"error\": \""+validationResponse+"\"}", HttpStatus.NOT_ACCEPTABLE);
			//return "{\"error\": \""+validationResponse+"\"}";
		CreateEvent.getInstance().add(event);	
		//return "Event added Successfully";
		return (ResponseEntity<T>) new ResponseEntity(event, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/event/update")
	@ResponseBody
	public ResponseEntity<T> updateEvent(@RequestBody Event event) { 
		String validationResponse = Validator.validateFields(event);
		if(!validationResponse.equals("SUCCESS"))
			return (ResponseEntity<T>) new ResponseEntity("{\"error\": \""+validationResponse+"\"}", HttpStatus.NOT_ACCEPTABLE);
	    CreateEvent.getInstance().updateEvent(event);
	    return (ResponseEntity<T>) new ResponseEntity(CreateEvent.getInstance().getEventRecords(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/event/delete/{regdId}")
	@ResponseBody
	public ResponseEntity<T> deleteEvent(@PathVariable("regdId") long regdId) {   
	    String Result = CreateEvent.getInstance().deleteEvent(regdId);
	    return Result.equals("SUCCESS") ? (ResponseEntity<T>) new ResponseEntity(CreateEvent.getInstance().getEventRecords(), HttpStatus.ACCEPTED) : (ResponseEntity<T>) new ResponseEntity("{\"error\": \"Record does not exits.\"}", HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/event/sort/{type}/{order}")
	@ResponseBody
	public ResponseEntity<T> sortEvent(@PathVariable("type") String type, @PathVariable("order") String order) {  
	    String response = CreateEvent.getInstance().sortEvents(type, order);
	    if(response == null)
	    	return (ResponseEntity<T>) new ResponseEntity("{\"error\": \"Unable to Sort the events as List is empty\"}", HttpStatus.NOT_ACCEPTABLE);
	    return (ResponseEntity<T>) new ResponseEntity(CreateEvent.getInstance().getEventRecords(), HttpStatus.ACCEPTED);
	}
}
