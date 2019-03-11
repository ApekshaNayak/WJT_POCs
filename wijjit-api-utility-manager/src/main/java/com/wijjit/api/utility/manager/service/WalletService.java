package com.wijjit.api.utility.manager.service;

import com.wijjit.api.utility.manager.dao.IWijjitWalletDao;
import com.wijjit.api.utility.manager.dao.StellarAccountKeysDao;
import com.wijjit.api.utility.manager.models.PrivateKeys;
import com.wijjit.api.utility.manager.models.UserWallets;
import com.wijjit.api.utility.manager.models.Wallets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WalletService {
    private static Logger logger = LoggerFactory.getLogger(WalletService.class);

    @Value("${com.wijjit.aes.secret}")
    private String aesSecretKey;

    private IWijjitWalletDao wijjitWalletDao;
    private AesEncryptionService aesEncryptionService;
    private StellarAccountKeysDao stellarAccountKeysDaoImpl;

    public WalletService(IWijjitWalletDao wijjitWalletDao, AesEncryptionService aesEncryptionService, StellarAccountKeysDao stellarAccountKeysDaoImpl) {
        this.wijjitWalletDao = wijjitWalletDao;
        this.aesEncryptionService = aesEncryptionService;
        this.stellarAccountKeysDaoImpl = stellarAccountKeysDaoImpl;
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

    public Boolean deleteWalletAccount() {
        try {
            List<UserWallets> userWallets = wijjitWalletDao.findAll();
            for (UserWallets wallets : userWallets) {
                List<Wallets> walletTypes = wallets.getWallets();
                System.out.println("Username: " + wallets.getUserName());
                for (Wallets walletWjt : walletTypes) {
                    if (walletWjt.getCryptoType().equals("WJT")
                            && walletWjt.getPubKey() != null
                            && walletWjt.getPrivKey() != null) {
                        walletWjt.setPrivKey(null);
                        walletWjt.setPubKey(null);
                    }
                }
                wijjitWalletDao.save(wallets);
            }

            return true;
        } catch (Exception ex) {
            System.out.println("Exception while deleting: " + ex.getMessage());
            return false;
        }
    }

    public Boolean encryptStellarAccountKeys(Map<String, String> stellarKeyValuePairs) {
        logger.debug("Encrypting stellar account keys");
        Map<String, String> encryptedKeyValuePairs = new HashMap<>();
        stellarKeyValuePairs.forEach((k, v) -> {
            encryptedKeyValuePairs.put(k, aesEncryptionService.encrypt(v, aesSecretKey));
        });

        return stellarAccountKeysDaoImpl.updateCollection(encryptedKeyValuePairs);
    }
}
