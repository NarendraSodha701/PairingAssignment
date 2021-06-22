package com.assignment.pairing.test.cronJobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.assignment.pairing.test.service.TradeStoreService;

@Component
public class TradeStoreJobs {

	@Autowired
	TradeStoreService tradeStoreService;
    // Control rate with property `task.work.rate` and use 3600000 (1 hour) as a default:

	 @Scheduled(fixedRateString = "${task.work.rate:3600000}")
	public void cronJobs() {

		tradeStoreService.updateExpireFlag();
	}

}
