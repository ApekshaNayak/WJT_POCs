package com.wijjit.api.utility.manager.models;

import java.time.Instant;

public class Wallets {
	private String cryptoType;
	
	private String privKey;
	
	private String pubKey;
	
	private Instant created;

	public String getCryptoType() {
		return cryptoType;
	}

	public void setCryptoType(String cryptoType) {
		this.cryptoType = cryptoType;
	}

	public String getPrivKey() {
		return privKey;
	}

	public void setPrivKey(String privKey) {
		this.privKey = privKey;
	}

	public String getPubKey() {
		return pubKey;
	}

	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

}
