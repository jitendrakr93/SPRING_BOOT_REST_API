package com.jit.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

	@GetMapping("/data")
	public String showData(@RequestParam Integer pid, @RequestParam String pcode, @RequestParam Double pcost) {
		return "HELLO=>"+pid+","+pcode+","+pcost;
	}
}
