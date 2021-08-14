package com.jit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jit.service.CalculateService;
import com.jit.service.ProductService;

public class TestCalcukateServiceTwo {
	@Mock
	private CalculateService cs;
	
	@InjectMocks
	private ProductService ps;
	
	private String expected;
	private double basecost;
	private int qty;
	private double disc;
	private String actual;

	@BeforeEach
	public void setup() {
		//activate Mocking Annotations
		MockitoAnnotations.initMocks(this);
		expected = "Total cost is 1000.0";
		basecost = 200.0;
		qty = 10;
		disc = 100.0;
		//ps = new ProductService();
	}

	@Test
	public void testGetFinalCost() {
		when(cs.getFinalCost(basecost, qty, disc)).thenReturn((basecost - disc) * qty);
		//ps.setCs(cs);
		actual = ps.getFinalMsg(basecost, qty, disc);
		assertEquals(expected, actual);
	}

	@AfterEach
	public void clean() {
		cs = null;
		basecost = disc = 0.0;
		qty = 0;
		expected = actual = null;
	}
}