package com.assignment.pairing.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.List;

import org.apache.http.HttpException;
import org.awaitility.Awaitility;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.assignment.pairing.test.controller.TradeStoreController;
import com.assignment.pairing.test.cronJobs.TradeStoreJobs;
import com.assignment.pairing.test.model.TradeStore;

@SpringBootTest

public class TestApplicationTests {

	@Test
	void contextLoads() {

	}

	@Autowired
	public TradeStoreController tradeStoreController;

	@SpyBean
	private TradeStoreJobs tradeStoreJobs;

	@Test
	public void testTradeStoreValidationlowerVersion() throws HttpException {

		// create trade with lower version
		ResponseEntity<?> responseEntity = tradeStoreController
				.tradeStoreValidation(buildTrade("T1", 2, LocalDate.now()));

		assertEquals(ResponseEntity.status(HttpStatus.OK).build(), responseEntity);

		List<TradeStore> trades = tradeStoreController.findAllTrades();

		assertEquals(1, trades.size());
		assertEquals("T1", trades.get(0).getTradeId());

		assertEquals(2, trades.get(0).getVersion());
		assertEquals("B1", trades.get(0).getBookId());

		try {
			ResponseEntity<?> responseEntityLowerVersion = tradeStoreController
					.tradeStoreValidation(buildTrade("T1", 1, LocalDate.now()));

		} catch (Exception e) {
			System.out.println("responseEntityLowerVersion " + e.getMessage());

		}

		List<TradeStore> tradeslsttwo = tradeStoreController.findAllTrades();

		assertEquals(1, tradeslsttwo.size());
		assertEquals("T1", tradeslsttwo.get(0).getTradeId());

		assertEquals(2, tradeslsttwo.get(0).getVersion());
		assertEquals("B1", tradeslsttwo.get(0).getBookId());
	}

	@Test
	public void testTradeStoreValidationSameVersion() throws HttpException {

		ResponseEntity<?> responseEntity = tradeStoreController
				.tradeStoreValidation(buildTrade("T1", 2, LocalDate.now()));

		assertEquals(ResponseEntity.status(HttpStatus.OK).build(), responseEntity);

		List<TradeStore> trades = tradeStoreController.findAllTrades();

		assertEquals(1, trades.size());
		assertEquals("T1", trades.get(0).getTradeId());

		assertEquals(2, trades.get(0).getVersion());
		assertEquals("B1", trades.get(0).getBookId());

		// same version

		TradeStore tradeStoreSameversion = buildTrade("T1", 2, LocalDate.now());
		tradeStoreSameversion.setBookId("B1");

		ResponseEntity<?> responseEntitySAmeVersion = tradeStoreController.tradeStoreValidation(tradeStoreSameversion);

		assertEquals(ResponseEntity.status(HttpStatus.OK).build(), responseEntitySAmeVersion);

		List<TradeStore> tradesSameVersion = tradeStoreController.findAllTrades();

		assertEquals(1, tradesSameVersion.size());
		assertEquals("T1", tradesSameVersion.get(0).getTradeId());

		assertEquals(2, tradesSameVersion.get(0).getVersion());
		assertEquals("B1", tradesSameVersion.get(0).getBookId());
	}

	@Test
	public void testTradeStoreValidation() throws HttpException {

		ResponseEntity<?> responseEntity = tradeStoreController
				.tradeStoreValidation(buildTrade("T1", 1, LocalDate.now()));

		assertEquals(ResponseEntity.status(HttpStatus.OK).build(), responseEntity);

		List<TradeStore> trades = tradeStoreController.findAllTrades();

		assertEquals(1, trades.size());
		assertEquals("T1", trades.get(0).getTradeId());

	}

	@Test
	public void testTradeStoreValidationMaturityDateLessthantoday() {

		try {

			LocalDate date = LocalDate.of(2015, 05, 21);
			ResponseEntity<?> responseEntity = tradeStoreController.tradeStoreValidation(buildTrade("T2", 1, date));
		} catch (Exception e) {

			System.out.println("trade not allowed " + e.getMessage());
		}

	}

	private TradeStore buildTrade(String tradeId, int version, LocalDate maturityDate) {

		TradeStore tradeStore = new TradeStore();
		tradeStore.setTradeId(tradeId);
		tradeStore.setVersion(version);
		tradeStore.setCounterId("CP-1");
		tradeStore.setBookId("B1");
		tradeStore.setMaturityDate(maturityDate);

		return tradeStore;
	}



}
