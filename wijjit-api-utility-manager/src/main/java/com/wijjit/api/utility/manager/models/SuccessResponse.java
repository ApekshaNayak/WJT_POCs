package com.wijjit.api.utility.manager.models;

/**
 * @author abhishekshan
 *
 */
public class SuccessResponse implements IApiResponse {

	private String message;

	public SuccessResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
