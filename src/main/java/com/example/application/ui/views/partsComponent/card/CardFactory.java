package com.example.application.ui.views.partsComponent.card;

import com.example.application.model.AbstractPcPart;
import com.example.application.model.GraphicsCard;
import com.example.application.model.Memory;
import com.vaadin.flow.data.renderer.TemplateRenderer;

public class CardFactory {
	public static AbstractPcPartCard create(AbstractPcPart pcPart) {
		if (pcPart.getClass().equals(GraphicsCard.class)) {
			return new GraphicsCardCard((GraphicsCard) pcPart);
		} else if (pcPart.getClass().equals(Memory.class)) {
			return new MemoryCard((Memory) pcPart);
		} else {
			// different PC parts
			return null;
		}
	}
}
