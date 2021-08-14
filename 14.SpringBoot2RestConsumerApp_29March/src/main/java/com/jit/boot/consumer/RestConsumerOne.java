package com.jit.boot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Order(1)
public class RestConsumerOne implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(RestConsumerOne.class);

	@Autowired
	private RestTemplate rt;

	@Override
	public void run(String... args) throws Exception {
		// 1. Define URL of Provider
		String url = "http://localhost:8081/std/data";

		// 2. Create RestTemplate object
		// RestTemplate rt = new RestTemplate();

		// 3. Make call and get Response
		ResponseEntity<String> resp = rt.getForEntity(url, String.class);

		// 4. print details
		LOG.info("Status ID {}", resp.getStatusCodeValue());
		LOG.info("Status CODE {}", resp.getStatusCode().name());
		LOG.info("Response Body {}", resp.getBody());
		LOG.info("Response Headers {}", resp.getHeaders());

		System.out.println("-------------------------------");
		// 5. Stop server manually
		//System.exit(0);

	}

}
