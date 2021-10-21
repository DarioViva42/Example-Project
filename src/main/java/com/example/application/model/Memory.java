package com.example.application.model;

import java.io.Serializable;
import java.util.Optional;

public class Memory extends AbstractPcPart implements Serializable {
	private static final long serialVersionUID = 3252683462382274907L;

	private MemoryConfiguration configuration;
	private String formFactor;
	private Integer frequency;

	public Optional<MemoryConfiguration> getConfiguration() {
		return Optional.ofNullable(configuration);
	}

	public void setConfiguration(MemoryConfiguration configuration) {
		this.configuration = configuration;
	}

	public Optional<String> getFormFactor() {
		return Optional.ofNullable(formFactor);
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public Optional<Integer> getFrequency() {
		return Optional.ofNullable(frequency);
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
