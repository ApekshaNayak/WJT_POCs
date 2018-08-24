package com.wijjit.api.utility.manager.models;

import java.util.HashMap;

public class PrivateKeys {

    private HashMap<String, String> priKeyHashMap;

	/**
	 * @return the pubKeyHashMap
	 */
	public HashMap<String, String> getPriKeyHashMap() {
		return priKeyHashMap;
	}

	/**
	 * @param pubKeyHashMap the pubKeyHashMap to set
	 */
	public void setPubKeyHashMap(HashMap<String, String> pubKeyHashMap) {
		this.priKeyHashMap = pubKeyHashMap;
	}
}
