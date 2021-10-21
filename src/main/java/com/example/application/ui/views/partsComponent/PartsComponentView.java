package com.example.application.ui.views.partsComponent;

import com.example.application.app.HasLogger;
import com.example.application.model.AbstractPcPart;
import com.example.application.ui.components.PcPartsComponentGrid;
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
@PageTitle("ComponentRenderer (the Renderer used in Vaadins Example)")
@Route(value = "component", layout = MainLayout.class)
public class PartsComponentView extends PolymerTemplate<PartsComponentView.Model> implements HasLogger {

    private final PartsComponentPresenter presenter;

    @Id
    private PcPartsComponentGrid partsGrid;

    @Autowired
    public PartsComponentView(PartsComponentPresenter presenter) {

        this.presenter = presenter;

        presenter.init(this);
    }

    void updateList(List<AbstractPcPart> results) {
        partsGrid.setItems(results);
    };

    public interface Model extends TemplateModel {

    }
}
