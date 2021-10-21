package com.example.application.ui.components;

import com.example.application.model.AbstractPcPart;
import com.example.application.model.GraphicsCard;
import com.example.application.model.Memory;
import com.example.application.ui.views.partsDomIf.card.CardFactory;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;

import java.util.Objects;

@JsModule("./src/views/parts/card/graphics-card-card.js")
@JsModule("./src/views/parts/card/memory-card.js")
public class PcPartsDomIfGrid extends Grid<AbstractPcPart> {
	private static final long serialVersionUID = 7474489703766322949L;

	public PcPartsDomIfGrid() {
		super();

		init();
	}

	private void init() {
		setSelectionMode(SelectionMode.NONE);

		addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);

		initColumn();
	}

	private boolean isMemory(AbstractPcPart pcPart) {
		return pcPart.getClass().equals(Memory.class);
	}

	private boolean isGraphicsCard(AbstractPcPart pcPart) {
		return pcPart.getClass().equals(GraphicsCard.class);
	}

	private void initColumn() {
		addColumn(Objects.requireNonNull(CardFactory.getTemplate())
				.withProperty("partCard", CardFactory::create)
				.withProperty("isMemory", this::isMemory)
				.withProperty("isGraphicsCard", this::isGraphicsCard));
	}
}
