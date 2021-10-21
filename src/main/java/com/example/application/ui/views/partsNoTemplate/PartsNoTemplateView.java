package com.example.application.ui.views.partsNoTemplate;

import com.example.application.app.HasLogger;
import com.example.application.model.AbstractPcPart;
import com.example.application.ui.components.PcPartsDomIfGrid;
import com.example.application.ui.components.PcPartsNoTemplateGrid;
import com.example.application.ui.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Tag("parts-view")
@JsModule("./src/views/parts/parts-view.js")
@PageTitle("no Template – simple ValueProvider")
@Route(value = "no-template", layout = MainLayout.class)
public class PartsNoTemplateView extends PolymerTemplate<PartsNoTemplateView.Model> implements HasLogger {

    private final PartsNoTemplatePresenter presenter;

    @Id
    private PcPartsNoTemplateGrid partsGrid;

    @Autowired
    public PartsNoTemplateView(PartsNoTemplatePresenter presenter) {

        this.presenter = presenter;

        presenter.init(this);
    }

    void updateList(List<AbstractPcPart> results) {
        partsGrid.setItems(results);
    };

    public interface Model extends TemplateModel {

    }
}
