package com.example.application.webservice;

import com.example.application.backend.service.PartsSearchService;
import com.example.application.model.AbstractPcPart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PcPartsController {

	private final PartsSearchService service;

	PcPartsController (PartsSearchService service) {
		this.service = service;
	}

	@GetMapping("/parts")
	List<AbstractPcPart> all() {
		return service.search();
	}
}
