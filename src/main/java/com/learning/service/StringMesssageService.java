package com.learning.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.learning.model.StringMessage;
import com.learning.model.WordEntry;

public class StringMesssageService {

	HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();

	public List<WordEntry> processWordCounting(String message) {
		wordsMap.clear();
		List<WordEntry> results = new ArrayList<WordEntry>();
		String[] arr = message.split("[^a-zA-Z0-9]+");
		for (String word : arr) {
			if (wordsMap.containsKey(word)) {
				wordsMap.put(word, wordsMap.get(word) + 1);
			} else {
				wordsMap.put(word, 1);
			}
		}
		
		Iterator<Map.Entry<String, Integer>> it = wordsMap.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			results.add(new WordEntry(entry.getKey(), entry.getValue()));
		}
		return results;
		
	}

}
