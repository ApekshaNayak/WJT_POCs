package com.wijjit.api.utility.manager.controller;

import com.wijjit.api.utility.manager.models.PrivateKeys;
import com.wijjit.api.utility.manager.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class WalletController {

	private WalletService walletService;

	public WalletController(WalletService walletService) {
		this.walletService = walletService;
	}

	@RequestMapping(value = "/decryptPrivateKey/{username}", method = RequestMethod.GET)
	public ResponseEntity<PrivateKeys> decryptPrivateKeyForUser(@PathVariable String username){
		return new ResponseEntity<>(walletService.decryptWJTKeys(username), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteWalletAccounts", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteWalletAccountForUser(){
		return new ResponseEntity<>(walletService.deleteWalletAccount(), HttpStatus.OK);
	}

	@RequestMapping(value = "/encryptAndSaveStellarAccountKeys", method = RequestMethod.POST)
	public ResponseEntity<Boolean> encryptAndSaveStellarAccountKeys(@RequestBody HashMap<String, String> stellarKeyValuePairs){
		return new ResponseEntity<>(walletService.encryptStellarAccountKeys(stellarKeyValuePairs), HttpStatus.OK);
	}
}
