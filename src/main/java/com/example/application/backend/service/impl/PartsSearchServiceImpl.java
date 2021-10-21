package com.example.application.backend.service.impl;

import com.example.application.backend.service.PartsSearchService;
import com.example.application.model.AbstractPcPart;
import com.example.application.model.Connector;
import com.example.application.model.CoolingSystem;
import com.example.application.model.GraphicsCard;
import com.example.application.model.Memory;
import com.example.application.model.MemoryConfiguration;
import com.example.application.model.Price;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartsSearchServiceImpl implements PartsSearchService {
	@Override
	public List<AbstractPcPart> search() {
		List<AbstractPcPart> pcParts = new ArrayList<>();

		Price normalPrice = new Price();
		normalPrice.setPrice(20);
		normalPrice.setCurrency("CHF");

		MemoryConfiguration smallConfiguration = new MemoryConfiguration();
		smallConfiguration.setMemoryPerModule(4);
		smallConfiguration.setNumberOfModules(2);

		Memory standardRamPack = new Memory();
		standardRamPack.setName("Standard RAM Pack");
		standardRamPack.setPrice(normalPrice);
		standardRamPack.setStockQuantity(20);
		standardRamPack.setFrequency(2400);
		standardRamPack.setConfiguration(smallConfiguration);
		standardRamPack.setFormFactor("DDR3 SO-DIMM");

		Price expensivePrice = new Price();
		expensivePrice.setPrice(400);
		expensivePrice.setCurrency("CHF");

		CoolingSystem brokenCoolingSystem = new CoolingSystem();
		brokenCoolingSystem.setName("Cooler Master");
		brokenCoolingSystem.setRpm(30);

		List<Connector> connections = new ArrayList<>();
		connections.add(new Connector("HDMI", 4));
		connections.add(new Connector("DVI", 2));
		connections.add(new Connector("Display Port", 3));
		connections.add(new Connector("VGA", 1));

		GraphicsCard standardGraphicsCard = new GraphicsCard();
		standardGraphicsCard.setName("Standard Graphics Card");
		standardGraphicsCard.setPrice(normalPrice);
		standardGraphicsCard.setStockQuantity(2);
		standardGraphicsCard.setCoolingSystem(brokenCoolingSystem);
		standardGraphicsCard.setCardModel("GTX 1050 Ti");
		standardGraphicsCard.setConnections(connections);
		standardGraphicsCard.setPciExpressVersion(4);

		MemoryConfiguration bigConfiguration = new MemoryConfiguration();
		bigConfiguration.setMemoryPerModule(16);
		bigConfiguration.setNumberOfModules(4);

		Memory qualityRamPack = new Memory();
		qualityRamPack.setName("Quality RAM Pack");
		qualityRamPack.setPrice(expensivePrice);
		qualityRamPack.setStockQuantity(3);
		qualityRamPack.setFrequency(3600);
		qualityRamPack.setConfiguration(bigConfiguration);
		qualityRamPack.setFormFactor("DDR4 DIMM");

		pcParts.add(standardRamPack);
		pcParts.add(standardGraphicsCard);
		pcParts.add(qualityRamPack);

		return pcParts;
	}

	@Override
	public List<Memory> onlyMemory() {
		List<Memory> pcParts = new ArrayList<>();

		Price normalPrice = new Price();
		normalPrice.setPrice(20);
		normalPrice.setCurrency("CHF");

		MemoryConfiguration smallConfiguration = new MemoryConfiguration();
		smallConfiguration.setMemoryPerModule(4);
		smallConfiguration.setNumberOfModules(2);

		Memory standardRamPack = new Memory();
		standardRamPack.setName("Standard RAM Pack");
		standardRamPack.setPrice(normalPrice);
		standardRamPack.setStockQuantity(20);
		standardRamPack.setFrequency(2400);
		standardRamPack.setConfiguration(smallConfiguration);
		standardRamPack.setFormFactor("DDR3 SO-DIMM");

		Price expensivePrice = new Price();
		expensivePrice.setPrice(400);
		expensivePrice.setCurrency("CHF");

		MemoryConfiguration bigConfiguration = new MemoryConfiguration();
		bigConfiguration.setMemoryPerModule(16);
		bigConfiguration.setNumberOfModules(4);

		Memory qualityRamPack = new Memory();
		qualityRamPack.setName("Quality RAM Pack");
		qualityRamPack.setPrice(expensivePrice);
		qualityRamPack.setStockQuantity(3);
		qualityRamPack.setFrequency(3600);
		qualityRamPack.setConfiguration(bigConfiguration);
		qualityRamPack.setFormFactor("DDR4 DIMM");

		pcParts.add(standardRamPack);
		pcParts.add(qualityRamPack);

		return pcParts;
	}
}
