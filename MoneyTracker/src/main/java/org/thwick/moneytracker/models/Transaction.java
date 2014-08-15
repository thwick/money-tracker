package org.thwick.moneytracker.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="account_id")
	private Account account;
	
	@JsonProperty("accountId")
	private Long accountId;
	
	@Column(name = "description")
	@JsonProperty("description")
	private String description;
	
	@Column(name = "amount")
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@JsonProperty("categoryId")
	private Long categoryId;
	
	@JsonProperty("categoryName")
	private Long categoryName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="category_id")
	private Category category;
	
	@Column(name = "transaction_dt")
	@JsonProperty("transactionDt")
	private Date transactionDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getAccountId() {
		return accountId;
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
		return category.getId();
	}

	public String getCategoryName() {
		return category.getCategoryName();
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}
	
	
}
