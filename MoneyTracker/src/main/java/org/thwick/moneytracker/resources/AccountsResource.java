package org.thwick.moneytracker.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.thwick.moneytracker.models.Account;
import org.thwick.moneytracker.models.AccountBalance;
import org.thwick.moneytracker.models.Transaction;
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
	
	@POST
	public Account update(Account account) {
		
		if (account.getRetirement() == null) {
			account.setRetirement(false);
		}
		
		if (account.getId() != null) {
			return accountService.update(account);
		} 

		return accountService.newAccount(account);
	}
	
	@GET  @Path("{id}")
	public Account find(@PathParam("id") Long id) {
		Account account = accountService.find(id);
		
		return account;
	}
	
	@GET  @Path("{id}/transactions")
	public List<Transaction> findTransactions(@PathParam("id") Long id) {
		return accountService.findAccountTransactions(id);
	}
	
	@GET  @Path("{id}/balance")
	public AccountBalance getBalance(@PathParam("id") Long id) {
		return accountService.getAccountBalance(id);
	}
	
	@DELETE @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void delete(@PathParam("id") Long id) {
		accountService.delete(id);
    }

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}