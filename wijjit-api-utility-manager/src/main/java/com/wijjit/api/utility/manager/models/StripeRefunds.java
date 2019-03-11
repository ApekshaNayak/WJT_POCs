package com.wijjit.api.utility.manager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StripeRefunds {
	private String[] data;
	
	private Boolean has_more;

	private String object;
	
	private Integer total_count;

	private String url;

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	public Boolean getHas_more() {
		return has_more;
	}

	public void setHas_more(Boolean has_more) {
		this.has_more = has_more;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Integer getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
