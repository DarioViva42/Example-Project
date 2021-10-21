package com.example.application.ui.views.partsDomIf.card;

import com.example.application.model.AbstractPcPart;
import com.example.application.model.GraphicsCard;
import com.example.application.model.Memory;
import com.vaadin.flow.data.renderer.TemplateRenderer;

public class CardFactory {
	public static AbstractPcPartCard create(AbstractPcPart pcPart) {
		if (pcPart.getClass().equals(GraphicsCard.class)) {
			return GraphicsCardCard.create((GraphicsCard) pcPart);
		} else if (pcPart.getClass().equals(Memory.class)) {
			return MemoryCard.create((Memory) pcPart);
		} else {
			// different PC parts
			return null;
		}
	}

	public static TemplateRenderer<AbstractPcPart> getTemplate() {
		String memoryTemplate = MemoryCard.getTemplateString();
		String graphicsCardTemplate = GraphicsCardCard.getTemplateString();

		String combinedTemplate = memoryTemplate + graphicsCardTemplate;
		return TemplateRenderer.of(combinedTemplate);
	}
}
