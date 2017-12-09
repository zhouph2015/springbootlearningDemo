package com.learning.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class FibonacciServiceTest {

	@Test
	public void testGetFirstNthFibonacci() {
		FibonacciService fibonacciService = new FibonacciService();
		
		List<Integer> list = fibonacciService.getFirstNthFibonacci(10);
		// The first 10 Fibonacci number is [0,1,1,2,3,5,8,13,21,34]
		// Test the 10th Fibonacci number is 34
		assertTrue(list.get(9) == 34);
	}

}
