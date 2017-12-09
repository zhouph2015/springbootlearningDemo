package com.learning.service;

/**
 * @author Peter Zhou
 *
 */
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateService {
	
	
	public ResponseEntity<String> queryExternalService(String externalurl) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(externalurl,
				String.class);
		
        return response;
	}
}
