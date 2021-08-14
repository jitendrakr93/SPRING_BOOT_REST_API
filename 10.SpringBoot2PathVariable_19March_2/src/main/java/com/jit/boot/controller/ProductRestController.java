package com.jit.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

	@GetMapping("/format/{pcode}")
	public String findDataA(@PathVariable String pcode) {
		return "PATH DATA-A=>" + pcode;
	}

	@GetMapping("/format/{pcost}")
	public String findDataB(@PathVariable Double pcost) {
		return "PATH DATA-B=>" + pcost;
	}
}
