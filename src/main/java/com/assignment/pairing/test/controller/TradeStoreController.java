package com.assignment.pairing.test.controller;

import java.util.List;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.pairing.test.exception.TradeStoreValidationException;
import com.assignment.pairing.test.model.TradeStore;
import com.assignment.pairing.test.service.TradeStoreService;
import com.assignment.pairing.test.service.TradeStoreServiceImpl;

@RestController
public class TradeStoreController {

	@Autowired
	private TradeStoreService tradeStoreService;

	@PostMapping(path = "/v1/tradeStore/Validation")
	public ResponseEntity<String> tradeStoreValidation(@RequestBody TradeStore tradeStore) throws HttpException {

		if (tradeStoreService.tradeStoreValidation(tradeStore)) {

			tradeStoreService.persist(tradeStore);
		} else {

			throw new TradeStoreValidationException(HttpStatus.NOT_FOUND,"Trade store validation failed and  tradestore is not found  " +tradeStore.getTradeId());
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping(path = "/v1/getAllTrades")
	public List<TradeStore> findAllTrades() {

		return tradeStoreService.FindAll();
	}

}
