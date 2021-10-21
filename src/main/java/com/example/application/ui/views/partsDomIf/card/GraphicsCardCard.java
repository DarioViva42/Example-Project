package com.example.application.ui.views.partsDomIf.card;

import com.example.application.model.GraphicsCard;

import java.util.stream.Collectors;

public class GraphicsCardCard extends AbstractPcPartCard {

	GraphicsCard pcPart;

	public GraphicsCardCard(GraphicsCard pcPart) {
		this.pcPart = pcPart;
	}

	public static GraphicsCardCard create(GraphicsCard pcPart) {
		return new GraphicsCardCard(pcPart);
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

	public String getConnections() {
		return pcPart.getConnections()
				.map(connectors -> connectors.stream().map(connector -> {
					return connector.getName() + " (v. " + connector.getVersion() + ")";
				}).collect(Collectors.joining(", ")))
				.orElse("no Connectors");
	}

	public String getCoolingSystem() {
		return pcPart.getCoolingSystem().map(coolingSystem -> {
			return coolingSystem.getName() + " (" + coolingSystem.getRpm() + " rpm)";
		}).orElse("no Cooling System");
	}

	public String getPciExpressVersion() {
		return pcPart.getPciExpressVersion()
				.map(String::valueOf)
				.orElse("no Version");
	}

	public String getCardModel() {
		return pcPart.getCardModel().orElse("no Model");
	}

	public static String getTemplateString() {
		return "<graphics-card-card is='dom-if' if='[[item.isGraphicsCard]]'"
				+ " part-card='[[item.partCard]]'>"
				+ "</graphics-card-card>";
	}
}
