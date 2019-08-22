package com.event.demo;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.event.beans.Event;

@ContextConfiguration
public class EventOrgaizerApplicationFunctionalTest extends AbstractTest {
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test()
	public void Create_an_event_with_Title_value_is_Blank() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Title is Missing/blank or it exceeds the length of 50\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_Title_value_is_Missing() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Title is Missing/blank or it exceeds the length of 50\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_Title_Value_length_is_50() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennun");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"id\":"+id+",\"title\":\"ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennun\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"PERSONAL\"}";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Create_an_event_with_Title_Value_length_is_more_than_50() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennuncd");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Title is Missing/blank or it exceeds the length of 50\"}";
		assertEquals(content, response);
	}

	@Test()
	public void Create_an_event_with_Description_value_is_Blank() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title1");
		event.setDescription("");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Description is Missing/blank or it exceeds the length of 1000\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_Description_value_is_Missing() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Description is Missing/blank or it exceeds the length of 1000\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_Description_Value_length_is_1000() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title2");
		event.setDescription("ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncks");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"id\":"+id+",\"title\":\"title2\",\"description\":\"ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncks\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"PERSONAL\"}";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Create_an_event_with_Description_Value_length_is_more_than_1000() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksc");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Description is Missing/blank or it exceeds the length of 1000\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_StartDateTime_Value_is_Blank() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Start date Time is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_StartDateTime_Value_is_missing() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Start date Time is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_EndDateTime_Value_is_Blank() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event End date Time is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_EndDateTime_Value_is_missing() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event End date Time is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_Category_Value_is_Blank() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/01/2019 00:00:00");
		event.setCategory("");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Category is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_Category_Value_is_Missing() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/01/2019 00:00:00");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Category is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_Category_Value_is_other_than_PERSONAL_BUSINESS_OTHERS() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/01/2019 00:00:00");
		event.setCategory("LOGISTICS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"No other category is allowed other than PERSONAL/BUSINESS/OTHERS\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Create_an_event_with_Category_is_PERSONAL() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title5");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"id\":"+id+",\"title\":\"title5\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"PERSONAL\"}";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Create_an_event_with_Category_is_BUSINESS() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title5");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("BUSINESS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"id\":"+id+",\"title\":\"title5\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"BUSINESS\"}";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Create_an_event_with_Category_is_OTHERS() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title5");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"id\":"+id+",\"title\":\"title5\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"OTHERS\"}";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Create_an_event_with_ALL_fields_are_valid() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title5");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"id\":"+id+",\"title\":\"title5\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"OTHERS\"}";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test
	public void Delete_an_nonexisting_event() throws Exception {
		String uri = "/event/delete/100";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(403, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Record does not exits.\"}";
		assertEquals(content, response);
	}
	
	@Test
	public void Display_empty_list_of_events() throws Exception {
		String uri = "/events";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"List is Empty, No events Found\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_Title_value_is_Blank() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Title is Missing/blank or it exceeds the length of 50\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_Title_value_is_Missing() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Title is Missing/blank or it exceeds the length of 50\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_Title_Value_length_is_50() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title 1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/update";
		event = new Event();
		id = event.generateId();
		event.setTitle("ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennun");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "[{\"id\":"+id+",\"title\":\"ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennun\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"PERSONAL\"}]";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Update_an_event_with_Title_Value_length_is_more_than_50() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennuncj");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Title is Missing/blank or it exceeds the length of 50\"}";
		assertEquals(content, response);
	}

	@Test()
	public void Update_an_event_with_Description_value_is_Blank() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title1");
		event.setDescription("");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Description is Missing/blank or it exceeds the length of 1000\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_Description_value_is_Missing() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Description is Missing/blank or it exceeds the length of 1000\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_Description_Value_length_is_1000() throws Exception {
		
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title 1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/update";
		event = new Event();
		event.setId(id);
		event.setTitle("title2");
		event.setDescription("ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncks");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "[{\"id\":"+id+",\"title\":\"title2\",\"description\":\"ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncks\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"PERSONAL\"}]";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Update_an_event_with_Description_Value_length_is_more_than_1000() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("ifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksjdcnsjkdcnsjkdcnjksdncifgeibwiucnunwucnwunwuincuwenciwunwuiecnucnwennunejvnevcwecnwkcnwjkcnwjkcndjksncjksdnckjsdncjksdncjksdncjksdnckjsdncsjkdncksc");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Description is Missing/blank or it exceeds the length of 1000\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_StartDateTime_Value_is_Blank() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Start date Time is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_StartDateTime_Value_is_missing() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Start date Time is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_EndDateTime_Value_is_Blank() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event End date Time is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_EndDateTime_Value_is_missing() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event End date Time is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_Category_Value_is_Blank() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/01/2019 00:00:00");
		event.setCategory("");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Category is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_Category_Value_is_Missing() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/01/2019 00:00:00");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"Either Event Category is Missing or blank\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_Category_Value_is_other_than_PERSONAL_BUSINESS_OTHERS() throws Exception {
		String uri = "/event/update";
		Event event = new Event();
		event.generateId();
		event.setTitle("title5");
		event.setDescription("desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/01/2019 00:00:00");
		event.setCategory("LOGISTICS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "{\"error\": \"No other category is allowed other than PERSONAL/BUSINESS/OTHERS\"}";
		assertEquals(content, response);
	}
	
	@Test()
	public void Update_an_event_with_Category_is_PERSONAL() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title 1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("BUSINESS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/update";
		event = new Event();
		event.setId(id);
		event.setTitle("title5");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "[{\"id\":"+id+",\"title\":\"title5\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"PERSONAL\"}]";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Update_an_event_with_Category_is_BUSINESS() throws Exception {
		
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title 1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/update";
		event = new Event();
		event.setId(id);
		event.setTitle("title5");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("BUSINESS");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "[{\"id\":"+id+",\"title\":\"title5\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"BUSINESS\"}]";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Update_an_event_with_Category_is_OTHERS() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title 1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("BUSINESS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/update";
		event = new Event();
		event.setId(id);
		event.setTitle("title5");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "[{\"id\":"+id+",\"title\":\"title5\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"OTHERS\"}]";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test()
	public void Update_an_event_with_ALL_fields_are_valid() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title 1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("PERSONAL");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/update";
		event = new Event();
		event.setId(id);
		event.setTitle("title5");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		String content = mvcResult.getResponse().getContentAsString();
		String response = "[{\"id\":"+id+",\"title\":\"title5\",\"description\":\"Desc4\",\"startDateTime\":\"01/01/2019 00:00:00\",\"endDateTime\":\"02/02/2019 00:00:00\",\"category\":\"OTHERS\"}]";
		assertEquals(content, response);
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test
	public void sort_the_list_by_title() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title1");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id1 = event.generateId();
		event.setTitle("title2");
		event.setDescription("Desc4");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/sort/title/desc";
		mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id1;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test
	public void sort_the_list_by_description() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id1 = event.generateId();
		event.setTitle("title2");
		event.setDescription("Desc2");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/sort/description/desc";
		mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id1;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test
	public void sort_the_list_by_startDateTime() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id1 = event.generateId();
		event.setTitle("title2");
		event.setDescription("Desc2");
		event.setStartDateTime("02/02/2019 00:00:00");
		event.setEndDateTime("03/03/2019 00:00:00");
		event.setCategory("OTHERS");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/sort/startDateTime/desc";
		mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id1;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test
	public void sort_the_list_by_endDateTime() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("OTHERS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id1 = event.generateId();
		event.setTitle("title2");
		event.setDescription("Desc2");
		event.setStartDateTime("02/02/2019 00:00:00");
		event.setEndDateTime("03/03/2019 00:00:00");
		event.setCategory("OTHERS");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/sort/endDateTime/desc";
		mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id1;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test
	public void sort_the_list_by_category() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("BUSINESS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id1 = event.generateId();
		event.setTitle("title2");
		event.setDescription("Desc2");
		event.setStartDateTime("02/02/2019 00:00:00");
		event.setEndDateTime("03/03/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/sort/category/desc";
		mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id1;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test
	public void delete_an_event_when_two_events_exists_in_the_list() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("BUSINESS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id1 = event.generateId();
		event.setTitle("title2");
		event.setDescription("Desc2");
		event.setStartDateTime("02/02/2019 00:00:00");
		event.setEndDateTime("03/03/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id1;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test
	public void delete_an_event_when_three_events_exists_in_the_list() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("BUSINESS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id1 = event.generateId();
		event.setTitle("title2");
		event.setDescription("Desc2");
		event.setStartDateTime("02/02/2019 00:00:00");
		event.setEndDateTime("03/03/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id2 = event.generateId();
		event.setTitle("title3");
		event.setDescription("Desc3");
		event.setStartDateTime("02/02/2019 00:00:00");
		event.setEndDateTime("03/03/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id1;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id2;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
	@Test
	public void delete_an_event_when_four_events_exists_in_the_list() throws Exception {
		String uri = "/event/add";
		Event event = new Event();
		Long id = event.generateId();
		event.setTitle("title1");
		event.setDescription("Desc1");
		event.setStartDateTime("01/01/2019 00:00:00");
		event.setEndDateTime("02/02/2019 00:00:00");
		event.setCategory("BUSINESS");
		String inputJson = super.mapToJson(event);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id1 = event.generateId();
		event.setTitle("title2");
		event.setDescription("Desc2");
		event.setStartDateTime("02/02/2019 00:00:00");
		event.setEndDateTime("03/03/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id2 = event.generateId();
		event.setTitle("title3");
		event.setDescription("Desc3");
		event.setStartDateTime("02/02/2019 00:00:00");
		event.setEndDateTime("03/03/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		event = new Event();
		Long id3 = event.generateId();
		event.setTitle("title4");
		event.setDescription("Desc4");
		event.setStartDateTime("02/02/2019 00:00:00");
		event.setEndDateTime("03/03/2019 00:00:00");
		event.setCategory("PERSONAL");
		inputJson = super.mapToJson(event);
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/event/delete/"+id;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id1;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id2;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		
		uri = "/event/delete/"+id3;
		mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
	
}
