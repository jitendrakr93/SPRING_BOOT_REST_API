package com.jit.boot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConsumerDelete implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(RestConsumerDelete.class);
	@Autowired
	private RestTemplate rt;

	public void run(String... args) throws Exception {
		//1. Define URL
		String url = "http://localhost:8080/std/remove/{id}";
		//2. creating HttpEntity(requestEntity)
		//no head + body
		//3. make HTTP call
		ResponseEntity<String> resp = rt.exchange(url, HttpMethod.DELETE, null, String.class, 101);
		//4. print details
		LOG.info("Status data{}", resp.getStatusCode().name());
		LOG.info("Status code {}", resp.getStatusCodeValue());
		LOG.info("Body {}", resp.getBody());

	}
}