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
public class RestConsumerExchangePost implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(RestConsumerExchangePost.class);
	@Autowired
	private RestTemplate rt;

	public void run(String... args) throws Exception {
		//1. Define URL
		String url = "http://localhost:8081/std/create";
		//2. HttpEntity=header+body
		String body = "{\"stdId\":100,\"stdName\":\"A\",\"stdFee\":300.0}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
		//3. make request and get response
		//URL, HttpMethod, HttpEntity , responseType,PathVariables
		ResponseEntity<String> resp = rt.exchange(url, HttpMethod.POST, requestEntity, String.class);
		//4. print details
		LOG.info("Status ID {}", resp.getStatusCodeValue());
		LOG.info("Status CODE {}", resp.getStatusCode().name());
		LOG.info("Response Body {}", resp.getBody());
		LOG.info("Response Headers {}", resp.getHeaders());
		System.out.println("================================================");
	}
}