package com.jit.boot.consumer;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jit.boot.model.Student;

@Component
public class RestConsumerGetClassTypeAll implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(RestConsumerGetClassTypeAll.class);
	@Autowired
	private RestTemplate rt;

	public void run(String... args) throws Exception {
		//1. Define URL of Provider
		String url = "http://localhost:8080/std/all";
		//2. Make call and get Response
		//ResponseEntity<String> resp = rt.getForEntity(url,String.class);
		ResponseEntity<Student[]> resp = rt.getForEntity(url, Student[].class);
		//3. print details
		LOG.info("Status ID {}", resp.getStatusCodeValue());
		LOG.info("Status CODE {}", resp.getStatusCode().name());
		LOG.info("Response Body {}", Arrays.asList(resp.getBody()));
		LOG.info("Response Headers {}", resp.getHeaders());
	}
}