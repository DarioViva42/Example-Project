package com.example.application.ui.views.partsOriginal.card;

import com.example.application.model.Memory;
import com.vaadin.flow.data.renderer.TemplateRenderer;

public class MemoryCard extends AbstractPcPartCard {
	Memory pcPart;

	public MemoryCard(Memory pcPart) {
		this.pcPart = pcPart;
	}

	public static MemoryCard create(Memory pcPart) {
		return new MemoryCard(pcPart);
	}

	public String getName() {
		return pcPart.getName();
	}

	public String getPrice() {
		int price = pcPart.getPrice().getPrice();
		String currency = pcPart.getPrice().getCurrency();

		return price + " " + currency;
	}

	public String getStock() {
		return pcPart.getStockQuantity() + " Pieces";
	}

	public String getConfiguration() {
		return pcPart.getConfiguration().map(memoryConfiguration -> {
			int mpm = memoryConfiguration.getMemoryPerModule();
			int nom = memoryConfiguration.getNumberOfModules();

			return nom + " × " + mpm + " GB";
		}).orElse("no Configuration");
	}

	public String getFrequency() {
		return pcPart.getFrequency().map(String::valueOf).orElse("no Frequency");
	}

	public String getFormFactor() {
		return pcPart.getFormFactor().orElse("no Form Factor");
	}

	public static TemplateRenderer<Memory> getTemplate() {
		return TemplateRenderer.<Memory>of(
				"<memory-card"
						+ " part-card='[[item.partCard]]'>"
						+ "</memory-card>"
		);
	}
}
