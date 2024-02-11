package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.dto.ApiResponse;
import com.example.entity.Entries;
import com.example.service.EntryService;

@RestController
public class EntryController {

	private final EntryService entryService;

	@Autowired
	public EntryController(EntryService entryService) {
		this.entryService = entryService;
	}

	/**
	 * fetchAllProducts : Method is used to fetch all the Entries which matches the
	 * category value.
	 * 
	 * @param category
	 * @return ResponseEntity<List<Entries>>
	 */
	@GetMapping("/entries")
	public ResponseEntity<?> fetchAllProducts(@RequestParam String category) {
		ApiResponse fetchEntriesFromApI = entryService.fetchEntriesFromApI(category);
		return new ResponseEntity<>(fetchEntriesFromApI, HttpStatus.OK);
	}

	/**
	 * Method is used to take Entries and save in the database
	 * 
	 * @param entries
	 * @return ResponseEntity<Entries>
	 */
	@PostMapping("/entries")
	public ResponseEntity<?> saveEntry(@RequestBody Entries entries) {
		entryService.saveEntries(entries);
		return new ResponseEntity<>("Product Saved Successfully.", HttpStatus.CREATED);
	}

}
