package com.example.application.ui.views.partsComponent.card;

import com.example.application.model.Memory;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;

@Tag("memory-component")
public class MemoryCard extends AbstractPcPartCard {
	private static final long serialVersionUID = -8954098740536795286L;
	Memory pcPart;

	public MemoryCard(Memory pcPart) {
		this.pcPart = pcPart;

//		FormLayout layout = new FormLayout();

		Span name = new Span(pcPart.getName());
		Span price = new Span(this.getPrice());
		Span stock = new Span(this.getStock());
		Span config = new Span(this.getConfiguration());
		Span form = new Span(this.getFormFactor());
		Span frequency = new Span(this.getFrequency());

		setResponsiveSteps(
			new ResponsiveStep("0", 3),
			new ResponsiveStep("1200px", 6));

		add(name, price, stock, config, form, frequency);
//		this.getElement().appendChild(name.getElement());

//		add(layout);
	}

	private String getPrice() {
		int price = pcPart.getPrice().getPrice();
		String currency = pcPart.getPrice().getCurrency();

		return price + " " + currency;
	}

	private String getStock() {
		return pcPart.getStockQuantity() + " Pieces";
	}

	private String getConfiguration() {
		return pcPart.getConfiguration().map(memoryConfiguration -> {
			int mpm = memoryConfiguration.getMemoryPerModule();
			int nom = memoryConfiguration.getNumberOfModules();

			return nom + " × " + mpm + " GB";
		}).orElse("no Configuration");
	}

	private String getFrequency() {
		return pcPart.getFrequency().map(String::valueOf).orElse("no Frequency");
	}

	private String getFormFactor() {
		return pcPart.getFormFactor().orElse("no Form Factor");
	}
}
