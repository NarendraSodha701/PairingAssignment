package com.assignment.pairing.test.service;

import java.util.List;

import com.assignment.pairing.test.model.TradeStore;



public interface TradeStoreService {

	public boolean tradeStoreValidation(TradeStore tradeStore);

	public void persist(TradeStore tradeStore);

	public List<TradeStore> FindAll();
	
	public void updateExpireFlag();

	

}
