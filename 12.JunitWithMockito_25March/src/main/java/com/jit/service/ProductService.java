package com.jit.service;

public class ProductService {
	private CalculateService cs;

	public void setCs(CalculateService cs) {
		this.cs = cs;
	}

	public String getFinalMsg(double basecost, int qty, double disc) {
		return "Total cost is " + cs.getFinalCost(basecost, qty, disc);
	}
}