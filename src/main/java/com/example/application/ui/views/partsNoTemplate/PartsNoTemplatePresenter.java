package com.example.application.ui.views.partsNoTemplate;

import com.example.application.app.HasLogger;
import com.example.application.backend.service.PartsSearchService;
import com.example.application.model.AbstractPcPart;
import com.example.application.ui.views.AbstractPresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.List;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PartsNoTemplatePresenter extends AbstractPresenter implements Serializable, HasLogger {
	private static final long serialVersionUID = -4584424067040090442L;

	private PartsNoTemplateView view;

	private final transient PartsSearchService searchService;

	@Autowired
	PartsNoTemplatePresenter(PartsSearchService searchService) {
		this.searchService = searchService;
	}

	void init(PartsNoTemplateView view) {
		this.view = view;

		List<AbstractPcPart> results = search();
		view.updateList(results);
	}

	private List<AbstractPcPart> search() {
		List<AbstractPcPart> results = searchService.search();
		return results;
	}
}
