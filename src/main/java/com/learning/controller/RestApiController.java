package com.learning.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.learning.model.StringMessage;
import com.learning.model.WordEntry;
import com.learning.service.FibonacciService;
import com.learning.service.RestTemplateService;
import com.learning.service.StringMesssageService;
import com.learning.service.ThreadDemoService;

/**
 * @author Peter Zhou
 *
 */

@RestController
@RequestMapping("/api")
public class RestApiController {
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	StringMesssageService stringMesssageService = new StringMesssageService();

	FibonacciService fibonacciService = new FibonacciService();

	RestTemplateService restTemplateService = new RestTemplateService();

	ThreadDemoService threadDemoService = new ThreadDemoService();

	@RequestMapping(value = "/hellow", method = RequestMethod.GET)
	public ResponseEntity<String> sayHellow() {

		return new ResponseEntity<String>("Hellow World", HttpStatus.OK);
	}

	@RequestMapping(value = "/wordcounts", method = RequestMethod.POST)
	public ResponseEntity<List<WordEntry>> wordCounting(@RequestBody StringMessage message,
			UriComponentsBuilder ucBuilder) {

		List<WordEntry> list = stringMesssageService.processWordCounting(message.getMessage());
		logger.info("couting words occurrences from message : {}", message.getMessage());
		return new ResponseEntity<List<WordEntry>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/fibonacci")
	public ResponseEntity<List<Integer>> getFabionacciNum(
			@RequestParam(value = "number", defaultValue = "1") String number) {

		int num = Integer.parseInt(number);
		List<Integer> list = fibonacciService.getFirstNthFibonacci(num);
		return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/externalservice")
	public ResponseEntity<String> queryExternalService(
			@RequestParam(value = "url", defaultValue = "https://jsonplaceholder.typicode.com/posts") String url) {

		return restTemplateService.queryExternalService(url);

	}

	@RequestMapping(value = "/deadlock")
	public ResponseEntity<List<String>> monitoringDeadlock(
			@RequestParam(value = "timeout", defaultValue = "10000") String number) throws InterruptedException {

		int num = Integer.parseInt(number);
		List<String> list = threadDemoService.monitoringDeadLock(num);
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

}
