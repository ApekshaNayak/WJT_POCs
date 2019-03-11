package com.wijjit.api.utility.manager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "stripe_charge")
public class StripeChargeResponse {

	@Id
	private String id;
	
	private String userName;

	private String userId;

	private String object;

	private Long amount;

	private Long amount_refunded;
	
	private Double amountBy100;
	
	private Double amount_refundedBy100;

	private Boolean captured;

	private long created;

	private String currency;

	private String description;

	private String failureCode;

	private String failureMessage;

	private Boolean livemode;
	
	private String on_behalf_of;

	private String order;

	private Boolean paid;

	private String receipt_email;

	private String receipt_number;

	private Boolean refunded;
	
	private StripeRefunds refunds;

	private Card source;

	private String statementDescriptor;

	private String status;

	private String transferGroup;
	
	private Instant createdTimeStamp;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}

	public Boolean getCaptured() {
		return captured;
	}
	public void setCaptured(Boolean captured) {
		this.captured = captured;
	}
	public long getCreated() {
		return created;
	}
	public void setCreated(long created) {
		this.created = created;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFailureCode() {
		return failureCode;
	}
	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	public Boolean getLivemode() {
		return livemode;
	}
	public void setLivemode(Boolean livemode) {
		this.livemode = livemode;
	}
	public String getOn_behalf_of() {
		return on_behalf_of;
	}
	public void setOn_behalf_of(String on_behalf_of) {
		this.on_behalf_of = on_behalf_of;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	public String getReceipt_email() {
		return receipt_email;
	}
	public void setReceipt_email(String receipt_email) {
		this.receipt_email = receipt_email;
	}
	public String getReceipt_number() {
		return receipt_number;
	}
	public void setReceipt_number(String receipt_number) {
		this.receipt_number = receipt_number;
	}
	public Boolean getRefunded() {
		return refunded;
	}
	public void setRefunded(Boolean refunded) {
		this.refunded = refunded;
	}
	
	public String getStatementDescriptor() {
		return statementDescriptor;
	}
	public void setStatementDescriptor(String statementDescriptor) {
		this.statementDescriptor = statementDescriptor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTransferGroup() {
		return transferGroup;
	}
	public void setTransferGroup(String transferGroup) {
		this.transferGroup = transferGroup;
	}
	public Card getSource() {
		return source;
	}
	public void setSource(Card source) {
		this.source = source;
	}
	public StripeRefunds getRefunds() {
		return refunds;
	}
	public void setRefunds(StripeRefunds refunds) {
		this.refunds = refunds;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Instant getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(Instant createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getAmount_refunded() {
		return amount_refunded;
	}
	public void setAmount_refunded(Long amount_refunded) {
		this.amount_refunded = amount_refunded;
	}
	public Double getAmountBy100() {
		return amountBy100;
	}
	public void setAmountBy100(Double amountBy100) {
		this.amountBy100 = amountBy100;
	}
	public Double getAmount_refundedBy100() {
		return amount_refundedBy100;
	}
	public void setAmount_refundedBy100(Double amount_refundedBy100) {
		this.amount_refundedBy100 = amount_refundedBy100;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
