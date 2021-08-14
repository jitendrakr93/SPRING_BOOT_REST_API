package com.jit.boot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConsumerPutEx implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(RestConsumerPutEx.class);
	@Autowired
	private RestTemplate rt;

	public void run(String... args) throws Exception {
		//1. Define URL
		String url = "http://localhost:8080/std/modify";
		//2. creating HttpEntity(requestEntity)
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String body = "{}"; // valid JSON
		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
		//3. make HTTP call
		//rt.put(url, requestEntity);
		ResponseEntity<String> resp = rt.exchange(url, HttpMethod.PUT, requestEntity, String.class);
		//4. print details
		LOG.info("Status data{}", resp.getStatusCode().name());
		LOG.info("Status code {}", resp.getStatusCodeValue());
		LOG.info("Body {}", resp.getBody());


	}
}