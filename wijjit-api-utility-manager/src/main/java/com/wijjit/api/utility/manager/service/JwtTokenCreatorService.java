package com.wijjit.api.utility.manager.service;

import com.wijjit.api.utility.manager.dao.IWijjitWalletDao;
import com.wijjit.api.utility.manager.models.PrivateKeys;
import com.wijjit.api.utility.manager.models.UserWallets;
import com.wijjit.api.utility.manager.models.Wallets;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class JwtTokenCreatorService {
	private static Logger logger = LoggerFactory.getLogger(JwtTokenCreatorService.class);

	@Value("${com.wijjit.aes.secret}")
	private String aesSecretKey;

	private IWijjitWalletDao wijjitWalletDao;
	private AesEncryptionService aesEncryptionService;

	public JwtTokenCreatorService(IWijjitWalletDao wijjitWalletDao, AesEncryptionService aesEncryptionServic) {
		this.wijjitWalletDao = wijjitWalletDao;
		this.aesEncryptionService = aesEncryptionServic;
	}

	/**********************************************************************************************************************
	 * * Creates the JWT token for the user.
	 *
	 * @param userName
	 * @return
	 */
	public String createJwtWijjitToken(String userName) throws InterruptedException {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		Date nowPlusTime = new Date(nowMillis + 3600 * 60 * 1000);
		
		JwtBuilder builder = Jwts.builder().setIssuedAt(now).setAudience(userName).setIssuer("wijjitTokenGenerator")
				.setExpiration(nowPlusTime).signWith(SignatureAlgorithm.HS256,
				"1938473939A83729DBEIO847PEMAMDIEY3847DELISOS102930RUYVBN29394001");
				//"wjt_skprod_877d804c_6fc9_4801_a555_0c321352ab72");
		return builder.compact();
	}

	public PrivateKeys decryptWJTKeys(String username) {
		PrivateKeys privateKeys = null;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		// Retrieve wallet info from Database
		UserWallets userWallets = wijjitWalletDao.findByUserName(username);
		logger.debug("User wallet fetched");
		// Cycle through the wallets
		if (userWallets != null) {
			for (Wallets wallets : userWallets.getWallets()) {
				if (wallets.getCryptoType().equals("WJT") && wallets.getPubKey() != null) {
					privateKeys = new PrivateKeys();
					// Set the public key in the hashmap
					hashMap.put("WJT Private key", aesEncryptionService.decrypt(wallets.getPrivKey(), aesSecretKey));
					hashMap.put("WJT Public key", wallets.getPubKey());
					logger.debug("WJT public keys", wallets.getPubKey());

					privateKeys.setPubKeyHashMap(hashMap);
				}
			}
		}
		return privateKeys;
	}
}
