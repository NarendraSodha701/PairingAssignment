package com.assignment.pairing.test;

import static org.mockito.Mockito.verify;

import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.assignment.pairing.test.cronJobs.TradeStoreJobs;

@SpringBootTest
@SpringJUnitConfig(TestApplication.class)
// Override the scheduling rate to something really short:
@TestPropertySource(properties = "task.work.rate=100")
public class CronJobsTest {

	@SpyBean
	private TradeStoreJobs tradeStoreJobs;

	@Test
	public void testUpdateExpireFlag() {

		Awaitility.await().atMost(10, TimeUnit.SECONDS)
				.untilAsserted(() -> verify(tradeStoreJobs, Mockito.atLeastOnce()).cronJobs());

	}

}
