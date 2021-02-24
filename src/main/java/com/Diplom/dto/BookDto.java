package com.Diplom.dto;

import java.util.Map;

public class BookDto {
	private Integer id;
	private String topic;
	private String description;
	private String link;

	private Map<String, Object> attributes;

	public BookDto(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public BookDto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
