package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EntriesResponse {
	@JsonProperty("API")
	private String title;
	@JsonProperty("Description")
	private String Description;
	@JsonProperty("Category")
	private String Category;
}
