package com.wijjit.api.utility.manager.controller;

import com.wijjit.api.utility.manager.models.TokenType;
import com.wijjit.api.utility.manager.service.JwtTokenCreatorService;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtTokenCreatorController {
	
	private JwtTokenCreatorService creatorService;
	
	public JwtTokenCreatorController(JwtTokenCreatorService creatorService) {
		this.creatorService = creatorService;
	}

	@RequestMapping(value = "/token/{userId}", method = RequestMethod.GET)
	public String createJwtToken(@PathVariable String userId) throws InterruptedException {
		return creatorService.createJwtWijjitToken(userId, TokenType.LOGIN);
	}

	@RequestMapping(value = "/token/validity", method = RequestMethod.GET)
	public String jwtTokenValidity(@RequestHeader("Username") String username) throws InterruptedException {
		return username;
	}

}
