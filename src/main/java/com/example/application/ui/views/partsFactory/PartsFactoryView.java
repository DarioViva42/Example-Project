package com.example.application.ui.views.partsFactory;

import com.example.application.app.HasLogger;
import com.example.application.model.AbstractPcPart;
import com.example.application.ui.components.PcPartsFactoryGrid;
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
@PageTitle("Factory multiple TemplateRenderers")
@Route(value = "factory", layout = MainLayout.class)
public class PartsFactoryView extends PolymerTemplate<PartsFactoryView.Model> implements HasLogger {

    private final PartsFactoryPresenter presenter;

    @Id
    private PcPartsFactoryGrid partsGrid;

    @Autowired
    public PartsFactoryView(PartsFactoryPresenter presenter) {

        this.presenter = presenter;

        presenter.init(this);
    }

    void updateList(List<AbstractPcPart> results) {
        partsGrid.setItems(results);
    };

    public interface Model extends TemplateModel {

    }
}
