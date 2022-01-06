package com.example.application.ui.views.partsComponent.card;

import com.example.application.model.GraphicsCard;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;

import java.util.stream.Collectors;

@Tag("graphics-card-component")
public class GraphicsCardCard extends AbstractPcPartCard {
	private static final long serialVersionUID = -5813124388374902829L;

	GraphicsCard pcPart;

	public GraphicsCardCard(GraphicsCard pcPart) {
		this.pcPart = pcPart;

		FormLayout layout = new FormLayout();

		Span name = new Span(pcPart.getName());
		Span price = new Span(this.getPrice());
		Span stock = new Span(this.getStock());
		Span model = new Span(this.getCardModel());
		Span connections = new Span(this.getConnections());
		Span pci = new Span(this.getPciExpressVersion());
		Span cooling = new Span(this.getCoolingSystem());

		layout.add(name, price, stock, model, connections, pci, cooling);
		layout.setColspan(connections, 2);

		layout.setResponsiveSteps(
				new FormLayout.ResponsiveStep("0", 3),
				new FormLayout.ResponsiveStep("1200px", 6));

		add(layout);

		//this.getElement().appendChild(layout.getElement());
	}

	private String getPrice() {
		int price = pcPart.getPrice().getPrice();
		String currency = pcPart.getPrice().getCurrency();

		return price + " " + currency;
	}

	private String getStock() {
		return pcPart.getStockQuantity() + " Pieces";
	}

	private String getConnections() {
		return pcPart.getConnections()
				.map(connectors -> connectors.stream().map(connector -> {
					return connector.getName() + " (v. " + connector.getVersion() + ")";
				}).collect(Collectors.joining(", ")))
				.orElse("no Connectors");
	}

	private String getCoolingSystem() {
		return pcPart.getCoolingSystem().map(coolingSystem -> {
			return coolingSystem.getName() + " (" + coolingSystem.getRpm() + " rpm)";
		}).orElse("no Cooling System");
	}

	private String getPciExpressVersion() {
		return pcPart.getPciExpressVersion()
				.map(String::valueOf)
				.orElse("no Version");
	}

	private String getCardModel() {
		return pcPart.getCardModel().orElse("no Model");
	}
}
