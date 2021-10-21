package com.example.application.ui.views.partsFactory.card;

import com.example.application.model.AbstractPcPart;
import com.vaadin.flow.data.renderer.TemplateRenderer;

public class GraphicsCardCard extends AbstractPcPartCard {

	AbstractPcPart pcPart;

	public GraphicsCardCard(AbstractPcPart pcPart) {
		this.pcPart = pcPart;
	}

	public static GraphicsCardCard create(AbstractPcPart pcPart) {
		return new GraphicsCardCard(pcPart);
	}

	public static TemplateRenderer<AbstractPcPart> getTemplate() {
		return TemplateRenderer.of(
				"<graphics-card-card"
						+ " part-card='[[item.partCard]]'>"
						+ "</graphics-card-card>"
		);
	}
}
