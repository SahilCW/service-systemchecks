package com.service.systemchecks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemChecksController {

	private static final Logger logger = LoggerFactory.getLogger(SystemChecksController.class);
	
	@GetMapping(value="/ping" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String ping() {
		return "System Checks Running";
	}
	
	@PostMapping(value="/hit_trigger" , consumes = MediaType.APPLICATION_JSON_VALUE , produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> hitTrigger(@RequestBody String triggerName){
		
		logger.info("Inside hitTrigger method with Trigger Name==>{}",triggerName);
		
		return null;
	}
	
}
