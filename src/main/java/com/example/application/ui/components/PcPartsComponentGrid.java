package com.example.application.ui.components;

import com.example.application.model.AbstractPcPart;
import com.example.application.ui.views.partsComponent.card.CardFactory;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;

import java.util.Objects;

@JsModule("./src/views/parts/card/graphics-card-card.js")
@JsModule("./src/views/parts/card/memory-card.js")
public class PcPartsComponentGrid extends Grid<AbstractPcPart> {
	private static final long serialVersionUID = 6260035309337465994L;

	public PcPartsComponentGrid() {
		super();

		init();
	}

	private void init() {
		setSelectionMode(SelectionMode.NONE);

		addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);

		initColumn();
	}

	private void initColumn() {
		addComponentColumn(pcPart -> Objects.requireNonNull(CardFactory.create(pcPart)));
	}
}
