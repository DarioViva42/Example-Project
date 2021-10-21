package com.example.application.ui.components;

import com.example.application.model.AbstractPcPart;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;

@JsModule("./src/views/parts/card/memory-card.js")
public class PcPartsNoTemplateGrid extends Grid<AbstractPcPart> {
	private static final long serialVersionUID = 8168268293248356954L;

	public PcPartsNoTemplateGrid() {
		super();

		init();
	}

	private void init() {
		setSelectionMode(SelectionMode.NONE);

		addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);

		initColumn();
	}

	private void initColumn() {
		addColumn(part -> part.getClass().getName())
				.setKey("type")
				.setFlexGrow(13);
		addColumn(AbstractPcPart::getName)
				.setKey("name")
				.setFlexGrow(5);
		addColumn(part -> part.getPrice().getPrice())
				.setKey("price")
				.setTextAlign(ColumnTextAlign.END);
		addColumn(part -> part.getPrice().getCurrency())
				.setKey("currency");
		addColumn(part -> part.getStockQuantity() + " Pieces")
				.setKey("stock")
				.setFlexGrow(3);
	}
}
