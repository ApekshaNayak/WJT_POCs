package com.wijjit.api.utility.manager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "#{userWalletsCollectionName}")
public class UserWallets {
	@Id
	private String id;
	
	private String userName;

    private List<Wallets> wallets;
    
    private Instant created;
    
    private float minimumBalanceXLM;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Wallets> getWallets() {
		return wallets;
	}

	public void setWallets(List<Wallets> wallets) {
		this.wallets = wallets;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public float getMinimumBalanceXLM() {
		return minimumBalanceXLM;
	}

	public void setMinimumBalanceXLM(float minimumBalanceXLM) {
		this.minimumBalanceXLM = minimumBalanceXLM;
	}  
}
