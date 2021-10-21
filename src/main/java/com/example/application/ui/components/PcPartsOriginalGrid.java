package com.example.application.ui.components;

import com.example.application.model.Memory;
import com.example.application.ui.views.partsOriginal.card.MemoryCard;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.data.renderer.TemplateRenderer;

@JsModule("./src/views/parts/card/memory-card.js")
public class PcPartsOriginalGrid extends Grid<Memory> {
	private static final long serialVersionUID = 8168268293248356954L;

	public PcPartsOriginalGrid() {
		super();

		init();
	}

	private void init() {
		setSelectionMode(SelectionMode.NONE);

		addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);

		initColumn();
	}

	private void initColumn() {
		addColumn(MemoryCard.getTemplate()
				.withProperty("partCard", MemoryCard::create));
	}
}
