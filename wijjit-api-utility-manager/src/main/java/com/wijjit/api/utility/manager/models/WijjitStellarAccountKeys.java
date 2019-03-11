package com.wijjit.api.utility.manager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "#{wijjitStellarAccountKeysCollectionName}")
public class WijjitStellarAccountKeys {

	@Id
	private String _id;
	
	private String label;
	
	private String distributionKeySeed;
	
	private String wjtIssuerKeySeed;
	
	private String invIssuerKeySeed;
	
	private String ourLumenKeySeed;
	
	private String ourWijjitKeySeed;
	
	private String ourInvestorKeySeed;
	
	private String additionalSignerKeySeed;
	
	private String masterSignerKeySeed;
	
	private String wjtBonusSignerKeySeed;

	private String projectSponsorAKeySeed;

	private Instant created;

	public String getDistributionKeySeed() {
		return distributionKeySeed;
	}

	
	public String getWjtBonusSignerKeySeed() {
		return wjtBonusSignerKeySeed;
	}

	public void setWjtBonusSignerKeySeed(String wjtBonusSignerKeySeed) {
		this.wjtBonusSignerKeySeed = wjtBonusSignerKeySeed;
	}

	public void setDistributionKeySeed(String distributionKeySeed) {
		this.distributionKeySeed = distributionKeySeed;
	}

	public String getWjtIssuerKeySeed() {
		return wjtIssuerKeySeed;
	}

	public void setWjtIssuerKeySeed(String wjtIssuerKeySeed) {
		this.wjtIssuerKeySeed = wjtIssuerKeySeed;
	}

	public String getInvIssuerKeySeed() {
		return invIssuerKeySeed;
	}

	public void setInvIssuerKeySeed(String invIssuerKeySeed) {
		this.invIssuerKeySeed = invIssuerKeySeed;
	}

	public String getOurLumenKeySeed() {
		return ourLumenKeySeed;
	}

	public void setOurLumenKeySeed(String ourLumenKeySeed) {
		this.ourLumenKeySeed = ourLumenKeySeed;
	}

	public String getOurWijjitKeySeed() {
		return ourWijjitKeySeed;
	}

	public void setOurWijjitKeySeed(String ourWijjitKeySeed) {
		this.ourWijjitKeySeed = ourWijjitKeySeed;
	}

	public String getOurInvestorKeySeed() {
		return ourInvestorKeySeed;
	}

	public void setOurInvestorKeySeed(String ourInvestorKeySeed) {
		this.ourInvestorKeySeed = ourInvestorKeySeed;
	}

	public String getAdditionalSignerKeySeed() {
		return additionalSignerKeySeed;
	}

	public void setAdditionalSignerKeySeed(String additionalSignerKeySeed) {
		this.additionalSignerKeySeed = additionalSignerKeySeed;
	}

	public String getMasterSignerKeySeed() {
		return masterSignerKeySeed;
	}

	public void setMasterSignerKeySeed(String masterSignerKeySeed) {
		this.masterSignerKeySeed = masterSignerKeySeed;
	}

	public String getProjectSponsorAKeySeed() {	return projectSponsorAKeySeed; }

	public void setProjectSponsorAKeySeed(String projectSponsorAKeySeed) {
		this.projectSponsorAKeySeed = projectSponsorAKeySeed;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
