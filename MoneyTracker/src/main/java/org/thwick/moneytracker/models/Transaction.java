package org.thwick.moneytracker.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "transaction")
@XmlRootElement
public class Transaction {

	@Id
	@Column(name = "account_transaction_pkid")
	@JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "account_id")
	@JsonProperty("accountId")
	private Long accountId;
	
	@Column(name = "description")
	@JsonProperty("description")
	private String description;
	
	@Column(name = "amount")
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@Column(name = "category_id")
	@JsonProperty("categoryId")
	private Long categoryId;
	
	@Column(name = "transaction_dt")
	@JsonProperty("transactionDt")
	private Date transactionDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}
	
	
}
