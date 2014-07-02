package org.thwick.moneytracker.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "account")
@XmlRootElement
public class Account {

	@Id
	@Column(name = "account_pkid")
	@JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "account_name")
	@JsonProperty("accountName")
	private String accountName;
	
	@Column(name = "description")
	@JsonProperty("description")
	private String description;
	
	@Column(name = "retirement")
	@JsonProperty("retirement")
	private Boolean retirement;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String name) {
		this.accountName = name;
	}

	public Boolean getRetirement() {
		return retirement;
	}

	public void setRetirement(Boolean retirement) {
		this.retirement = retirement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountName=" + accountName + ", description=" + description + ", retirement="
				+ retirement + "]";
	}
    
}
