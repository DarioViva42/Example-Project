package com.example.application.backend.service;

import com.example.application.model.AbstractPcPart;
import com.example.application.model.Memory;

import java.util.List;


public interface PartsSearchService {
	List<AbstractPcPart> search();
	List<Memory> onlyMemory();
}
