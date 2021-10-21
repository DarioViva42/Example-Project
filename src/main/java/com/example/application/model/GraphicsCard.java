package com.example.application.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class GraphicsCard extends AbstractPcPart implements Serializable {
	private static final long serialVersionUID = 652062881903257615L;

	private List<Connector> connections;
	private CoolingSystem coolingSystem;
	private Integer PciExpressVersion;
	private String cardModel;

	public Optional<List<Connector>> getConnections() {
		return Optional.ofNullable(connections);
	}

	public void setConnections(List<Connector> connections) {
		this.connections = connections;
	}

	public Optional<CoolingSystem> getCoolingSystem() {
		return Optional.ofNullable(coolingSystem);
	}

	public void setCoolingSystem(CoolingSystem coolingSystem) {
		this.coolingSystem = coolingSystem;
	}

	public Optional<Integer> getPciExpressVersion() {
		return Optional.ofNullable(PciExpressVersion);
	}

	public void setPciExpressVersion(int pciExpressVersion) {
		PciExpressVersion = pciExpressVersion;
	}

	public Optional<String> getCardModel() {
		return Optional.ofNullable(cardModel);
	}

	public void setCardModel(String cardModel) {
		this.cardModel = cardModel;
	}
}
