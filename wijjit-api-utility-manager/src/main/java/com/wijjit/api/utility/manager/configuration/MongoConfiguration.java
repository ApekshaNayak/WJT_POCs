package com.wijjit.api.utility.manager.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

	@Value("${com.wijjit.mongodb.collection.user.profile:user_profile}")
	private String userProfileCollectionName;
	
	@Bean
	public String userProfileCollectionName() {
		return this.userProfileCollectionName;
	}
	
	@Value("${com.wijjit.mongodb.collection.wijjit.wallet:wijjit_wallet}")
	private String wijjitWalletCollectionName;

	@Value("${com.wijjit.mongodb.collection.user.wallets:user_wallets}")
	private String userWalletsCollectionName;

	@Bean
	public String userWalletsCollectionName() {
		return this.userWalletsCollectionName;
	}

	@Value("${com.wijjit.mongodb.collection.wijjit.purchase.history:wijjit_purchase_history}")
	private String wijjitPurchaseHistoryCollectionName;
		
	@Bean
	public String wijjitPurchaseHistoryCollectionName() {
		return this.wijjitPurchaseHistoryCollectionName;
	}

	@Value("${com.wijjit.mongodb.collection.user.civic.data:user_civic_data}")
	private String userCivicDataCollectionName;

	@Bean
	public String userCivicDataCollectionName() {
		return this.userCivicDataCollectionName;
	}
}
