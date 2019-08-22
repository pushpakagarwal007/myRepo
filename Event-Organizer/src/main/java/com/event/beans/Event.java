package com.event.beans;

import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class Event {
	
	public enum Category
	{
		PERSONAL,
		BUSINESS, 
		OTHERS
	}

	private Long id = 1l;
	private String title;
	private String description;
	private String startDateTime;
	private String endDateTime;
	private String category;
	
	public Long generateId() {
		return ++id;
	}
	
	public void setId(Long _id) {
		id = _id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public String getCategory() {
		return category;
	}

	public Event() {
	}

	public Event(String title, String description, String startDateTime, String endDateTime, String category) {
		this.title = title;
		this.description = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.category = category;
	}
}
