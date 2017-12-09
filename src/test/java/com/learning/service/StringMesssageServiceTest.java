package com.learning.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.learning.model.WordEntry;

public class StringMesssageServiceTest {

	@Test
	public void testprocessWordCounting() {
		StringMesssageService stringMesssageService = new StringMesssageService();
		List<WordEntry> list = stringMesssageService.processWordCounting("snowing snowing snowing, Austin is");
		assertTrue(list.get(2).getWord().equals("snowing"));
		assertTrue(list.get(2).getCount() == 3);
		
		
	}

}
