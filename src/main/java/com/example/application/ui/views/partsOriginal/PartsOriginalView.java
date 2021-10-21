package com.example.application.ui.views.partsOriginal;

import com.example.application.app.HasLogger;
import com.example.application.model.AbstractPcPart;
import com.example.application.model.Memory;
import com.example.application.ui.components.PcPartsOriginalGrid;
import com.example.application.ui.views.MainLayout;
import com.example.application.ui.views.partsOriginal.card.MemoryCard;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Tag("parts-view")
@JsModule("./src/views/parts/parts-view.js")
@PageTitle("Original using TemplateRenderer")
@Route(value = "original", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class PartsOriginalView extends PolymerTemplate<PartsOriginalView.Model> implements HasLogger {

    private final PartsOriginalPresenter presenter;

    @Id
    private PcPartsOriginalGrid partsGrid;

    @Autowired
    public PartsOriginalView(PartsOriginalPresenter presenter) {

        this.presenter = presenter;

        presenter.init(this);
    }

    void updateList(List<Memory> results) {
        partsGrid.setItems(results);
    };

    public interface Model extends TemplateModel {

    }
}
