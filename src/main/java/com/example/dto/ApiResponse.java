package com.example.dto;

import java.util.List;
import lombok.Data;

@Data
public class ApiResponse {
	private int count;
	private List<EntriesResponse> entries;
}
