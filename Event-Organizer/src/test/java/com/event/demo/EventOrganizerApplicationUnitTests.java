package com.event.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.event.beans.Event;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventOrganizerApplicationUnitTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
		try {
			createTestData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createTestData() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.setId(1l);
		event.setTitle("Title1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		uri = "/event/add";
		event = new Event();
		event.setId(2l);
		event.setTitle("Title2");
		event.setDescription("Desc2");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		inputJson = super.mapToJson(event);
		mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		uri = "/event/add";
		event = new Event();
		event.setId(3l);
		event.setTitle("Title3");
		event.setDescription("Desc3");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		inputJson = super.mapToJson(event);
		mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
	}

	@Test
	public void getEventsList() throws Exception {
		String uri = "/events";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Event[] eventlist = super.mapFromJson(content, Event[].class);
		assertTrue(eventlist.length > 0);
	}
	
	@Test()
	public void createEvent() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.setId(4l);
		event.setTitle("Title4");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "Event added Successfully";
		assertEquals(content, response);
	}

	@Test
	public void updateEvent() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.setId(1l);
		event.setTitle("Title1");
		event.setDescription("Desc2");
		event.setStartDateTime("05/05/2019 00:00:00");
		event.setEndDateTime("07/07/2019 00:00:00");
		event.setCategory("BUSINESS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Event is updated successsfully");
	}

	@Test
	public void deleteEvent() throws Exception {
		String uri = "/event/delete/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Event is deleted successsfully");
	}
	
	@Test
	public void sortEvent() throws Exception {
		String uri = "/event/sort/description/desc";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Events are sorted successsfully");
	}
}
