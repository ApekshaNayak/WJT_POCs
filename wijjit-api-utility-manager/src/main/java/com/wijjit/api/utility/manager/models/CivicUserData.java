package com.wijjit.api.utility.manager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection = "#{userCivicDataCollectionName}")
public class CivicUserData {
	@Id
	private String civicUserId;
	private String userName;
	
	private CivicAuthInformation authInfo;
	private CivicKycInformation kycInfo;
	/*@NotNull
	private String label;	
	@NotNull	
	private String value;	
	@NotNull
	private String isValid;
	@NotNull
	private String isOwner; */
	
	private String civicUserToken;
	
	/*private String typeOfData;*/
	
	private Instant insertionTimestamp;	
	
	private Instant civicUserTokenUpdationTimestamp;
	
	private boolean isKyc;
	
	/*public String getTypeOfData() {
		return typeOfData;
	}

	public void setTypeOfData(String typeOfData) {
		this.typeOfData = typeOfData;
	}
*/
	
	public String getCivicUserToken() {
		return civicUserToken;
	}

	public void setCivicUserToken(String civicUserToken) {
		this.civicUserToken = civicUserToken;
	}

	public Instant getCivicUserTokenUpdationTimestamp() {
		return civicUserTokenUpdationTimestamp;
	}

	public void setCivicUserTokenUpdationTimestamp(Instant civicUserTokenUpdationTimestamp) {
		this.civicUserTokenUpdationTimestamp = civicUserTokenUpdationTimestamp;
	}

	/*
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(String isOwner) {
		this.isOwner = isOwner;
	} */


	public Instant getInsertionTimestamp() {
		return insertionTimestamp;
	}

	public void setInsertionTimestamp(Instant insertionTimestamp) {
		this.insertionTimestamp = insertionTimestamp;
	}

	public String getCivicUserId() {
		return civicUserId;
	}

	public void setCivicUserId(String civicUserId) {
		this.civicUserId = civicUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public CivicAuthInformation getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(CivicAuthInformation authInfo) {
		this.authInfo = authInfo;
	}

	public CivicKycInformation getKycInfo() {
		return kycInfo;
	}

	public void setKycInfo(CivicKycInformation kycInfo) {
		this.kycInfo = kycInfo;
	}

	public boolean isKyc() {
		return isKyc;
	}

	public void setKyc(boolean isKyc) {
		this.isKyc = isKyc;
	}
}
