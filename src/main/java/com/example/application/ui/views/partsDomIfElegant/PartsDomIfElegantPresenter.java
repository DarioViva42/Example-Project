package com.example.application.ui.views.partsDomIfElegant;

import com.example.application.backend.service.PartsSearchService;
import com.example.application.model.AbstractPcPart;
import com.example.application.ui.views.partsDomIf.PartsDomIfView;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.util.List;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PartsDomIfElegantPresenter {
    private static final long serialVersionUID = -4584424067040090442L;

    private PartsDomIfElegantView view;

    private final transient PartsSearchService searchService;

    @Autowired
    PartsDomIfElegantPresenter(PartsSearchService searchService) {
        this.searchService = searchService;
    }

    void init(PartsDomIfElegantView view) {
        this.view = view;

        List<AbstractPcPart> results = search();
        view.updateList(results);
    }

    private List<AbstractPcPart> search() {
        List<AbstractPcPart> results = searchService.search();
        return results;
    }
}
