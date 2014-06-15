package org.thwick.moneytracker.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.thwick.moneytracker.models.Account;
import org.thwick.moneytracker.services.AccountService;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class AccountsResource {

	@Inject private AccountService accountService;
    
    public AccountsResource() {

    }
	
	@GET
	public Account[] listAccounts() {
		List<Account> accounts = accountService.findAll();
		
		return accounts.toArray(new Account[0]);
	}
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}