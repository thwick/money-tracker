package org.thwick.moneytracker.models;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class AccountBalance {

	@JsonProperty("accountId")
	private Long accountId;
	
	@JsonProperty("accountName")
	private String accountName;
	
	@JsonProperty("balance")
	private Double balance;
	
	@JsonProperty("currency")
	private String currency;
	
	public AccountBalance() {}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
