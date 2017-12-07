package com.learning.service;

import java.util.ArrayList;
import java.util.List;

public class FibonacciService {
	
	public List<Integer> getFirstNthFibonacci(int number) {
		List<Integer> results = new ArrayList<Integer>();

		int[] array = new int[number];
		if (number == 1) {
			results.add(0);
			return results;
		} else if (number == 2) {
			results.add(0);
			results.add(1);
			return results;
		} else if (number > 2) {
			array[0] = 0;
			array[1] = 1;
			results.add(0);
			results.add(1);
			for (int i = 2; i < number; i++) {
				array[i] = array[i - 1] + array[i - 2];
				results.add(array[i]);
			}
			return results;
		} else {
			return results;
		}
	}

}
