package com.wijjit.api.utility.manager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "#{wijjitPurchaseHistoryCollectionName}")
public class WijjitPurchaseHistory {

	private String _id;
	private String userName;
	
	private String pubKey;
	
	private String numWjts;
	
	private Double wjtPrice;
	
	private Double tranUsdValue;
	
	private String assetTraded;
	
	private String numAssetTraded;
	
	private Double assetTradedPrice;
	
	private String bonusInitiator;
	
	private String transactionType;
	
	private Instant created;

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public String getPubKey() {
		return pubKey;
	}

	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAssetTraded() {
		return assetTraded;
	}

	public void setAssetTraded(String assetTraded) {
		this.assetTraded = assetTraded;
	}

	public Double getAssetTradedPrice() {
		return assetTradedPrice;
	}

	public void setAssetTradedPrice(Double assetTradedPrice) {
		this.assetTradedPrice = assetTradedPrice;
	}

	public Double getWjtPrice() {
		return wjtPrice;
	}

	public void setWjtPrice(Double wjtPrice) {
		this.wjtPrice = wjtPrice;
	}

	public Double getTranUsdValue() {
		return tranUsdValue;
	}

	public void setTranUsdValue(Double tranUsdValue) {
		this.tranUsdValue = tranUsdValue;
	}

	public String getBonusInitiator() {
		return bonusInitiator;
	}

	public void setBonusInitiator(String bonusInitiator) {
		this.bonusInitiator = bonusInitiator;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getNumAssetTraded() {
		return numAssetTraded;
	}

	public void setNumAssetTraded(String numAssetTraded) {
		this.numAssetTraded = numAssetTraded;
	}

	public String getNumWjts() {
		return numWjts;
	}

	public void setNumWjts(String numWjts) {
		this.numWjts = numWjts;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}
