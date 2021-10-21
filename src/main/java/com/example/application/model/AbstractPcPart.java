package com.example.application.model;

import java.io.Serializable;

public abstract class AbstractPcPart implements Serializable {
	private static final long serialVersionUID = 1567499398346596312L;

	private Price price;
	private String name;
	private int stockQuantity;

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
