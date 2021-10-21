package com.example.application.ui.views.partsOriginal;

import com.example.application.app.HasLogger;
import com.example.application.backend.service.PartsSearchService;
import com.example.application.model.AbstractPcPart;
import com.example.application.model.Memory;
import com.example.application.ui.views.AbstractPresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.List;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PartsOriginalPresenter extends AbstractPresenter implements Serializable, HasLogger {
	private static final long serialVersionUID = -4584424067040090442L;

	private PartsOriginalView view;

	private final transient PartsSearchService searchService;

	@Autowired
	PartsOriginalPresenter(PartsSearchService searchService) {
		this.searchService = searchService;
	}

	void init(PartsOriginalView view) {
		this.view = view;

		List<Memory> results = search();
		view.updateList(results);
	}

	private List<Memory> search() {
		List<Memory> results = searchService.onlyMemory();
		return results;
	}
}
