package com.assignment.pairing.test.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.pairing.test.model.TradeStore;
import com.assignment.pairing.test.repository.TradeStoreRepository;

@Service
public class TradeStoreServiceImpl implements TradeStoreService {

	@Autowired
	private TradeStoreRepository tradeStoreRepository;

	@Override
	public boolean tradeStoreValidation(TradeStore tradeStore) {

		// validateMaturityDate
		if (validateMaturityDate(tradeStore)) {

			// 2:get Trade based on tradeStore id
			Optional<TradeStore> trade = tradeStoreRepository.findById(tradeStore.getTradeId());

			if (null != trade && !trade.isEmpty()) {

				// 3:validateVersion

				return validateVersion(tradeStore, trade.get());
			} else {

				return true;
			}

		}

		return false;
	}
	// 1.During transmission if the lower version is being received by the store
	// it will reject the trade and throw an exception

	private boolean validateVersion(TradeStore tradeStore, TradeStore tradeStore2) {

		if (tradeStore.getVersion() >= tradeStore2.getVersion()) {

			return true;
		}
		return false;

	}

	// 2. Store should not allow the trade which has less maturity date then today
	// date.

	private boolean validateMaturityDate(TradeStore tradeStore) {

		if (tradeStore.getMaturityDate().isBefore(LocalDate.now())) {

			return false;

		}

		return true;
	}

	@Override
	public void persist(TradeStore tradeStore) {

		tradeStore.setCreatedDate(LocalDate.now());
		tradeStoreRepository.save(tradeStore);

	}

	// get ALL Trade
	@Override
	public List<TradeStore> FindAll() {

		return tradeStoreRepository.findAll();
	}

	// 3.Store should automatically update expire flag if in a store the trade
	// crosses the maturity date.

	public void updateExpireFlag() {

		tradeStoreRepository.findAll().stream().forEach(trade -> {

			if (!validateMaturityDate(trade)) {

				trade.setExpired("Y");

				tradeStoreRepository.save(trade);
			}

		});

	}
}