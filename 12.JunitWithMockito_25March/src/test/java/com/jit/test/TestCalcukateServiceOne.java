package com.jit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import com.jit.service.CalculateService;
import com.jit.service.ProductService;

public class TestCalcukateServiceOne {
	@Test
	public void testGetFinalCost() {
		String expected = "Total cost is 1000.0";
		double basecost = 200.0;
		int qty = 10;
		double disc = 100.0;
		CalculateService cs = mock(CalculateService.class);
		when(cs.getFinalCost(basecost, qty, disc)).thenReturn((basecost - disc) * qty);
		ProductService ps = new ProductService();
		ps.setCs(cs);
		String actual = ps.getFinalMsg(basecost, qty, disc);
		assertEquals(expected, actual);
	}
}