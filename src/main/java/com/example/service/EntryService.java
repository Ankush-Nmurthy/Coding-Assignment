package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.dto.ApiResponse;
import com.example.entity.Entries;
import com.example.repository.EntriesRepository;
import lombok.Data;

@Service
@Data
public class EntryService {

	private final EntriesRepository repository;

	private RestTemplate restTemplate;

	@Value("${base.url}")
	private String BaseUrl;

	@Autowired
	public EntryService(EntriesRepository repository, RestTemplate restTemplate) {
		this.repository = repository;
		this.restTemplate = restTemplate;
	}

	/**
	 * Method created for fetching the data from url;
	 * 
	 * @param category
	 * @return ApiResponse
	 */
	public ApiResponse fetchEntriesFromApI(String category) {
		ApiResponse forObject = restTemplate.getForObject(BaseUrl + "/entries?category=" + category, ApiResponse.class);
		return forObject;
	}

	/**
	 * Method saves the Entry into database.
	 * @param entries
	 * @return Entries
	 */
	public Entries saveEntries(Entries entries) {
		return repository.save(entries);
	}
}
