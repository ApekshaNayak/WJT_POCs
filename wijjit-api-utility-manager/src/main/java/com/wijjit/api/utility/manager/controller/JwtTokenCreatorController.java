package com.wijjit.api.utility.manager.controller;

import com.wijjit.api.utility.manager.models.PrivateKeys;
import com.wijjit.api.utility.manager.service.JwtTokenCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtTokenCreatorController {
	
	private JwtTokenCreatorService creatorService;
	
	public JwtTokenCreatorController(JwtTokenCreatorService creatorService) {
		this.creatorService = creatorService;
	}

	@RequestMapping(value = "/token/{username}", method = RequestMethod.GET)
	public String createJwtToken(@PathVariable String username) throws InterruptedException {
		return creatorService.createJwtWijjitToken(username);
	}

	@RequestMapping(value = "/decryptPrivateKey/{username}", method = RequestMethod.GET)
	public ResponseEntity<PrivateKeys> decryptPrivateKeyForUser(@PathVariable String username){
		return new ResponseEntity<>(creatorService.decryptWJTKeys(username), HttpStatus.OK);
	}
}
